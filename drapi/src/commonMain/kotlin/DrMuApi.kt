package dk.youtec.drapi

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

    suspend fun getPageTvPrograms(genre: Genre): Page
}

@Serializable
data class SearchResult(
        val Title: String,
        val Subtitle: String = "",
        val Description: String = "",
        val IsRepremiere: Boolean = false,
        val BundleType: String = "",
        val ThemeType: String = "",
        val Slug: String = "",
        val Items: List<ProgramCard>,
        val Paging: MuPaging,
        val TotalSize: Int,
        val BackgroundImageUri: String = "",
        val SiteUrl: String = "")

@Serializable
data class MuPaging(
        val Title: String = "",
        val Source: String = "",
        val Next: String = "",
        val Previous: String = "",
        val TotalSize: Int = 0)

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
    private fun hlsServer(): MuStreamingServer? = StreamingServers.firstOrNull { it.LinkType == "HLS" }
    private fun hdsServer(): MuStreamingServer? = StreamingServers.firstOrNull { it.LinkType == "HDS" }
    fun server(): MuStreamingServer? = hlsServer() ?: hdsServer()
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
        val Stream: String = "",
        val EncryptedStream: String = "")

@Serializable
data class MuNowNext(
        val ChannelSlug: String,
        val Channel: String,
        val Now: MuScheduleBroadcast? = null,
        val Next: List<MuScheduleBroadcast>)

@Serializable
data class MuScheduleBroadcast(
        val Title: String,
        val Description: String,
        val Subtitle: String = "",
        @Serializable(with = DateSerializer::class) val StartTime: Date,
        @Serializable(with = DateSerializer::class) val EndTime: Date,
        val ProgramCard: ProgramCard,
        val OnlineGenreText: String? = null,
        val ProductionNumber: String,
        val ProgramCardHasPrimaryAsset: Boolean,
        val SeriesHasProgramCardWithPrimaryAsset: Boolean,
        @Serializable(with = DateSerializer::class) val AnnouncedStartTime: Date,
        @Serializable(with = DateSerializer::class) val AnnouncedEndTime: Date,
        val ProductionCountry: String,
        val ProductionYear: Int = 0,
        val VideoWidescreen: Boolean = false,
        val SubtitlesTTV: Boolean = false,
        val VideoHD: Boolean = false,
        val WhatsOnUri: String,
        val IsRerun: Boolean) {
    fun getPrimaryAssetUri(): String? = ProgramCard.PrimaryAsset?.Uri
}

@Serializable
data class ProgramCard(
        val Type: String,
        val SeriesTitle: String = "",
        val EpisodeTitle: String = "",
        val SeriesSlug: String = "",
        val SeriesUrn: String = "",
        val HostName: String = "",
        val SeriesHostName: String = "",
        val PrimaryChannel: String,
        val PrimaryChannelSlug: String = "",
        val SeasonEpisodeNumberingValid: Boolean = false,
        val SeasonTitle: String? = null,
        val SeasonSlug: String? = null,
        val SeasonUrn: String? = null,
        val SeasonNumber: Int = 0,
        val PrePremiere: Boolean,
        val ExpiresSoon: Boolean,
        val OnlineGenreText: String = "",
        val PrimaryAsset: PrimaryAsset? = null,
        val HasPublicPrimaryAsset: Boolean = false,
        val AssetTargetTypes: String = "",
        @Serializable(with = DateSerializer::class) val PrimaryBroadcastStartTime: Date? = null,
        @Serializable(with = DateSerializer::class) val SortDateTime: Date,
        val OnDemandInfo: Info? = null,
        val Slug: String,
        val Urn: String,
        val PrimaryImageUri: String,
        val PresentationUri: String = "",
        val PresentationUriAutoplay: String = "",
        val Title: String,
        val Subtitle: String = "",
        val IsNewSeries: Boolean = false,
        val OriginalTitle: String = "",
        val RectificationStatus: String = "",
        val RectificationAuto: Boolean = false,
        val RectificationText: String = "")

@Serializable
data class Info(
        @Serializable(with = DateSerializer::class) val StartPublish: Date,
        @Serializable(with = DateSerializer::class) val EndPublish: Date)

@Serializable
data class PrimaryAsset(
        val Kind: String,
        val Uri: String,
        val DurationInMilliseconds: Long,
        val Downloadable: Boolean = false,
        val RestrictedToDenmark: Boolean = false,
        @Serializable(with = DateSerializer::class) val StartPublish: Date,
        @Serializable(with = DateSerializer::class) val EndPublish: Date,
        val Target: String,
        val Encrypted: Boolean,
        val IsLiveStream: Boolean = false)

@Serializable
data class Manifest(
        val Links: List<Link>,
        val SubtitlesList: List<Subtitle>) {
    fun getEncryptedUri(): String = Links.firstOrNull { it.Target == "HLS" }?.EncryptedUri ?: ""
    private fun getHlsUri(): String? = Links.firstOrNull { it.Target == "HLS" }?.Uri
    private fun getHdsUri(): String? = Links.firstOrNull { it.Target == "HDS" }?.Uri
    fun getUri(): String? = getHlsUri() ?: getHdsUri()
}

@Serializable
data class Link(
        val HardSubtitlesType: String = "None",
        val Uri: String? = null,
        val EncryptedUri: String,
        val FileFormat: String,
        val Target: String,
        val Bitrate: Int = 0)

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

@Serializable
data class Programs(
        val Items: List<ProgramCard>,
        val Paging: MuPaging,
        val TotalSize: Int)

@Serializable
data class Page(
        val Programs: Programs)

sealed class Genre(internal val value: String) {
    object Drama: Genre("Drama")
    object Dokumentar: Genre("Dokumentar")
    object Livsstil: Genre("Livsstil")
    object Kultur: Genre("Kultur")
    object NaturViden: Genre("Natur & viden")
    object NyhederAktualitet: Genre("Nyheder & aktualitet")
    object Sport: Genre("Sport")
    object Underholdning: Genre("Underholdning")

    override fun toString(): String = value

    companion object {
        fun getByValue(value: String): Genre = when(value) {
            Drama.value -> Drama
            Dokumentar.value -> Dokumentar
            Livsstil.value -> Livsstil
            Kultur.value -> Kultur
            NaturViden.value -> NaturViden
            NyhederAktualitet.value -> NyhederAktualitet
            Sport.value -> Sport
            Underholdning.value -> Underholdning
            else -> throw RuntimeException("Genre $value not supported")
        }
    }
}