package dk.youtec.drapi.multiplatform

import io.ktor.client.request.get
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

class DrMuRepo: IDrMuApi {
    override suspend fun getAllActiveDrTvChannels(): List<Channel> {
        val url = "$API_URL/channel/all-active-dr-tv-channels"
        val client = HttpClientFactory.create()
        val json = client.get<String>(url)
        return JSON.parse(Channel.serializer().list, json)
    }

    override suspend fun getManifest(uri: String): Manifest {
        val client = HttpClientFactory.create()
        val json = client.get<String>(uri)
        return JSON.parse(Manifest.serializer(), json)
    }

    override suspend fun getSchedule(id: String, date: String): Schedule {
        val url = "$API_URL/schedule/$id?broadcastdate=$date"
        val client = HttpClientFactory.create()
        val json = client.get<String>(url)
        return JSON.parse(Schedule.serializer(), json)
    }

    override suspend fun getScheduleNowNext(id: String): MuNowNext {
        val url = "$API_URL/schedule/nownext/$id"
        val client = HttpClientFactory.create()
        val json = client.get<String>(url)
        return JSON.parse(MuNowNext.serializer(), json)
    }

    override suspend fun getScheduleNowNext(): List<MuNowNext> {
        val url = "$API_URL/schedule/nownext-for-all-active-dr-tv-channels"
        val client = HttpClientFactory.create()
        val json = client.get<String>(url)
        return JSON.parse(MuNowNext.serializer().list, json)
    }

    override suspend fun search(query: String): SearchResult {
        val url = "$API_URL/search/tv/programcards-with-asset/title/$query"
        val client = HttpClientFactory.create()
        val json = client.get<String>(url)
        return JSON.parse(SearchResult.serializer(), json)
    }

    override suspend fun getMostViewed(channel: String, channelType: String, limit: Int): MostViewed {
        val url = "$API_URL/list/view/mostviewed?channel=$channel&channelType=$channelType&limit=$limit"
        val client = HttpClientFactory.create()
        val json = client.get<String>(url)
        return JSON.parse(MostViewed.serializer(), json)
    }
}