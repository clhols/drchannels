package dk.youtec.drapi

import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

open class DrMuRepository(cacheDir: String? = null, sizeBytes: Long = defaultCacheSize) : IDrMuApi {
    private val client = HttpClientFactory
            .create(cacheDir, sizeBytes)
            .config {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(
                            Json(JsonConfiguration(ignoreUnknownKeys = true))
                    ).apply {
                        registerList(MuNowNext.serializer().list)
                    }
                }
            }

    override suspend fun getAllActiveDrTvChannels(): List<Channel> {
        val url = "$API_URL/channel/all-active-dr-tv-channels"
        return client.get(url)
    }

    override suspend fun getManifest(uri: String): Manifest {
        return client.get(uri)
    }

    override suspend fun getSchedule(id: String, date: String): Schedule {
        val url = "$API_URL/schedule/$id?broadcastdate=$date"
        return client.get(url)
    }

    override suspend fun getScheduleNowNext(id: String): MuNowNext {
        val url = "$API_URL/schedule/nownext/$id"
        return client.get(url)
    }

    override suspend fun getScheduleNowNext(): List<MuNowNext> {
        val url = "$API_URL/schedule/nownext-for-all-active-dr-tv-channels"
        return client.get(url)
    }

    override suspend fun search(query: String): SearchResult {
        val url = "$API_URL/search/tv/programcards-with-asset/title/$query"
        return client.get(url)
    }

    override suspend fun getMostViewed(channel: String, channelType: String, limit: Int): MostViewed {
        val url = "$API_URL/list/view/mostviewed?channel=$channel&channelType=$channelType&limit=$limit"
        return client.get(url)
    }

    override suspend fun getPageTvPrograms(genre: Genre): Page {
        val encodedGenre = genre.value
                .replace(" ", "%20")
                .replace("&", "%26")
        val url = "$API_URL/page/tv/programs?onlinegenretexts=$encodedGenre&orderBy=LastPrimaryBroadcastWithPublicAsset&orderDescending=True"
        return client.get(url)
    }
}

const val defaultCacheSize = 32 * 1024 * 1024L //32 MB