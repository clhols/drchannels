package dk.youtec.drapi

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.days

@ExperimentalTime
open class StaleIfErrorInterceptor(
        private val staleDuration: Duration = 28.days
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response? = null
        var originalException: Exception? = null
        val request = chain.request()

        try {
            response = chain.proceed(request)

            if (response.isSuccessful) {
                return response
            }
        } catch (e: Exception) {
            // Original request error
            originalException = e
        }

        if (response == null || !response.isSuccessful) {
            val cacheControl = CacheControl.Builder().onlyIfCached()
                    .maxStale(staleDuration.inMilliseconds.toInt(), TimeUnit.MILLISECONDS)
                    .build()
            val newRequest = request.newBuilder().cacheControl(cacheControl).build()
            try {
                val staleResponse = chain.proceed(newRequest)
                if (staleResponse.isSuccessful) {
                    return staleResponse
                }
            } catch (e: Exception) {
                // Cache not available
            }
        }
        return response ?: throw originalException ?: throw IOException()
    }
}