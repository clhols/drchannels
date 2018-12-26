package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import android.content.*
import android.media.tv.TvContract
import android.os.Build
import android.util.Log
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
import java.util.concurrent.TimeUnit

private val TAG = CurrentProgramsPreviewUpdater::class.java.simpleName

@TargetApi(Build.VERSION_CODES.O)
class CurrentProgramsPreviewUpdater(
        val context: Context,
        workerParams: WorkerParameters
) : Worker(context, workerParams) {
    private lateinit var contentResolver: ContentResolver

    override fun doWork(): Result {
        contentResolver = context.contentResolver
        val channelKey = "channelId"
        //Id of preview channel
        val previewChannelId = SharedPreferences.getLong(context, channelKey)
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
        return Result.success()
    }

    private fun updatePrograms(previewChannelId: Long) {
        val now = System.currentTimeMillis()
        var nextProgramFinishTime = Long.MAX_VALUE

        val existingPreviewPrograms = getPreviewPrograms(previewChannelId)

        existingPreviewPrograms.forEach {
            Log.d(TAG, "Existing program: ${it.title}, posterArtUri=${it.posterArtUri}")
        }

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
                context.getString(dk.youtec.drchannels.R.string.channelInputId))
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
    private fun updateProgram(
            program: Program,
            previewChannelId: Long,
            existingPreviewPrograms: List<PreviewProgram>
    ) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
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
        if (!isExistingPreviewProgram(previewProgram, existingPreviewPrograms)) {
            //Create the new program
            val programUri = contentResolver.insert(
                    TvContractCompat.PreviewPrograms.CONTENT_URI,
                    previewProgram.toContentValues()
            )
            val newPreviewId = ContentUris.parseId(programUri)

            Log.d(TAG, "Added program ${previewProgram.title} with preview id $newPreviewId")
        }
    }

    private fun isExistingPreviewProgram(program: PreviewProgram, existingPrograms: List<PreviewProgram>): Boolean {
        return existingPrograms.any {
            it.posterArtUri == program.posterArtUri
                    && it.title == program.title
        }
    }

    /**
     * Schedules the next update at [time] in millis
     */
    private fun scheduleNextProgramsUpdate(time: Long) {
        val delay = time - System.currentTimeMillis()
        val timeString = serverDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(time))
        Log.d(TAG, "Scheduling next preview update at $timeString")

        scheduleCurrentProgramsPreviewUpdate(delay)
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
fun scheduleCurrentProgramsPreviewUpdate(delay: Long = 0) {
    val tag = "scheduleCurrentProgramsPreviewUpdate"

    WorkManager.getInstance().cancelAllWorkByTag(tag)

    val updatePreviewPrograms = OneTimeWorkRequestBuilder<CurrentProgramsPreviewUpdater>()
            .addTag(tag)
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .build()
    WorkManager.getInstance().enqueue(updatePreviewPrograms)
}

class CurrentProgramsPreviewUpdateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(CurrentProgramsPreviewUpdateReceiver::class.java.simpleName,
                "Scheduling new current programs preview update from alarm")
        scheduleCurrentProgramsPreviewUpdate()
    }
}