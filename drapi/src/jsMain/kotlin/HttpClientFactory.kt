package dk.youtec.drapi

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js

actual object HttpClientFactory {
    actual fun create(cacheDir: String?, sizeBytes: Long): HttpClient = HttpClient(Js)
}