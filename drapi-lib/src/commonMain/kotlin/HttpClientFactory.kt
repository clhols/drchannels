package dk.youtec.drapi.multiplatform

import io.ktor.client.HttpClient

expect object HttpClientFactory {
    fun create() : HttpClient
}