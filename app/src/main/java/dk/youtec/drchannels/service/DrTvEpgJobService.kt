package dk.youtec.drchannels.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.support.v4.content.LocalBroadcastManager
import android.util.Log

import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import com.google.android.media.tv.companionlibrary.model.Channel
import com.google.android.media.tv.companionlibrary.model.InternalProviderData
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.utils.TvContractUtils
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drchannels.backend.streamingUrl
import dk.youtec.drchannels.util.serverDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * EpgSyncJobService that periodically runs to update channels and programs.
 */
class DrTvEpgJobService : EpgSyncJobService() {
    private lateinit var api: DrMuRepository

    private val syncFinishedReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val syncStatus = intent.getStringExtra(EpgSyncJobService.SYNC_STATUS)
            if (syncStatus == EpgSyncJobService.SYNC_FINISHED) {
                Log.d("DrTvEpgJobService", "Sync finished, scheduling preview update")

                schedulePreviewUpdate()
            }
        }
    }

    override fun onCreate() {
        super.onCreate()

        api = DrMuRepository()

        LocalBroadcastManager.getInstance(this).registerReceiver(
                syncFinishedReceiver,
                IntentFilter(ACTION_SYNC_STATUS_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()

        LocalBroadcastManager.getInstance(this).unregisterReceiver(syncFinishedReceiver)
    }

    override fun getChannels(): List<Channel> {
        val drTvChannels = api.getAllActiveDrTvChannels()
                .filter { it.StreamingServers.count { it.LinkType == "HLS" } > 0 }
                .filter { !it.WebChannel }
                .sortedBy { it.Title.replace(" ", "") }

        val channelList = ArrayList<Channel>()

        drTvChannels.forEachIndexed { index, channel ->
            val internalProviderData = InternalProviderData().apply {
                videoUrl = channel.streamingUrl
                videoType = TvContractUtils.SOURCE_TYPE_HLS
            }

            channelList.add(Channel.Builder()
                    .setNetworkAffiliation(channel.Slug)
                    .setDisplayName(channel.Title)
                    .setDescription(channel.Subtitle)
                    .setDisplayNumber("${index + 1}")
                    .setChannelLogo(if (channel.WebChannel) null else channel.PrimaryImageUri)
                    .setOriginalNetworkId(channel.Slug.hashCode())
                    .setInternalProviderData(internalProviderData)
                    .build())
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

        //Get two days of broadcasts
        val todaysBroadcasts = getBroadcasts(channel, Date(startMs))
        val tomorrowsBroadcasts = getBroadcasts(channel, Date(startMs + TimeUnit.DAYS.toMillis(1)))

        //Adjust the end time of the last of today's broadcasts to avoid gaps or overlaps in the schedule.
        alignPrograms(todaysBroadcasts, tomorrowsBroadcasts)

        val broadcasts = todaysBroadcasts + tomorrowsBroadcasts
        broadcasts.forEach { broadcast ->
            programs.add(buildProgram(channel, broadcast, endMs))
        }

        return programs
    }

    private fun buildProgram(channel: Channel, broadcast: MuScheduleBroadcast, endMs: Long): Program {
        return with(Program.Builder()) {

            setChannelId(channel.id)
            setTitle(broadcast.Title)
            setDescription(broadcast.Description)

            setStartTimeUtcMillis(broadcast.StartTime.time)
            setEndTimeUtcMillis(Math.min(broadcast.EndTime.time, endMs))

            if (broadcast.OnlineGenreText?.isNotBlank() == true) {
                setBroadcastGenres(arrayOf(broadcast.OnlineGenreText))
            }

            setEpisodeTitle(broadcast.Subtitle)

            setSeasonTitle(broadcast.ProgramCard.SeasonTitle)
            if (broadcast.ProgramCard.SeasonNumber > 0) {
                setSeasonNumber(broadcast.ProgramCard.SeasonNumber)
            }
            setPosterArtUri(broadcast.ProgramCard.PrimaryImageUri)

            if (broadcast.VideoHD && broadcast.VideoWidescreen) {
                setVideoHeight(720)
                setVideoWidth(1280)
            }

            val providerData = InternalProviderData().apply {
                videoType = TvContractUtils.SOURCE_TYPE_HLS
                videoUrl = channel.internalProviderData.videoUrl
            }

            setRecordingProhibited(broadcast.ProgramCard.PrimaryAsset == null)

            broadcast.ProgramCard.PrimaryAsset?.let { primaryAsset ->

                val onDemandInfo = broadcast.ProgramCard.OnDemandInfo
                if (onDemandInfo != null) {
                    providerData.put("endPublish", onDemandInfo.EndPublish.time)
                }

                providerData.put("assetUri", primaryAsset.Uri)

                if (primaryAsset.Downloadable) {
                    /*
                        val manifestResponse = api.getManifest(primaryAsset.Uri)
                        manifestResponse?.Links
                                ?.asSequence()
                                ?.firstOrNull { it.Target == "HLS" }
                                ?.Uri?.let { playbackUrl ->
                            providerData.put("playbackUrl", playbackUrl)
                        }
                        manifestResponse?.Links
                                ?.asSequence()
                                ?.sortedByDescending { it.Bitrate }
                                ?.firstOrNull { it.Target == "Download" }
                                ?.Uri?.let { downloadUrl ->
                            providerData.put("downloadUrl", downloadUrl)
                        }
                        */
                }
            }

            //Channel uri and downloadable url
            setInternalProviderData(providerData)

            build()
        }
    }

    /**
     * Adjust the end time of the last of today's broadcasts to avoid gaps or overlaps in the schedule.
     */
    private fun alignPrograms(todaysBroadcasts: MutableList<MuScheduleBroadcast>, tomorrowsBroadcasts: MutableList<MuScheduleBroadcast>) {
        if (todaysBroadcasts.isNotEmpty() && tomorrowsBroadcasts.isNotEmpty()) {
            val lastBroadcast = todaysBroadcasts.last()
            val firstBroadcast = tomorrowsBroadcasts.first()
            lastBroadcast.EndTime.time = firstBroadcast.StartTime.time

            // If the first broadcast eliminates the last, then remove the last.
            if (lastBroadcast.StartTime.time >= lastBroadcast.EndTime.time) {
                todaysBroadcasts.removeAt(todaysBroadcasts.lastIndex)
            }
        }
    }

    private fun getBroadcasts(channel: Channel, date: Date): MutableList<MuScheduleBroadcast> {
        val dateString = serverDateFormat("yyyy-MM-dd HH:mm:ss").format(date)
        val schedule = api.getSchedule(channel.networkAffiliation, dateString)
        return schedule?.Broadcasts?.toMutableList() ?: mutableListOf()
    }
}
