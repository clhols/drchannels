package dk.youtec.drchannels.preview

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.media.tv.TvContract
import android.media.tv.TvContract.PreviewPrograms.ASPECT_RATIO_16_9
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.core.graphics.drawable.DrawableCompat
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
import dk.youtec.drchannels.logic.decryptUri
import dk.youtec.drchannels.ui.MainActivity
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.SharedPreferences
import dk.youtec.drchannels.util.defaultSharedPreferences
import dk.youtec.drchannels.util.serverDateFormat
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

private val TAG = BasePreviewUpdater::class.java.simpleName

@TargetApi(Build.VERSION_CODES.O)
abstract class BasePreviewUpdater(
        val context: Context,
        workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams), KoinComponent {
    abstract val channelKey: String
    protected val api: DrMuRepository by inject()
    private lateinit var contentResolver: ContentResolver

    abstract suspend fun getPrograms(): List<ProgramCard>

    abstract fun getChannelName(): String

    override suspend fun doWork(): Result {
        contentResolver = context.contentResolver

        setupPreviewChannel()

        //Id of preview channel
        val previewChannelId = SharedPreferences.getLong(context, channelKey)
        if (previewChannelId > 0L) {
            Log.i(TAG,
                    "Updating programs for preview channel $channelKey with id $previewChannelId")
            //update channel's programs
            updatePrograms(previewChannelId)
        } else {
            Log.w(TAG, "No id for channelKey=$channelKey")
        }
        return Result.success()
    }

    @SuppressLint("RestrictedApi")
    private suspend fun updatePrograms(previewChannelId: Long) {
        //Get existing programs
        val existingPreviewPrograms = getPreviewPrograms(previewChannelId)

        //Get new program cards
        val newPreviewProgramCards = getPrograms()

        //Get expired programs
        val expiredPrograms = existingPreviewPrograms.filterNot { existing ->
            newPreviewProgramCards.any {
                existing.title == it.title && existing.description == getDescription(it)
            }
        }

        //Get new programs
        val newProgramCards = newPreviewProgramCards.filterNot { new ->
            existingPreviewPrograms.any {
                new.title == it.title && getDescription(new) == it.description
            }
        }

        //Remove expired programs
        expiredPrograms.forEach { program ->
            //Delete the existing preview
            if (contentResolver.delete(
                            TvContractCompat.buildPreviewProgramUri(program.id),
                            null,
                            null) > 0) {
                Log.d(TAG,
                        "Deleted expired preview program title=${program.title}, description=${program.description} with id ${program.id}")
            }
        }

        //Build preview programs
        val newPrograms = newProgramCards.asyncAwaitMap(Dispatchers.IO) {
            getPreviewProgram(it, previewChannelId)
        }.filterNotNull()

        //Add new programs
        val insertedRowCount = contentResolver.bulkInsert(
                TvContractCompat.PreviewPrograms.CONTENT_URI,
                newPrograms.map { it.toContentValues() }.toTypedArray()
        )
        Log.d(TAG, "Added $insertedRowCount programs in $previewChannelId")
        newPrograms.forEach {
            Log.d(TAG, "Added new preview program title=${it.title}, description=${it.description}")
        }
    }

    /**
     * Convert a ProgramCard to a PreviewProgram.
     */
    private suspend fun getPreviewProgram(program: ProgramCard, previewChannelId: Long): PreviewProgram? {
        try {
            val playbackUri = program.primaryAsset?.uri?.let { uri ->
                api.getManifest(uri).let {
                    it.getUri() ?: decryptUri(it.getEncryptedUri())
                }
            }

            if (playbackUri.isNullOrBlank()) return null

            val intent = Intent(context, PlayerActivity::class.java).apply {
                action = PlayerActivity.ACTION_VIEW
                putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                data = playbackUri.toUri()
            }

            return PreviewProgram.Builder()
                    .setChannelId(previewChannelId)
                    .setType(TvContractCompat.PreviewPrograms.TYPE_TV_SERIES)
                    .setTitle(program.title)
                    .setDescription(getDescription(program))
                    .setDurationMillis(program.primaryAsset?.durationInMilliseconds?.toInt() ?: 0)
                    .setIntent(intent)
                    .setInternalProviderId(program.primaryAsset?.uri)
                    .setStartTimeUtcMillis(program.primaryBroadcastStartTime ?: 0)
                    .setPosterArtUri(program.primaryImageUri.toUri())
                    .setPosterArtAspectRatio(ASPECT_RATIO_16_9)
                    .setWeight(((program.primaryBroadcastStartTime ?: 1) / 1000).toInt())
                    .build()
        } catch (e: Exception) {
            Log.e(TAG, "Exception when adding program", e)
            return null
        }
    }

    private fun getDescription(program: ProgramCard): String {
        var description = program.onlineGenreText
        if (description.isNotEmpty()) description += " - "
        description += if (program.primaryBroadcastStartTime != null) {
            serverDateFormat("d/M HH:mm").format(Date(program.primaryBroadcastStartTime ?: 0))
        } else ""
        return description
    }

    /**
     * Returns the current list of preview programs on a given preview channel.
     *
     * @param channelId Channel's Id.
     * @return List of programs.
     */
    private suspend fun getPreviewPrograms(channelId: Long): List<PreviewProgram> = withContext(Dispatchers.IO) {
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
        programs
    }

    private fun setupPreviewChannel() {
        val channel = buildChannel()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                && SharedPreferences.getLong(context, channelKey) == 0L) {

            val channelUri = contentResolver.insert(
                    TvContractCompat.Channels.CONTENT_URI, channel.toContentValues())

            val channelId = ContentUris.parseId(channelUri!!)

            ChannelLogoUtils.storeChannelLogo(context,
                    channelId,
                    getBitmapFromVectorDrawable(context, R.mipmap.ic_launcher))

            TvContractCompat.requestChannelBrowsable(context, channelId)

            context.defaultSharedPreferences.edit {
                putLong(channelKey, channelId)
            }
        } else {
            contentResolver.update(
                    TvContractCompat.buildChannelUri(
                            SharedPreferences.getLong(context, channelKey)),
                    channel.toContentValues(), null, null)
        }
    }

    private fun queryChannel(channelId: Long): Channel? {
        val cursor = contentResolver.query(
                TvContractCompat.buildChannelUri(channelId), null, null, null, null)
        if (cursor?.moveToNext() == true) {
            return Channel.fromCursor(cursor)
        }
        return null
    }

    open fun buildChannel(): Channel {
        return with(Channel.Builder()) {
            setType(TvContractCompat.Channels.TYPE_PREVIEW)
            setDisplayName(getChannelName())
            if (BuildConfig.DEBUG) {
                setAppLinkIntent(Intent(context,
                        MainActivity::class.java))
            }
            build()
        }
    }
}

