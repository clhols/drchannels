package dk.youtec.drapi

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

actual object HttpClientFactory {
    actual fun create(): HttpClient = HttpClient()
}

@Suppress("unused")
class DrMuRepositoryCallback(
        override val coroutineContext: CoroutineContext // TODO: Use Dispatchers.Main instead when it is supported on iOS
) : DrMuRepository(), CoroutineScope {

    fun getAllActiveDrTvChannels(callback: (List<Channel>) -> Unit) = launch {
        callback(getAllActiveDrTvChannels())
    }

    fun getManifest(uri: String, callback: (Manifest) -> Unit) = launch {
        callback(getManifest(uri))
    }

    fun getSchedule(id: String, date: String, callback: (Schedule) -> Unit) = launch {
        callback(getSchedule(id, date))
    }

    fun getScheduleNowNext(id: String, callback: (MuNowNext) -> Unit) = launch {
        callback(getScheduleNowNext(id))
    }

    fun getScheduleNowNext(callback: (List<MuNowNext>) -> Unit) = launch {
        callback(getScheduleNowNext())
    }

    fun search(query: String, callback: (SearchResult) -> Unit) = launch {
        callback(search(query))
    }

    fun getMostViewed(
            channel: String,
            channelType: String,
            limit: Int,
            callback: (MostViewed) -> Unit
    ) = launch {
        callback(getMostViewed(channel, channelType, limit))
    }
}