package dk.youtec.drchannels.service

import android.annotation.TargetApi
import android.app.AlarmManager
import android.app.PendingIntent
import androidx.lifecycle.Observer
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.media.tv.TvContract
import android.os.Build
import android.util.Log
import androidx.core.content.getSystemService
import androidx.core.net.toUri
import androidx.core.util.forEach
import androidx.tvprovider.media.tv.Channel
import androidx.tvprovider.media.tv.PreviewProgram
import androidx.tvprovider.media.tv.TvContractCompat
import androidx.work.*
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.utils.TvContractUtils
import dk.youtec.drchannels.ui.PlayerActivity
import dk.youtec.drchannels.util.SharedPreferences
import dk.youtec.drchannels.util.serverDateFormat
import java.util.*

private val TAG = CurrentProgramsPreviewUpdater::class.java.simpleName

@TargetApi(Build.VERSION_CODES.O)
class CurrentProgramsPreviewUpdater(
        context: Context,
        workerParams: WorkerParameters
) : Worker(context, workerParams) {
    private lateinit var contentResolver: ContentResolver

    override fun doWork(): Result {
        contentResolver = applicationContext.contentResolver
        val channelKey = "channelId"
        //Id of preview channel
        val previewChannelId = SharedPreferences.getLong(applicationContext, channelKey)
        if (previewChannelId > 0L) {
            contentResolver
                    .query(TvContractCompat.buildChannelUri(previewChannelId),
                            null, null, null, null)
                    ?.use { cursor ->
                        if (cursor.moveToNext()) {
                            val channel = Channel.fromCursor(cursor)
                            synchronized(CurrentProgramsPreviewUpdater::class.java) {
                                Log.v(TAG,
                                        "Updating programs for channel ${channel.displayName} with id ${channel.id}")
                                //update channel's programs
                                updatePrograms(previewChannelId)
                            }
                        }
                    }
        }
        return Result.SUCCESS
    }

    private fun updatePrograms(previewChannelId: Long) {
        val now = System.currentTimeMillis()
        var nextProgramFinishTime = Long.MAX_VALUE

        val existingPreviewPrograms = getPreviewPrograms(previewChannelId)

        //Remove expired programs
        existingPreviewPrograms
                .asSequence()
                .filter { now >= it.endTimeUtcMillis }
                .forEach { expired ->
                    //Delete the existing preview
                    if (contentResolver.delete(TvContractCompat.buildPreviewProgramUri(expired.id),
                                    null, null) > 0) {
                        Log.d(TAG,
                                "Deleted expired preview program ${expired.title} with id ${expired.id}")
                    }
                }

        //Get current programs from the Live Channels content provider.
        //Update existing or add new preview programs
        val channels = TvContractUtils.buildChannelMap(contentResolver,
                applicationContext.getString(dk.youtec.drchannels.R.string.channelInputId))
        channels.forEach { id, _ ->
            TvContractUtils.getPrograms(contentResolver, TvContract.buildChannelUri(id))
                    .asSequence()
                    .filter { it.startTimeUtcMillis <= now && now < it.endTimeUtcMillis }
                    .forEach { program ->
                        //Find the next time to start updating previews
                        nextProgramFinishTime = nextProgramFinishTime.coerceAtMost(program.endTimeUtcMillis)

                        updateProgram(program, previewChannelId, existingPreviewPrograms)
                    }
        }

        if (nextProgramFinishTime < Long.MAX_VALUE) {
            scheduleNextProgramsUpdate(nextProgramFinishTime)
        } else {
            Log.w(TAG, "No program finish time for scheduling next job")
        }
    }

    /**
     * Removes any existing program from the channel and insert the new one.
     */
    private fun updateProgram(program: Program, previewChannelId: Long, existingPreviewPrograms: List<PreviewProgram>) {
        val intent = Intent(applicationContext, PlayerActivity::class.java).apply {
            action = PlayerActivity.ACTION_VIEW
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
            data = program.internalProviderData.videoUrl.toUri()
        }

        val title = with(program) {
            if (episodeTitle?.isNotBlank() == true) "$title - $episodeTitle" else title
        }

        //If a current broadcast, then add it to our channel
        val previewProgram =
                PreviewProgram.Builder()
                        .setChannelId(previewChannelId)
                        .setType(TvContractCompat.PreviewPrograms.TYPE_CHANNEL)
                        .setTitle(title)
                        .setDescription(program.description)
                        .setIntent(intent)
                        .setInternalProviderId(program.internalProviderData.videoUrl)
                        .setStartTimeUtcMillis(program.startTimeUtcMillis)
                        .setEndTimeUtcMillis(program.endTimeUtcMillis)
                        .setDurationMillis((program.endTimeUtcMillis - program.startTimeUtcMillis).toInt())
                        .setLive(true)
                        .setWeight((Int.MAX_VALUE - program.channelId).toInt())
                        .setPosterArtUri(program.posterArtUri.toUri())
                        .build()

        //If this channel is showing the same program as last time.
        if (isExistingPreviewProgram(previewProgram, existingPreviewPrograms)) {
            Log.d(TAG, "Existing program ${program.title}")
        } else {
            //Create the new program
            val programUri = contentResolver.insert(TvContractCompat.PreviewPrograms.CONTENT_URI,
                    previewProgram.toContentValues())
            val newPreviewId = ContentUris.parseId(programUri)

            Log.d(TAG, "Added program ${previewProgram.title} with preview id $newPreviewId")
        }
    }

    private fun isExistingPreviewProgram(program: PreviewProgram, existingPrograms: List<PreviewProgram>): Boolean {
        return existingPrograms.any {
            it.startTimeUtcMillis == program.startTimeUtcMillis
                    && it.endTimeUtcMillis == program.endTimeUtcMillis
                    && it.title == program.title
        }
    }

    /**
     * Schedules the next update at [time]
     */
    private fun scheduleNextProgramsUpdate(time: Long) {
        val timeString = serverDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(time))
        Log.d(TAG, "Scheduling next preview update at $timeString")

        val pendingIntent = PendingIntent.getBroadcast(applicationContext,
                0,
                Intent(applicationContext, CurrentProgramsPreviewUpdateReceiver::class.java),
                PendingIntent.FLAG_CANCEL_CURRENT)

        //Schedule the pending intent
        applicationContext.getSystemService<AlarmManager?>()?.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                        time,
                        pendingIntent)
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setExact(AlarmManager.RTC_WAKEUP, time, pendingIntent)
            }
        }
    }

    /**
     * Returns the current list of preview programs on a given preview channel.
     *
     * @param channelId Channel's Id.
     * @return List of programs.
     * @hide
     */
    private fun getPreviewPrograms(channelId: Long): List<PreviewProgram> {
        val uri = TvContract.buildPreviewProgramsUriForChannel(channelId)
        val programs = ArrayList<PreviewProgram>()
        // TvProvider returns programs in chronological order by default.
        try {
            contentResolver.query(uri, Program.PROJECTION, null, null, null)
                    ?.use { cursor ->
                        while (cursor.moveToNext()) {
                            programs.add(PreviewProgram.fromCursor(cursor))
                        }
                    }
        } catch (e: Exception) {
            Log.w(TAG, "Unable to get preview programs for $channelId", e)
        }
        return programs
    }
}

/**
 * Schedules a new task to update the preview channel if no other task is pending or running.
 */
@Synchronized
fun scheduleCurrentProgramsPreviewUpdate() {
    val tag = "scheduleCurrentProgramsPreviewUpdate"
    lateinit var observer: Observer<MutableList<WorkStatus>>

    val statuses = WorkManager.getInstance().getStatusesByTag(tag)
    observer = Observer { workStatuses ->
        statuses.removeObserver(observer)

        val pendingWork = workStatuses?.any { !it.state.isFinished } ?: false
        if (!pendingWork) {
            val updatePreviewPrograms = OneTimeWorkRequestBuilder<CurrentProgramsPreviewUpdater>()
                    .addTag(tag)
                    .build()
            WorkManager.getInstance().enqueue(updatePreviewPrograms)
            Log.d(TAG, "Work task enqueued")
        } else {
            Log.d(TAG, "Work task already pending")
        }
    }
    statuses.observeForever(observer)
}