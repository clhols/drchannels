package dk.youtec.drapi.multiplatform

import io.ktor.client.HttpClient
import kotlinx.coroutines.runBlocking

actual object HttpClientFactory {
    actual fun create(): HttpClient = HttpClient()
}

class DrMuRepoIos {
    val repo = DrMuRepo()
    fun getAllActiveDrTvChannels() = runBlocking {
        repo.getAllActiveDrTvChannels()
    }

    fun getScheduleNowNext() = runBlocking {
        repo.getScheduleNowNext()
    }
}