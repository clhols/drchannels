package dk.youtec.drapi

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

actual object HttpClientFactory {
    actual fun create(): HttpClient = HttpClient()
}

@Suppress("unused")
class DrMuRepoIos(
        private val mainContext: CoroutineContext // TODO: Use Dispatchers.Main instead when it is supported on iOS
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = mainContext

    private val repo = DrMuRepository()

    fun getAllActiveDrTvChannels(callback: (List<Channel>) -> Unit) {
        launch { callback(repo.getAllActiveDrTvChannels()) }
    }

    fun getManifest(uri: String, callback: (Manifest) -> Unit) {
        launch { callback(repo.getManifest(uri)) }
    }

    fun getSchedule(id: String, date: String, callback: (Schedule) -> Unit) {
        launch { callback(repo.getSchedule(id, date)) }
    }

    fun getScheduleNowNext(id: String, callback: (MuNowNext) -> Unit) {
        launch { callback(repo.getScheduleNowNext(id)) }
    }

    fun getScheduleNowNext(callback: (List<MuNowNext>) -> Unit) {
        launch { callback(repo.getScheduleNowNext()) }
    }

    fun search(query: String, callback: (SearchResult) -> Unit) {
        launch { callback(repo.search(query)) }
    }

    fun getMostViewed(
            channel: String,
            channelType: String,
            limit: Int,
            callback: (MostViewed) -> Unit
    ) {
        launch { callback(repo.getMostViewed(channel, channelType, limit)) }
    }
}