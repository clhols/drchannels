package dk.youtec.drapi

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios
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