package dk.youtec.drapi

import kotlinx.serialization.SerialName
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
        @SerialName("Title") val title: String,
        @SerialName("Subtitle") val subtitle: String = "",
        @SerialName("Description") val description: String = "",
        @SerialName("IsRepremiere") val isRepremiere: Boolean = false,
        @SerialName("BundleType") val bundleType: String = "",
        @SerialName("ThemeType") val themeType: String = "",
        @SerialName("Slug") val slug: String = "",
        @SerialName("Items") val items: List<ProgramCard>,
        @SerialName("Paging") val paging: MuPaging,
        @SerialName("TotalSize") val totalSize: Int,
        @SerialName("BackgroundImageUri") val backgroundImageUri: String = "",
        @SerialName("SiteUrl") val siteUrl: String = "")

@Serializable
data class MuPaging(
        @SerialName("Title") val title: String = "",
        @SerialName("Source") val source: String = "",
        @SerialName("Next") val next: String = "",
        @SerialName("Previous") val previous: String = "",
        @SerialName("TotalSize") val totalSize: Int = 0)

@Serializable
data class Schedule(
        @SerialName("Broadcasts") val broadcasts: List<MuScheduleBroadcast>,
        @SerialName("BroadcastDate") @Serializable(with = DateSerializer::class) val broadcastDate: Long,
        @SerialName("ChannelSlug") val channelSlug: String,
        @SerialName("Channel") val channel: String)

@Serializable
data class Channel(
        @SerialName("Type") val type: String,
        @SerialName("StreamingServers") val streamingServers: List<MuStreamingServer>,
        @SerialName("Url") val url: String = "",
        @SerialName("SourceUrl") val sourceUrl: String = "",
        @SerialName("WebChannel") val webChannel: Boolean,
        @SerialName("Slug") val slug: String,
        @SerialName("Urn") val urn: String,
        @SerialName("PrimaryImageUri") val primaryImageUri: String,
        @SerialName("PresentationUri") val presentationUri: String = "",
        @SerialName("PresentationUriAutoplay") val presentationUriAutoplay: String = "",
        @SerialName("Title") val title: String,
        @SerialName("ItemLabel") val itemLabel: String = "",
        @SerialName("Subtitle") val subtitle: String = "") {
    private fun hlsServer(): MuStreamingServer? = streamingServers.firstOrNull { it.linkType == "HLS" }
    private fun hdsServer(): MuStreamingServer? = streamingServers.firstOrNull { it.linkType == "HDS" }
    fun server(): MuStreamingServer? = hlsServer() ?: hdsServer()
}

@Serializable
data class MuStreamingServer(
        @SerialName("Server") val server: String,
        @SerialName("LinkType") val linkType: String,
        @SerialName("Qualities") val qualities: List<MuStreamQuality>,
        @SerialName("DynamicUserQualityChange") val dynamicUserQualityChange: Boolean,
        @SerialName("EncryptedServer") val encryptedServer: String)

@Serializable
data class MuStreamQuality(
        @SerialName("Kbps") val kbps: Int,
        @SerialName("Streams") val streams: List<MuStream>)

@Serializable
data class MuStream(
        @SerialName("Stream") val stream: String = "",
        @SerialName("EncryptedStream") val encryptedStream: String = "")

@Serializable
data class MuNowNext(
        @SerialName("ChannelSlug") val channelSlug: String,
        @SerialName("Channel") val channel: String = "",
        @SerialName("Now") val now: MuScheduleBroadcast? = null,
        @SerialName("Next") val next: List<MuScheduleBroadcast> = emptyList())

@Serializable
data class MuScheduleBroadcast(
        @SerialName("Title") val title: String,
        @SerialName("Description") val description: String,
        @SerialName("Subtitle") val subtitle: String = "",
        @SerialName("StartTime") @Serializable(with = DateSerializer::class) val startTime: Long,
        @SerialName("EndTime") @Serializable(with = DateSerializer::class) val endTime: Long,
        @SerialName("ProgramCard") val programCard: ProgramCard,
        @SerialName("OnlineGenreText") val onlineGenreText: String? = null,
        @SerialName("ProductionNumber") val productionNumber: String,
        @SerialName("ProgramCardHasPrimaryAsset") val programCardHasPrimaryAsset: Boolean,
        @SerialName("SeriesHasProgramCardWithPrimaryAsset") val seriesHasProgramCardWithPrimaryAsset: Boolean,
        @SerialName("AnnouncedStartTime") @Serializable(with = DateSerializer::class) val announcedStartTime: Long,
        @SerialName("AnnouncedEndTime") @Serializable(with = DateSerializer::class) val announcedEndTime: Long,
        @SerialName("ProductionCountry") val productionCountry: String,
        @SerialName("ProductionYear") val productionYear: Int = 0,
        @SerialName("VideoWidescreen") val videoWidescreen: Boolean = false,
        @SerialName("SubtitlesTTV") val subtitlesTTV: Boolean = false,
        @SerialName("VideoHD") val videoHD: Boolean = false,
        @SerialName("WhatsOnUri") val whatsOnUri: String,
        @SerialName("IsRerun") val isRerun: Boolean) {
    fun getPrimaryAssetUri(): String? = programCard.primaryAsset?.uri
}

