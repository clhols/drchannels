package dk.youtec.drapi.multiplatform

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

actual object HttpClientFactory {
    actual fun create(): HttpClient = HttpClient()
}

class DrMuRepoIos(
        private val mainContext: CoroutineContext, // TODO: Use Dispatchers.Main instead when it is supported on iOS
        private val callback: (List<Channel>) -> Unit
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = mainContext

    private val repo = DrMuRepo()

    fun getAllActiveDrTvChannels() {
        launch {
            val channels = repo.getAllActiveDrTvChannels()
            callback(channels)
        }
    }
}