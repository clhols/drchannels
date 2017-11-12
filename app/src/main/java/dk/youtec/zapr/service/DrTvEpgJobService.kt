package dk.youtec.zapr.service

import android.net.Uri

import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import com.google.android.media.tv.companionlibrary.model.Channel
import com.google.android.media.tv.companionlibrary.model.InternalProviderData
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.utils.TvContractUtils
import dk.youtec.drapi.DrMuRepository
import dk.youtec.zapr.backend.streamingUrl
import java.text.SimpleDateFormat
import java.util.*

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

        val date = SimpleDateFormat("yyyy-MM-dd HH:MM:ss", Locale.GERMAN).format(Date(startMs))
        val schedule = api.getSchedule(channel.networkAffiliation, date)
        if (schedule != null) {
            val programs = mutableListOf<Program>()
            schedule.Broadcasts.forEach { broadcast ->

                val program = with(Program.Builder()) {

                    setChannelId(channel.id)
                    setTitle(broadcast.Title)
                    setDescription(broadcast.Description)
                    setStartTimeUtcMillis(broadcast.StartTime.time)
                    setEndTimeUtcMillis(broadcast.EndTime.time)

                    if (broadcast.OnlineGenreText?.isNotBlank() == true) {
                        setBroadcastGenres(arrayOf(broadcast.OnlineGenreText))
                    }

                    setEpisodeTitle(broadcast.ProgramCard.Subtitle)
                    setSeasonTitle(broadcast.ProgramCard.SeasonTitle)
                    setSeasonNumber(broadcast.ProgramCard.SeasonNumber)
                    setPosterArtUri(broadcast.ProgramCard.PrimaryImageUri)

                    //Channel uri
                    setInternalProviderData(InternalProviderData().apply {
                        videoType = TvContractUtils.SOURCE_TYPE_HLS
                        videoUrl = channel.internalProviderData.videoUrl
                    })

                    if (broadcast.ProgramCardHasPrimaryAsset) {
                        broadcast.ProgramCard.PrimaryAsset?.let { primaryAsset ->

                            setRecordingProhibited(true/*!primaryAsset.Downloadable*/)

                            //Program uri
                            /*
                            api.getManifest(primaryAsset.Uri)?.Links?.firstOrNull { it.Target == "HLS" }?.Uri?.let { playbackUri ->
                                setInternalProviderData(InternalProviderData().apply {
                                    videoType = TvContractUtils.SOURCE_TYPE_HLS
                                    videoUrl = playbackUri
                                })
                            }
                            */
                        }
                    }
                    build()
                }

                programs.add(program)
            }

            return programs
        }

        return emptyList()
    }
}
