package dk.youtec.drapi

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.Cache
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import kotlin.time.ExperimentalTime

actual object HttpClientFactory {
    @UseExperimental(ExperimentalTime::class)
    actual fun create(cacheDir: String?, sizeBytes: Long) = HttpClient(OkHttp) {
        engine {
            // https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.Builder.html
            config {
                // this: OkHttpClient.Builder ->
                connectTimeout(10, TimeUnit.SECONDS)
                if (cacheDir != null) cache(Cache(File(cacheDir), sizeBytes))
            }

            // https://square.github.io/okhttp/3.x/okhttp/okhttp3/Interceptor.html
            addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.v("http", message)
                }
            }).apply { level = HttpLoggingInterceptor.Level.BASIC })
            addInterceptor(StaleIfErrorInterceptor())
        }
    }
}