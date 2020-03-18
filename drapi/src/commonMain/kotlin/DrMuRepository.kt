package dk.youtec.drapi

import io.ktor.client.request.get
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

open class DrMuRepository(cacheDir: String? = null, sizeBytes: Long = defaultCacheSize): IDrMuApi {
    private val client = HttpClientFactory.create(cacheDir, sizeBytes)
    private val parser = Json(JsonConfiguration(ignoreUnknownKeys = true))

    override suspend fun getAllActiveDrTvChannels(): List<Channel> {
        val url = "$API_URL/channel/all-active-dr-tv-channels"
        val json = client.get<String>(url)
        return parser.parse(Channel.serializer().list, json)
    }

    override suspend fun getManifest(uri: String): Manifest {
        val json = client.get<String>(uri)
        return parser.parse(Manifest.serializer(), json)
    }

    override suspend fun getSchedule(id: String, date: String): Schedule {
        val url = "$API_URL/schedule/$id?broadcastdate=$date"
        val json = client.get<String>(url)
        return parser.parse(Schedule.serializer(), json)
    }

    override suspend fun getScheduleNowNext(id: String): MuNowNext {
        val url = "$API_URL/schedule/nownext/$id"
        val json = client.get<String>(url)
        return parser.parse(MuNowNext.serializer(), json)
    }

    override suspend fun getScheduleNowNext(): List<MuNowNext> {
        val url = "$API_URL/schedule/nownext-for-all-active-dr-tv-channels"
        val json = client.get<String>(url)
        return parser.parse(MuNowNext.serializer().list, json)
    }

    override suspend fun search(query: String): SearchResult {
        val url = "$API_URL/search/tv/programcards-with-asset/title/$query"
        val json = client.get<String>(url)
        return parser.parse(SearchResult.serializer(), json)
    }

    override suspend fun getMostViewed(channel: String, channelType: String, limit: Int): MostViewed {
        val url = "$API_URL/list/view/mostviewed?channel=$channel&channelType=$channelType&limit=$limit"
        val json = client.get<String>(url)
        return parser.parse(MostViewed.serializer(), json)
    }

    override suspend fun getPageTvPrograms(genre: Genre): Page {
        val encodedGenre = genre.value
                .replace(" ", "%20")
                .replace("&", "%26")
        val url = "$API_URL/page/tv/programs?onlinegenretexts=$encodedGenre&orderBy=LastPrimaryBroadcastWithPublicAsset&orderDescending=True"
        val json = client.get<String>(url)
        return parser.parse(Page.serializer(), json)
    }
}

const val defaultCacheSize = 32 * 1024 * 1024L //32 MB