package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import androidx.lifecycle.Observer
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.media.tv.TvContract
import android.os.Build
import android.util.Log
import androidx.core.content.edit
import androidx.core.net.toUri
import androidx.tvprovider.media.tv.Channel
import androidx.tvprovider.media.tv.ChannelLogoUtils
import androidx.tvprovider.media.tv.PreviewProgram
import androidx.tvprovider.media.tv.TvContractCompat
import androidx.work.*
import com.google.android.media.tv.companionlibrary.model.Program
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.ProgramCard
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.MainActivity
import dk.youtec.drchannels.ui.PlayerActivity
import dk.youtec.drchannels.util.SharedPreferences
import dk.youtec.drchannels.util.getBitmapFromVectorDrawable
import org.jetbrains.anko.defaultSharedPreferences
import java.util.*

private val TAG = BasePreviewUpdater::class.java.simpleName

@TargetApi(Build.VERSION_CODES.O)
abstract class BasePreviewUpdater(
        context: Context,
        workerParams: WorkerParameters
) : Worker(context, workerParams) {
    abstract val channelKey: String
    protected lateinit var api: DrMuRepository
    private lateinit var contentResolver: ContentResolver

    abstract fun getPrograms() : List<ProgramCard>

    abstract fun getChannelName(): String

    override fun doWork(): Result {
        contentResolver = applicationContext.contentResolver
        api = DrMuRepository()

        setupPreviewChannel()

        //Id of preview channel
        val previewChannelId = SharedPreferences.getLong(applicationContext, channelKey)
        if (previewChannelId > 0L) {
            synchronized(BasePreviewUpdater::class.java) {
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

        getPrograms().forEach { program ->
            addProgram(program, previewChannelId)
        }
    }

    /**
     * Removes any existing program from the channel and insert the new one.
     */
    private fun addProgram(program: ProgramCard, previewChannelId: Long) {
        val playbackUri = program.PrimaryAsset?.Uri?.let { uri ->
            api.getManifest(uri)?.uri ?: ""
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

    private fun setupPreviewChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                && SharedPreferences.getLong(applicationContext, channelKey) == 0L) {

            val channel = getChannel()

            val channelUri = contentResolver.insert(
                    TvContractCompat.Channels.CONTENT_URI, channel.toContentValues())

            val channelId = ContentUris.parseId(channelUri)

            ChannelLogoUtils.storeChannelLogo(applicationContext,
                    channelId,
                    getBitmapFromVectorDrawable(applicationContext, R.mipmap.ic_launcher))

            TvContractCompat.requestChannelBrowsable(applicationContext, channelId)

            applicationContext.defaultSharedPreferences.edit {
                putLong(channelKey, channelId)
            }
        } else {
            contentResolver.update(
                    TvContractCompat.buildChannelUri(
                            SharedPreferences.getLong(applicationContext, channelKey)),
                    getChannel().toContentValues(), null, null)
        }
    }

    private fun getChannel(): Channel {
        return with(Channel.Builder()) {
            setType(TvContractCompat.Channels.TYPE_PREVIEW)
            setDisplayName(getChannelName())
            if (BuildConfig.DEBUG) {
                setAppLinkIntent(Intent(applicationContext,
                        MainActivity::class.java))
            }
            build()
        }
    }
}

/**
 * Schedules a new task to update the preview channel if no other task is pending or running.
 */
@Synchronized
inline fun <reified W : Worker> schedulePreviewUpdate() {
    val tag = "schedulePreviewUpdate" + W::class.java
    lateinit var observer: Observer<MutableList<WorkStatus>>

    val statuses = WorkManager.getInstance().getStatusesByTagLiveData(tag)
    observer = Observer { workStatuses ->
        statuses.removeObserver(observer)

        val pendingWork = workStatuses?.any { !it.state.isFinished } ?: false
        if (!pendingWork) {
            val updatePreviewPrograms = OneTimeWorkRequestBuilder<W>()
                    .setConstraints(Constraints.Builder()
                            .setRequiredNetworkType(NetworkType.CONNECTED)
                            .build())
                    .addTag(tag)
                    .build()
            WorkManager.getInstance().enqueue(updatePreviewPrograms)
            Log.d("BasePreviewUpdater", "Work task enqueued")
        } else {
            Log.d("BasePreviewUpdater", "Work task already pending")
        }
    }
    statuses.observeForever(observer)
}