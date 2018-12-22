package dk.youtec.drapi.multiplatform

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor

actual object HttpClientFactory {
    actual fun create() = HttpClient(OkHttp) {
        engine {
            // https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.Builder.html
            config {
                // this: OkHttpClient.Builder ->
                connectTimeout(10, TimeUnit.SECONDS)
            }

            // https://square.github.io/okhttp/3.x/okhttp/okhttp3/Interceptor.html
            addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                System.out.println(message)
            }).apply { level = HttpLoggingInterceptor.Level.BODY })
            //addNetworkInterceptor(interceptor)
        }
    }
}