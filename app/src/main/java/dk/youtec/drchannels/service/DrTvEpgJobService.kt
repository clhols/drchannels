package dk.youtec.drchannels.service

import android.net.Uri

import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import com.google.android.media.tv.companionlibrary.model.Channel
import com.google.android.media.tv.companionlibrary.model.InternalProviderData
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.utils.TvContractUtils
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drchannels.backend.streamingUrl
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * EpgSyncJobService that periodically runs to update channels and programs.
 */
class DrTvEpgJobService : EpgSyncJobService() {
    private lateinit var api: DrMuRepository

    override fun onCreate() {
        super.onCreate()

        api = DrMuRepository()
    }

    override fun getChannels(): List<Channel> {
        val drTvChannels = api.getAllActiveDrTvChannels()
                .filter { it.StreamingServers.count { it.LinkType == "HLS" } > 0 }
                .filter { !it.WebChannel }
                .sortedBy { it.Title.replace(" ", "") }

        val channelList = ArrayList<Channel>()

        drTvChannels.forEachIndexed { index, channel ->
            val internalProviderData = InternalProviderData()
            internalProviderData.videoUrl = channel.streamingUrl
            internalProviderData.videoType = TvContractUtils.SOURCE_TYPE_HLS

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

        //Adjust the end time of the last of todays broadcasts to avoid gaps or overlaps in the schedule.
        if (todaysBroadcasts.isNotEmpty() && tomorrowsBroadcasts.isNotEmpty()) {
            val lastBroadcast = todaysBroadcasts.last()
            val firstBroadcast = tomorrowsBroadcasts.first()
            lastBroadcast.EndTime.time = firstBroadcast.StartTime.time
        }

        val broadcasts = todaysBroadcasts + tomorrowsBroadcasts
        broadcasts.forEach { broadcast ->

            val program = with(Program.Builder()) {

                setChannelId(channel.id)
                setTitle(broadcast.Title)
                if(broadcast.Subtitle.isNotEmpty()) {
                    setDescription(broadcast.Subtitle)
                } else {
                    setDescription(broadcast.Description)
                }
                setLongDescription(broadcast.Description)
                setStartTimeUtcMillis(broadcast.StartTime.time)
                setEndTimeUtcMillis(Math.min(broadcast.EndTime.time, endMs))

                if (broadcast.OnlineGenreText?.isNotBlank() == true) {
                    setBroadcastGenres(arrayOf(broadcast.OnlineGenreText))
                }

                setEpisodeTitle(broadcast.ProgramCard.Subtitle)
                setSeasonTitle(broadcast.ProgramCard.SeasonTitle)
                setSeasonNumber(broadcast.ProgramCard.SeasonNumber)
                setPosterArtUri(broadcast.ProgramCard.PrimaryImageUri)

                if(broadcast.VideoHD && broadcast.VideoWidescreen) {
                    setVideoHeight(720)
                    setVideoWidth(1280)
                }

                val providerData = InternalProviderData().apply {
                    videoType = TvContractUtils.SOURCE_TYPE_HLS
                    videoUrl = channel.internalProviderData.videoUrl
                }

                setRecordingProhibited(broadcast.ProgramCard.PrimaryAsset?.Downloadable != true)

                if (broadcast.ProgramCardHasPrimaryAsset) {
                    broadcast.ProgramCard.PrimaryAsset?.let { primaryAsset ->

                        if(primaryAsset.Downloadable) {
                            providerData.put("assetUri", primaryAsset.Uri)

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
                }

                //Channel uri and downloadable url
                setInternalProviderData(providerData)

                build()
            }

            programs.add(program)
        }

        return programs
    }

    private fun getBroadcasts(channel: Channel, date: Date): List<MuScheduleBroadcast> {
        val dateString = SimpleDateFormat("yyyy-MM-dd HH:MM:ss", Locale.GERMAN).format(date)
        val schedule = api.getSchedule(channel.networkAffiliation, dateString)
        return schedule?.Broadcasts ?: emptyList()
    }
}
