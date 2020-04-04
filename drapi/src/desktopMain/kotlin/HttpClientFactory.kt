package dk.youtec.drapi

import io.ktor.client.HttpClient
import io.ktor.client.engine.curl.Curl

actual object HttpClientFactory {
    actual fun create(cacheDir: String?, sizeBytes: Long): HttpClient = HttpClient(Curl)
}