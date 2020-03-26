package dk.youtec.drapi

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import platform.Foundation.NSURLNetworkServiceTypeBackground

actual object HttpClientFactory {
    actual fun create(cacheDir: String?, sizeBytes: Long): HttpClient = HttpClient(Ios) {
        engine {
            configureSession {
                networkServiceType = NSURLNetworkServiceTypeBackground
            }
        }
    }
}

@Suppress("unused")
class DrMuRepositoryCallback : DrMuRepository() {

    fun getAllActiveDrTvChannels(callback: (List<Channel>) -> Unit) = GlobalScope.launch {
        callback(getAllActiveDrTvChannels())
    }

    fun getManifest(uri: String, callback: (Manifest) -> Unit) = GlobalScope.launch {
        callback(getManifest(uri))
    }

    fun getSchedule(id: String, date: String, callback: (Schedule) -> Unit) = GlobalScope.launch {
        callback(getSchedule(id, date))
    }

    fun getScheduleNowNext(id: String, callback: (MuNowNext) -> Unit) = GlobalScope.launch {
        callback(getScheduleNowNext(id))
    }

    fun getScheduleNowNext(callback: (List<MuNowNext>) -> Unit) = GlobalScope.launch {
        callback(getScheduleNowNext())
    }

    fun search(query: String, callback: (SearchResult) -> Unit) = GlobalScope.launch {
        callback(search(query))
    }

    fun getMostViewed(
            channel: String,
            channelType: String,
            limit: Int,
            callback: (MostViewed) -> Unit
    ) = GlobalScope.launch {
        callback(getMostViewed(channel, channelType, limit))
    }
}