package dk.youtec.drapi.multiplatform

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios

actual object HttpClientFactory {
    actual fun create(): HttpClient = HttpClient(Ios)
}