/**
 * Schedules a new task to update the preview channel if no other task is pending or running.
 */
inline fun <reified W : CoroutineWorker> Context.schedulePreviewUpdate(input: Data = Data.EMPTY) {
    val tag = "schedulePreviewUpdate${W::class.java.simpleName} genre=${input.getString("genre")}"

    val updatePreviewPrograms = OneTimeWorkRequestBuilder<W>()
            .setInputData(input)
            .setConstraints(Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build())
            .addTag(tag)
            .build()

    WorkManager.getInstance(this)
            .enqueueUniqueWork(tag, ExistingWorkPolicy.KEEP, updatePreviewPrograms)
    Log.d("BasePreviewUpdater", "Work task $tag enqueued")
}

internal suspend inline fun <T, R> Iterable<T>.asyncAwaitMap(
        context: CoroutineContext = EmptyCoroutineContext,
        crossinline block: suspend (T) -> R
): List<R> = withContext(context) {
    map { async { block(it) } }.awaitAll()
}

internal fun getBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
    var drawable = ContextCompat.getDrawable(context, drawableId)!!
    drawable = DrawableCompat.wrap(drawable).mutate()

    val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888)

    with(Canvas(bitmap)) {
        drawable.setBounds(0, 0, width, height)
        drawable.draw(this)
    }

    return bitmap
}