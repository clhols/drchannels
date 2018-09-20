package dk.youtec.drchannels.service

import android.annotation.TargetApi
import android.arch.lifecycle.Observer
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.tv.TvContract
import android.os.Build
import android.support.media.tv.Channel
import android.support.media.tv.ChannelLogoUtils
import android.support.media.tv.PreviewProgram
import android.support.media.tv.TvContractCompat
import android.util.Log
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.work.*
import com.google.android.media.tv.companionlibrary.model.Program
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.ProgramCard
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.MainActivity
import dk.youtec.drchannels.ui.PlayerActivity
import dk.youtec.drchannels.util.SharedPreferences
import org.jetbrains.anko.defaultSharedPreferences
import java.util.*

private val TAG = MostViewedPreviewUpdater::class.java.simpleName

@TargetApi(Build.VERSION_CODES.O)
class MostViewedPreviewUpdater : Worker() {
    private val channelKey = "mostViewedChannelId"
    private lateinit var api: DrMuRepository
    private lateinit var contentResolver: ContentResolver

    override fun doWork(): Result {
        contentResolver = applicationContext.contentResolver
        api = DrMuRepository()

        setupMostViewedPreviewChannel()

        //Id of preview channel
        val previewChannelId = SharedPreferences.getLong(applicationContext, channelKey)
        if (previewChannelId > 0L) {
            synchronized(MostViewedPreviewUpdater::class.java) {
                Log.v(TAG,
                        "Updating programs for preview id $previewChannelId")
                //update channel's programs
                updatePrograms(previewChannelId)
            }
        }
        return Result.SUCCESS
    }

    private fun updatePrograms(previewChannelId: Long) {
        val existingPreviewPrograms = getPreviewPrograms(previewChannelId)

        //Remove all programs
        existingPreviewPrograms
                .forEach { program ->
                    //Delete the existing preview
                    if (contentResolver.delete(TvContractCompat.buildPreviewProgramUri(program.id),
                                    null, null) > 0) {
                        Log.d(TAG,
                                "Deleted expired preview program ${program.title} with id ${program.id}")
                    }
                }

        api.getMostViewed().Items.forEach { program ->
            addProgram(program, previewChannelId)
        }
    }

    /**
     * Removes any existing program from the channel and insert the new one.
     */
    private fun addProgram(program: ProgramCard, previewChannelId: Long) {
        val playbackUri = program.PrimaryAsset?.Uri?.let { uri ->
            api.getManifest(uri).uri
        }

        val intent = Intent(applicationContext, PlayerActivity::class.java).apply {
            action = PlayerActivity.ACTION_VIEW
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
            data = playbackUri?.toUri()
        }

        val previewProgram =
                PreviewProgram.Builder()
                        .setChannelId(previewChannelId)
                        .setType(TvContractCompat.PreviewPrograms.TYPE_TV_EPISODE)
                        .setTitle(program.Title)
                        .setDescription(program.OnlineGenreText)
                        .setIntent(intent)
                        .setInternalProviderId(program.PrimaryAsset?.Uri)
                        .setStartTimeUtcMillis(program.PrimaryBroadcastStartTime.time)
                        .setPosterArtUri(program.PrimaryImageUri.toUri())
                        .build()

        //Create the new program
        val programUri = contentResolver.insert(TvContractCompat.PreviewPrograms.CONTENT_URI,
                previewProgram.toContentValues())
        val newPreviewId = ContentUris.parseId(programUri)

        Log.d(TAG, "Added program ${previewProgram.title} with preview id $newPreviewId")
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

    private fun setupMostViewedPreviewChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                && SharedPreferences.getLong(applicationContext, channelKey) == 0L) {

            val channel = with(Channel.Builder()) {
                setType(TvContractCompat.Channels.TYPE_PREVIEW)
                setDisplayName(applicationContext.getString(R.string.mostViewed))
                if (BuildConfig.DEBUG) {
                    setAppLinkIntent(Intent(applicationContext,
                            MainActivity::class.java))
                }
                build()
            }

            val channelUri = contentResolver.insert(
                    TvContractCompat.Channels.CONTENT_URI, channel.toContentValues())

            val channelId = ContentUris.parseId(channelUri)

            ChannelLogoUtils.storeChannelLogo(applicationContext,
                    channelId,
                    BitmapFactory.decodeResource(applicationContext.resources,
                            R.drawable.ic_channel_logo))

            TvContractCompat.requestChannelBrowsable(applicationContext, channelId)

            applicationContext.defaultSharedPreferences.edit {
                putLong(channelKey, channelId)
            }
        }
    }
}

/**
 * Schedules a new task to update the preview channel if no other task is pending or running.
 */
@Synchronized
fun scheduleMostViewedPreviewUpdate() {
    val tag = "scheduleMostViewedPreviewUpdate"
    lateinit var observer: Observer<MutableList<WorkStatus>>

    val statuses = WorkManager.getInstance().getStatusesByTag(tag)
    observer = Observer { workStatuses ->
        statuses.removeObserver(observer)

        val pendingWork = workStatuses?.any { !it.state.isFinished } ?: false
        if (!pendingWork) {
            val updatePreviewPrograms = OneTimeWorkRequestBuilder<MostViewedPreviewUpdater>()
                    .setConstraints(Constraints.Builder()
                            .setRequiredNetworkType(NetworkType.CONNECTED)
                            .build())
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