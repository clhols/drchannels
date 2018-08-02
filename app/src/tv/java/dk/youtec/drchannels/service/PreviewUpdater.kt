package dk.youtec.drchannels.service

import android.annotation.TargetApi
import android.app.AlarmManager
import android.app.PendingIntent
import android.arch.lifecycle.Observer
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Intent
import android.database.Cursor
import android.media.tv.TvContract
import android.net.Uri
import android.os.Build
import android.support.media.tv.Channel
import android.support.media.tv.PreviewProgram
import android.support.media.tv.TvContractCompat
import android.util.Log
import androidx.core.content.systemService
import androidx.core.util.forEach
import androidx.work.*
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.utils.TvContractUtils
import dk.youtec.drchannels.ui.PlayerActivity
import dk.youtec.drchannels.util.SharedPreferences
import dk.youtec.drchannels.util.serverDateFormat
import java.util.*

@TargetApi(Build.VERSION_CODES.O)
class PreviewUpdater : Worker() {
    private val tag = PreviewUpdater::class.java.simpleName
    private lateinit var contentResolver: ContentResolver

    override fun doWork(): Result {
        contentResolver = applicationContext.contentResolver
        //Id of preview channel
        val previewChannelId = SharedPreferences.getLong(applicationContext, "channelId")
        if (previewChannelId > 0L) {
            contentResolver
                    .query(TvContractCompat.buildChannelUri(previewChannelId),
                            null, null, null, null)
                    .use { cursor ->
                        if (cursor?.moveToNext() == true) {
                            val channel = Channel.fromCursor(cursor)
                            if (channel.isBrowsable) {
                                synchronized(PreviewUpdater::class.java) {
                                    Log.v(tag, "Updating programs for channel ${channel.displayName} with id ${channel.id}")
                                    val previewPrograms = getPreviewPrograms(previewChannelId)

                                    //update channel's programs
                                    updatePrograms(previewChannelId, previewPrograms)
                                }
                            }
                        }
                    }
        }
        return Result.SUCCESS
    }

    private fun updatePrograms(previewChannelId: Long, existingPrograms: List<PreviewProgram>) {
        val now = System.currentTimeMillis()
        var nextProgramFinishTime = Long.MAX_VALUE

        //Remove expired programs
        existingPrograms
                .filter { now >= it.endTimeUtcMillis }
                .forEach { program ->
                    //Delete the existing program
                    if (contentResolver.delete(TvContractCompat.buildPreviewProgramUri(program.id),
                                    null, null) > 0) {
                        Log.d(tag, "Deleted expired program ${program.title} with id ${program.id}")
                    }
                }

        //Update existing or add new programs
        val channelMap = TvContractUtils.buildChannelMap(contentResolver,
                applicationContext.getString(dk.youtec.drchannels.R.string.channelInputId))
        channelMap.forEach { id, _ ->
            val programs = TvContractUtils.getPrograms(contentResolver,
                    TvContract.buildChannelUri(id))
            val currentPrograms = programs.filter { it.startTimeUtcMillis <= now && now < it.endTimeUtcMillis }
            currentPrograms
                    .forEach { program ->
                        //Find the next time to start updating previews
                        nextProgramFinishTime = nextProgramFinishTime.coerceAtMost(program.endTimeUtcMillis)

                        updateProgram(program, previewChannelId, existingPrograms)
                    }
        }

        if (nextProgramFinishTime < Long.MAX_VALUE) {
            scheduleNextProgramsUpdate(nextProgramFinishTime)
        }
    }

    /**
     * Removes any existing program from the channel and insert the new one.
     */
    private fun updateProgram(program: Program, previewChannelId: Long, existingPrograms: List<PreviewProgram>) {
        val intent = Intent(applicationContext, PlayerActivity::class.java).apply {
            action = PlayerActivity.ACTION_VIEW
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
            data = Uri.parse(program.internalProviderData.videoUrl)
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
                        .setPosterArtUri(Uri.parse(program.posterArtUri))
                        .build()

        //If this channel is showing the same program as last time.
        if (isExistingProgram(previewProgram, existingPrograms)) {
            Log.d(tag, "Existing program ${program.title}")
            //contentResolver.update(TvContractCompat.buildPreviewProgramUri(previewId),
            //        previewProgram, null, null)
        } else {
            //Create the new program
            val programUri = contentResolver.insert(TvContractCompat.PreviewPrograms.CONTENT_URI,
                    previewProgram.toContentValues())
            val newPreviewId = ContentUris.parseId(programUri)

            Log.d(tag, "Added program ${program.title} with preview id $newPreviewId")
        }
    }

    private fun isExistingProgram(program: PreviewProgram, existingPrograms: List<PreviewProgram>): Boolean {
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
        Log.d(tag, "Scheduling next preview update at $timeString")

        val pendingIntent = PendingIntent.getBroadcast(applicationContext,
                0,
                Intent(applicationContext, PreviewUpdateReceiver::class.java),
                PendingIntent.FLAG_CANCEL_CURRENT)

        //Schedule the pending intent
        applicationContext.systemService<AlarmManager?>()?.apply {
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
        var cursor: Cursor? = null
        try {
            cursor = contentResolver.query(uri, Program.PROJECTION, null, null, null)
            if (cursor == null || cursor.count == 0) {
                return programs
            }
            while (cursor.moveToNext()) {
                programs.add(PreviewProgram.fromCursor(cursor))
            }
        } catch (e: Exception) {
            Log.w("PreviewUpdater", "Unable to get preview programs for $channelId", e)
        } finally {
            cursor?.close()
        }
        return programs
    }
}

/**
 * Schedules a new task to update the preview channel if no other task is pending or running.
 */
@Synchronized
fun schedulePreviewUpdate() {
    val tag = "updatePreviewPrograms"
    lateinit var observer : Observer<MutableList<WorkStatus>>

    val statuses = WorkManager.getInstance().getStatusesByTag(tag)
    observer = Observer { workStatuses ->
        statuses.removeObserver(observer)

        val pendingWork = workStatuses?.any { !it.state.isFinished } ?: false
        if (!pendingWork) {
            val updatePreviewPrograms = OneTimeWorkRequestBuilder<PreviewUpdater>()
                    .setConstraints(Constraints.Builder()
                            .setRequiredNetworkType(NetworkType.CONNECTED)
                            .build())
                    .addTag(tag)
                    .build()
            WorkManager.getInstance().enqueue(updatePreviewPrograms)
            Log.d("PreviewUpdater", "Work task enqueued")
        } else {
            Log.d("PreviewUpdater", "Work task already pending")
        }
    }
    statuses.observeForever(observer)
}