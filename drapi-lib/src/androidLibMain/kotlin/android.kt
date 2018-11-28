package dk.youtec.drapi.multiplatform

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.serialization.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

actual object HttpClientFactory {
    actual fun create() = HttpClient(OkHttp) {
        engine {
            // https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.Builder.html
            config { // this: OkHttpClient.Builder ->
                followRedirects = true
            }

            // https://square.github.io/okhttp/3.x/okhttp/okhttp3/Interceptor.html
            //addInterceptor(interceptor)
            //addNetworkInterceptor(interceptor)
        }
    }
}

@Serializer(forClass = java.util.Date::class)
actual object DateSerializer: KSerializer<Date> {
    private val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
    private val df2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)

    actual override fun serialize(output: Encoder, obj: java.util.Date) {
        output.encodeString(df.format(obj))
    }

    actual override fun deserialize(input: Decoder): java.util.Date {
        val json = input.decodeString()
        return try {
            df.parse(json)
        } catch (e: ParseException) {
            df2.parse(json)
        }
    }
}

actual typealias Date = java.util.Date