package dk.youtec.drapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

const val API_VERSION = "1.4"
const val API_URL = "https://www.dr.dk/mu-online/api/$API_VERSION/"

internal interface DrMuApi {
    @GET("channel/all-active-dr-tv-channels")
    fun getAllActiveDrTvChannels(): Call<List<Channel>>

    @GET("{uri}")
    fun getManifest(@Path("uri") uri: String): Call<Manifest>

    @GET("schedule/{id}") // Date format yyyy-MM-dd HH:mm:ss
    fun getSchedule(@Path("id") id: String, @Query("broadcastdate") date: String): Call<Schedule>

    @GET("schedule/nownext/{id}")
    fun getScheduleNowNext(@Path("id") id: String): Call<MuNowNext>

    @GET("schedule/nownext-for-all-active-dr-tv-channels")
    fun getScheduleNowNext(): Call<List<MuNowNext>>

    @GET("search/tv/programcards-with-asset/title/{query}")
    fun search(@Path("query") query: String): Call<SearchResult>

    @GET("list/view/mostviewed")
    fun getMostViewed(
            @Query("channel") channel: String,
            @Query("channelType") channelType: String,
            @Query("limit") limit: Int
    ): Call<MostViewed>
}

data class SearchResult(
        val Title: String,
        val Subtitle: String = "",
        val Description: String = "",
        val IsRepremiere: Boolean,
        val BundleType: String = "",
        val ThemeType: String = "",
        val Slug: String = "",
        val Items: List<ProgramCard>,
        val Paging: MuPaging,
        val TotalSize: Int,
        val BackgroundImageUri: String = "",
        val SiteUrl: String = "")

data class MuPaging(
        val Title: String = "",
        val Source: String = "",
        val Next: String = "",
        val Previous: String = "",
        val TotalSize: Int = 0)

data class Schedule(
        val Broadcasts: List<MuScheduleBroadcast>,
        val BroadcastDate: Date,
        val ChannelSlug: String,
        val Channel: String)

data class Channel(
        val Type: String,
        val StreamingServers: List<MuStreamingServer>,
        val Url: String = "",
        val SourceUrl: String = "",
        val WebChannel: Boolean,
        val Slug: String,
        val Urn: String,
        val PrimaryImageUri: String,
        val PresentationUri: String = "",
        val PresentationUriAutoplay: String = "",
        val Title: String,
        val ItemLabel: String = "",
        val Subtitle: String = "") {
    val hlsServer: MuStreamingServer?
        get() = StreamingServers.firstOrNull { it.LinkType == "HLS" }
    val hdsServer: MuStreamingServer?
        get() = StreamingServers.firstOrNull { it.LinkType == "HDS" }
    //val dashServer: MuStreamingServer?
    //    get() = StreamingServers.firstOrNull { it.LinkType == "DASH" }
    val server: MuStreamingServer?
        get() = hlsServer ?: hdsServer
}

data class MuStreamingServer(
        val Server: String,
        val LinkType: String,
        val Qualities: List<MuStreamQuality>,
        val DynamicUserQualityChange: Boolean,
        val EncryptedServer: String)

data class MuStreamQuality(
        val Kbps: Int,
        val Streams: List<MuStream>)

data class MuStream(
        val Stream: String = "",
        val EncryptedStream: String = "")

data class MuNowNext(
        val ChannelSlug: String,
        val Channel: String,
        val Now: MuScheduleBroadcast?,
        val Next: List<MuScheduleBroadcast>)

data class MuScheduleBroadcast(
        val Title: String,
        val Description: String,
        val Subtitle: String = "",
        val StartTime: Date,
        val EndTime: Date,
        val ProgramCard: ProgramCard,
        val OnlineGenreText: String?,
        val ProductionNumber: String,
        val ProgramCardHasPrimaryAsset: Boolean,
        val SeriesHasProgramCardWithPrimaryAsset: Boolean,
        val AnnouncedStartTime: Date,
        val AnnouncedEndTime: Date,
        val ProductionCountry: String,
        val ProductionYear: Int,
        val VideoWidescreen: Boolean,
        val SubtitlesTTV: Boolean,
        val VideoHD: Boolean,
        val WhatsOnUri: String,
        val IsRerun: Boolean) {
    val primaryAssetUri: String?
        get() = ProgramCard.PrimaryAsset?.Uri
}

data class ProgramCard(
        val Type: String,
        val SeriesTitle: String = "",
        val SeriesSlug: String = "",
        val SeriesUrn: String = "",
        val PrimaryChannel: String,
        val PrimaryChannelSlug: String = "",
        val SeasonEpisodeNumberingValid: Boolean,
        val SeasonTitle: String?,
        val SeasonSlug: String?,
        val SeasonUrn: String?,
        val SeasonNumber: Int = 0,
        val PrePremiere: Boolean,
        val ExpiresSoon: Boolean,
        val OnlineGenreText: String,
        val PrimaryAsset: PrimaryAsset?,
        val HasPublicPrimaryAsset: Boolean,
        val AssetTargetTypes: String = "",
        val PrimaryBroadcastStartTime: Date,
        val SortDateTime: Date,
        val OnDemandInfo: Info?,
        val Slug: String,
        val Urn: String,
        val PrimaryImageUri: String,
        val PresentationUri: String = "",
        val PresentationUriAutoplay: String = "",
        val Title: String,
        val Subtitle: String = "",
        val IsNewSeries: Boolean,
        val OriginalTitle: String = "")

data class Info(
        val StartPublish: Date,
        val EndPublish: Date)

data class PrimaryAsset(
        val Kind: String,
        val Uri: String,
        val DurationInMilliseconds: Long,
        val Downloadable: Boolean,
        val RestrictedToDenmark: Boolean,
        val StartPublish: Date,
        val EndPublish: Date,
        val Target: String,
        val Encrypted: Boolean)

data class Manifest(
        val Links: List<Link>,
        val SubtitlesList: List<Subtitle>) {
    val hlsUri: String?
        get() = Links.firstOrNull { it.Target == "HLS" }?.Uri
    val hdsUri: String?
        get() = Links.firstOrNull { it.Target == "HDS" }?.Uri
    val uri: String?
        get() = hlsUri ?: hdsUri
}

data class Link(
        val HardSubtitlesType: String,
        val Uri: String,
        val EncryptedUri: String,
        val FileFormat: String,
        val Target: String,
        val Bitrate: Int)

data class Subtitle(
        val Language: String,
        val MimeType: String,
        val Type: String,
        val Uri: String)

data class MostViewed(
        val Items: List<ProgramCard>,
        val Paging: MuPaging,
        val TotalSize: Int)
