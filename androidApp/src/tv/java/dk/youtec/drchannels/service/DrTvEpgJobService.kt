package dk.youtec.drchannels.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import com.google.android.media.tv.companionlibrary.model.Channel
import com.google.android.media.tv.companionlibrary.model.InternalProviderData
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.utils.TvContractUtils
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.Genre
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drchannels.preview.*
import dk.youtec.drchannels.util.serverDateFormat
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

/**
 * EpgSyncJobService that periodically runs to update channels and programs.
 */
class DrTvEpgJobService : EpgSyncJobService() {
    private val api: DrMuRepository by inject()

    private val syncFinishedReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val syncStatus = intent.getStringExtra(SYNC_STATUS)
            if (syncStatus == SYNC_FINISHED) {
                Log.d("DrTvEpgJobService", "Sync finished, scheduling preview update")

                scheduleCurrentProgramsPreviewUpdate()
                schedulePreviewUpdate<MostViewedPreviewUpdater>()
                schedulePreviewUpdate<SearchPreviewUpdater>()
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Sport))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.NaturViden))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.NyhederAktualitet))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Drama))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Dokumentar))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Kultur))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Underholdning))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Livsstil))
            }
        }
    }

    override fun onCreate() {
        super.onCreate()

        LocalBroadcastManager.getInstance(this).registerReceiver(
                syncFinishedReceiver,
                IntentFilter(ACTION_SYNC_STATUS_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()

        LocalBroadcastManager.getInstance(this).unregisterReceiver(syncFinishedReceiver)
    }

    override fun getChannels(): List<Channel> {
        val channelList = mutableListOf<Channel>()

        runBlocking { api.getAllActiveDrTvChannels() }
                .asSequence()
                .filter { it.server() != null }
                .filter { !it.webChannel }
                .filter { it.slug !in listOf("dr3", "dr-k", "dr-ultra", "eva", "evb", "evc") }
                .sortedBy { it.title.replace(" ", "") }
                .forEachIndexed { index, channel ->
                    channelList += Channel.Builder().apply {
                        setNetworkAffiliation(channel.slug)
                        setDisplayName(channel.title)
                        setDescription(channel.subtitle)
                        setDisplayNumber("${index + 1}")
                        setChannelLogo(if (channel.webChannel) null else channel.primaryImageUri)
                        setAppLinkPosterArtUri(if (channel.webChannel) null else channel.primaryImageUri)
                        setOriginalNetworkId(channel.slug.hashCode())
                        setInternalProviderData(InternalProviderData().apply {
                            videoUrl = channel.streamingUrl
                            videoType = TvContractUtils.SOURCE_TYPE_HLS
                        })
                    }.build()
                }

        return channelList
    }

    override fun getProgramsForChannel(
            channelUri: Uri,
            channel: Channel,
            startMs: Long,
            endMs: Long
    ): List<Program> {
        val programs = mutableListOf<Program>()

        /*
        //Get two days of broadcasts
        val todaysBroadcasts = getBroadcasts(channel, Date(startMs))
        val tomorrowsBroadcasts = getBroadcasts(channel, Date(startMs + TimeUnit.DAYS.toMillis(1)))

        //Adjust the end time of the last of today's broadcasts to avoid gaps or overlaps in the schedule.
        alignPrograms(todaysBroadcasts, tomorrowsBroadcasts)

        (todaysBroadcasts + tomorrowsBroadcasts).forEach { broadcast ->
            if (broadcast.endTime < endMs) {
                programs += buildProgram(channel, broadcast)
            }
        }
         */

        //Just create a single program now that we don't have any EPG data.
        programs += buildProgram(channel)

        return programs
    }

    private fun buildProgram(channel: Channel, broadcast: MuScheduleBroadcast): Program {
        return Program.Builder().apply {
            setChannelId(channel.id)
            setTitle(broadcast.title)
            setDescription(broadcast.description)

            setStartTimeUtcMillis(broadcast.startTime)
            setEndTimeUtcMillis(broadcast.endTime)

            if (broadcast.onlineGenreText?.isNotBlank() == true) {
                setBroadcastGenres(arrayOf(broadcast.onlineGenreText))
            }

            setEpisodeTitle(broadcast.subtitle)

            setSeasonTitle(broadcast.programCard.seasonTitle)
            if (broadcast.programCard.seasonNumber > 0) {
                setSeasonNumber(broadcast.programCard.seasonNumber)
            }
            setPosterArtUri(broadcast.programCard.primaryImageUri)

            if (broadcast.videoHD && broadcast.videoWidescreen) {
                setVideoHeight(720)
                setVideoWidth(1280)
            }

            val providerData = InternalProviderData().apply {
                videoType = TvContractUtils.SOURCE_TYPE_HLS
                videoUrl = channel.internalProviderData.videoUrl
            }

            setRecordingProhibited(broadcast.programCard.primaryAsset == null)

            broadcast.programCard.primaryAsset?.let { primaryAsset ->

                val onDemandInfo = broadcast.programCard.onDemandInfo
                if (onDemandInfo != null) {
                    providerData.put("endPublish", onDemandInfo.endPublish)
                }

                providerData.put("assetUri", primaryAsset.uri)

                if (primaryAsset.downloadable) {
                    /*
                        val manifestResponse = api.getManifest(primaryAsset.uri)
                        manifestResponse?.links
                                ?.asSequence()
                                ?.firstOrNull { it.target == "HLS" }
                                ?.Uri?.let { playbackUrl ->
                            providerData.put("playbackUrl", playbackUrl)
                        }
                        manifestResponse?.links
                                ?.asSequence()
                                ?.sortedByDescending { it.bitrate }
                                ?.firstOrNull { it.target == "Download" }
                                ?.Uri?.let { downloadUrl ->
                            providerData.put("downloadUrl", downloadUrl)
                        }
                        */
                }
            }

            //Channel uri and downloadable url
            setInternalProviderData(providerData)
        }.build()
    }

    private fun buildProgram(channel: Channel): Program {
        return Program.Builder().apply {
            setChannelId(channel.id)
            setTitle(channel.displayName)
            setDescription(channel.description)

            setStartTimeUtcMillis(System.currentTimeMillis())
            setEndTimeUtcMillis(Long.MAX_VALUE)

            setThumbnailUri(channel.appLinkPosterArtUri)
            setVideoHeight(720)
            setVideoWidth(1280)
            setRecordingProhibited(true)

            val providerData = InternalProviderData().apply {
                videoType = TvContractUtils.SOURCE_TYPE_HLS
                videoUrl = channel.internalProviderData.videoUrl
            }

            //Channel uri and downloadable url
            setInternalProviderData(providerData)
        }.build()
    }

    /**
     * Adjust the end time of the last of today's broadcasts to avoid gaps or overlaps in the schedule.
     */
    private fun alignPrograms(todaysBroadcasts: MutableList<MuScheduleBroadcast>, tomorrowsBroadcasts: MutableList<MuScheduleBroadcast>) {
        if (todaysBroadcasts.isNotEmpty() && tomorrowsBroadcasts.isNotEmpty()) {
            val firstBroadcast = tomorrowsBroadcasts.first()
            val lastBroadcast = todaysBroadcasts.last().copy(endTime = firstBroadcast.startTime)

            // If the first broadcast eliminates the last, then remove the last.
            if (lastBroadcast.startTime >= lastBroadcast.endTime) {
                todaysBroadcasts.removeAt(todaysBroadcasts.lastIndex)
            }
        }
    }
}

private val dk.youtec.drapi.Channel.streamingUrl: String
    get() {
        val stream = server()!!.qualities.maxByOrNull { it.kbps }!!
                .streams.first().stream
        return "${server()!!.server}/$stream"
    }