@Serializable
data class ProgramCard(
        @SerialName("Type") val type: String,
        @SerialName("SeriesTitle") val seriesTitle: String = "",
        @SerialName("EpisodeTitle") val episodeTitle: String = "",
        @SerialName("SeriesSlug") val seriesSlug: String = "",
        @SerialName("SeriesUrn") val seriesUrn: String = "",
        @SerialName("HostName") val hostName: String = "",
        @SerialName("SeriesHostName") val seriesHostName: String = "",
        @SerialName("PrimaryChannel") val primaryChannel: String = "",
        @SerialName("PrimaryChannelSlug") val primaryChannelSlug: String = "",
        @SerialName("SeasonEpisodeNumberingValid") val seasonEpisodeNumberingValid: Boolean = false,
        @SerialName("SeasonTitle") val seasonTitle: String? = null,
        @SerialName("SeasonSlug") val seasonSlug: String? = null,
        @SerialName("SeasonUrn") val seasonUrn: String? = null,
        @SerialName("SeasonNumber") val seasonNumber: Int = 0,
        @SerialName("PrePremiere") val prePremiere: Boolean = false,
        @SerialName("ExpiresSoon") val expiresSoon: Boolean = false,
        @SerialName("OnlineGenreText") val onlineGenreText: String = "",
        @SerialName("PrimaryAsset") val primaryAsset: PrimaryAsset? = null,
        @SerialName("HasPublicPrimaryAsset") val hasPublicPrimaryAsset: Boolean = false,
        @SerialName("AssetTargetTypes") val assetTargetTypes: String = "",
        @SerialName("PrimaryBroadcastStartTime") @Serializable(with = DateSerializer::class) val primaryBroadcastStartTime: Long? = null,
        @SerialName("SortDateTime") @Serializable(with = DateSerializer::class) val sortDateTime: Long = 0L,
        @SerialName("OnDemandInfo") val onDemandInfo: Info? = null,
        @SerialName("Slug") val slug: String = "",
        @SerialName("Urn") val urn: String = "",
        @SerialName("PrimaryImageUri") val primaryImageUri: String = "",
        @SerialName("PresentationUri") val presentationUri: String = "",
        @SerialName("PresentationUriAutoplay") val presentationUriAutoplay: String = "",
        @SerialName("Title") val title: String,
        @SerialName("Subtitle") val subtitle: String = "",
        @SerialName("IsNewSeries") val isNewSeries: Boolean = false,
        @SerialName("OriginalTitle") val originalTitle: String = "",
        @SerialName("RectificationStatus") val rectificationStatus: String = "",
        @SerialName("RectificationAuto") val rectificationAuto: Boolean = false,
        @SerialName("RectificationText") val rectificationText: String = "")

@Serializable
data class Info(
        @SerialName("StartPublish") @Serializable(with = DateSerializer::class) val startPublish: Long,
        @SerialName("EndPublish") @Serializable(with = DateSerializer::class) val endPublish: Long)

@Serializable
data class PrimaryAsset(
        @SerialName("Kind") val kind: String,
        @SerialName("Uri") val uri: String,
        @SerialName("DurationInMilliseconds") val durationInMilliseconds: Long,
        @SerialName("Downloadable") val downloadable: Boolean = false,
        @SerialName("RestrictedToDenmark") val restrictedToDenmark: Boolean = false,
        @SerialName("StartPublish") @Serializable(with = DateSerializer::class) val startPublish: Long,
        @SerialName("EndPublish") @Serializable(with = DateSerializer::class) val endPublish: Long,
        @SerialName("Target") val target: String,
        @SerialName("Encrypted") val encrypted: Boolean,
        @SerialName("IsLiveStream") val isLiveStream: Boolean = false)

@Serializable
data class Manifest(
        @SerialName("Links") val links: List<Link>,
        @SerialName("SubtitlesList") val subtitlesList: List<Subtitle>) {
    fun getEncryptedUri(): String = links.firstOrNull { it.target == "HLS" }?.encryptedUri ?: ""
    private fun getHlsUri(): String? = links.firstOrNull { it.target == "HLS" }?.uri
    private fun getHdsUri(): String? = links.firstOrNull { it.target == "HDS" }?.uri
    fun getUri(): String? = getHlsUri() ?: getHdsUri()
}

@Serializable
data class Link(
        @SerialName("HardSubtitlesType") val hardSubtitlesType: String = "None",
        @SerialName("Uri") val uri: String? = null,
        @SerialName("EncryptedUri") val encryptedUri: String,
        @SerialName("FileFormat") val fileFormat: String,
        @SerialName("Target") val target: String,
        @SerialName("Bitrate") val bitrate: Int = 0)

@Serializable
data class Subtitle(
        @SerialName("Language") val language: String,
        @SerialName("MimeType") val mimeType: String,
        @SerialName("Type") val type: String,
        @SerialName("Uri") val uri: String)

@Serializable
data class MostViewed(
        @SerialName("Items") val items: List<ProgramCard>,
        @SerialName("Paging") val paging: MuPaging,
        @SerialName("TotalSize") val totalSize: Int)

@Serializable
data class Programs(
        @SerialName("Items") val items: List<ProgramCard>,
        @SerialName("Paging") val paging: MuPaging,
        @SerialName("TotalSize") val totalSize: Int)

@Serializable
data class Page(
        @SerialName("Programs") val programs: Programs)

sealed class Genre(internal val value: String) {
    object Drama : Genre("Drama")
    object Dokumentar : Genre("Dokumentar")
    object Livsstil : Genre("Livsstil")
    object Kultur : Genre("Kultur")
    object NaturViden : Genre("Natur & viden")
    object NyhederAktualitet : Genre("Nyheder & aktualitet")
    object Sport : Genre("Sport")
    object Underholdning : Genre("Underholdning")

    override fun toString(): String = value

    companion object {
        fun getByValue(value: String): Genre = when (value) {
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