package dk.youtec.drapi.multiplatform

import io.ktor.client.HttpClient

actual object HttpClientFactory {
    actual fun create(): HttpClient = HttpClient()
}