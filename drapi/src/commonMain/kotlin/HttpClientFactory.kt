package dk.youtec.drapi

import io.ktor.client.HttpClient

expect object HttpClientFactory {
    fun create(cacheDir: String?, sizeBytes: Long) : HttpClient
}