package dk.youtec.drapi.multiplatform

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

const val API_VERSION = "1.4"
const val API_URL = "https://www.dr.dk/mu-online/api/$API_VERSION"

internal interface IDrMuApi {
    suspend fun getAllActiveDrTvChannels(): List<Channel>

    suspend fun getManifest(uri: String): Manifest

    suspend fun getSchedule(id: String, date: String): Schedule

    suspend fun getScheduleNowNext(id: String): MuNowNext

    suspend fun getScheduleNowNext(): List<MuNowNext>

    suspend fun search(query: String): SearchResult

    suspend fun getMostViewed(
            channel: String,
            channelType: String,
            limit: Int
    ): MostViewed
}

@Serializable
data class SearchResult(
        val Title: String,
        @Optional val Subtitle: String = "",
        @Optional val Description: String = "",
        @Optional val IsRepremiere: Boolean = false,
        @Optional val BundleType: String = "",
        @Optional val ThemeType: String = "",
        @Optional val Slug: String = "",
        val Items: List<ProgramCard>,
        val Paging: MuPaging,
        val TotalSize: Int,
        @Optional val BackgroundImageUri: String = "",
        @Optional val SiteUrl: String = "")

@Serializable
data class MuPaging(
        @Optional val Title: String = "",
        @Optional val Source: String = "",
        @Optional val Next: String = "",
        @Optional val Previous: String = "",
        @Optional val TotalSize: Int = 0)

@Serializable
data class Schedule(
        val Broadcasts: List<MuScheduleBroadcast>,
        @Serializable(with = DateSerializer::class) val BroadcastDate: Date,
        val ChannelSlug: String,
        val Channel: String)

@Serializable
data class Channel(
        val Type: String,
        val StreamingServers: List<MuStreamingServer>,
        @Optional val Url: String = "",
        @Optional val SourceUrl: String = "",
        val WebChannel: Boolean,
        val Slug: String,
        val Urn: String,
        val PrimaryImageUri: String,
        @Optional val PresentationUri: String = "",
        @Optional val PresentationUriAutoplay: String = "",
        val Title: String,
        @Optional val ItemLabel: String = "",
        @Optional val Subtitle: String = "") {
    val hlsServer: MuStreamingServer?
        get() = StreamingServers.firstOrNull { it.LinkType == "HLS" }
    val hdsServer: MuStreamingServer?
        get() = StreamingServers.firstOrNull { it.LinkType == "HDS" }
    //val dashServer: MuStreamingServer?
    //    get() = StreamingServers.firstOrNull { it.LinkType == "DASH" }
    val server: MuStreamingServer?
        get() = hlsServer ?: hdsServer
}

@Serializable
data class MuStreamingServer(
        val Server: String,
        val LinkType: String,
        val Qualities: List<MuStreamQuality>,
        val DynamicUserQualityChange: Boolean,
        val EncryptedServer: String)

@Serializable
data class MuStreamQuality(
        val Kbps: Int,
        val Streams: List<MuStream>)

@Serializable
data class MuStream(
        @Optional val Stream: String = "",
        @Optional val EncryptedStream: String = "")

@Serializable
data class MuNowNext(
        val ChannelSlug: String,
        val Channel: String,
        @Optional val Now: MuScheduleBroadcast? = null,
        val Next: List<MuScheduleBroadcast>)

@Serializable
data class MuScheduleBroadcast(
        val Title: String,
        val Description: String,
        @Optional val Subtitle: String = "",
        @Serializable(with = DateSerializer::class) val StartTime: Date,
        @Serializable(with = DateSerializer::class) val EndTime: Date,
        val ProgramCard: ProgramCard,
        @Optional val OnlineGenreText: String? = null,
        val ProductionNumber: String,
        val ProgramCardHasPrimaryAsset: Boolean,
        val SeriesHasProgramCardWithPrimaryAsset: Boolean,
        @Serializable(with = DateSerializer::class) val AnnouncedStartTime: Date,
        @Serializable(with = DateSerializer::class) val AnnouncedEndTime: Date,
        val ProductionCountry: String,
        @Optional val ProductionYear: Int = 0,
        @Optional val VideoWidescreen: Boolean = false,
        @Optional val SubtitlesTTV: Boolean = false,
        @Optional val VideoHD: Boolean = false,
        val WhatsOnUri: String,
        val IsRerun: Boolean) {
    fun getPrimaryAssetUri(): String? = ProgramCard.PrimaryAsset?.Uri
}

@Serializable
data class ProgramCard(
        val Type: String,
        @Optional val SeriesTitle: String = "",
        @Optional val SeriesSlug: String = "",
        @Optional val SeriesUrn: String = "",
        val PrimaryChannel: String,
        @Optional val PrimaryChannelSlug: String = "",
        @Optional val SeasonEpisodeNumberingValid: Boolean = false,
        @Optional val SeasonTitle: String? = null,
        @Optional val SeasonSlug: String? = null,
        @Optional val SeasonUrn: String? = null,
        @Optional val SeasonNumber: Int = 0,
        val PrePremiere: Boolean,
        val ExpiresSoon: Boolean,
        val OnlineGenreText: String,
        @Optional val PrimaryAsset: PrimaryAsset? = null,
        @Optional val HasPublicPrimaryAsset: Boolean = false,
        @Optional val AssetTargetTypes: String = "",
        @Serializable(with = DateSerializer::class) @Optional val PrimaryBroadcastStartTime: Date? = null,
        @Serializable(with = DateSerializer::class) val SortDateTime: Date,
        @Optional val OnDemandInfo: Info? = null,
        val Slug: String,
        val Urn: String,
        val PrimaryImageUri: String,
        @Optional val PresentationUri: String = "",
        @Optional val PresentationUriAutoplay: String = "",
        val Title: String,
        @Optional val Subtitle: String = "",
        @Optional val IsNewSeries: Boolean = false,
        @Optional val OriginalTitle: String = "")

@Serializable
data class Info(
        @Serializable(with = DateSerializer::class) val StartPublish: Date,
        @Serializable(with = DateSerializer::class) val EndPublish: Date)

@Serializable
data class PrimaryAsset(
        val Kind: String,
        val Uri: String,
        val DurationInMilliseconds: Long,
        val Downloadable: Boolean,
        val RestrictedToDenmark: Boolean,
        @Serializable(with = DateSerializer::class) val StartPublish: Date,
        @Serializable(with = DateSerializer::class) val EndPublish: Date,
        val Target: String,
        val Encrypted: Boolean,
        @Optional val IsLiveStream: Boolean = false)

@Serializable
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

@Serializable
data class Link(
        val HardSubtitlesType: String,
        val Uri: String,
        val EncryptedUri: String,
        val FileFormat: String,
        val Target: String,
        val Bitrate: Int)

@Serializable
data class Subtitle(
        val Language: String,
        val MimeType: String,
        val Type: String,
        val Uri: String)

@Serializable
data class MostViewed(
        val Items: List<ProgramCard>,
        val Paging: MuPaging,
        val TotalSize: Int)
