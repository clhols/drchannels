package dk.youtec.appupdater

import android.content.Context
import android.util.Log
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

object OkHttpClientFactory {

    private val TAG = OkHttpClientFactory::class.java.simpleName
    private const val SIZE_OF_CACHE: Long = 10 * 1024 * 1024
    private var client: OkHttpClient? = null

    /**
     * It is an error to have multiple caches accessing the same cache directory simultaneously.
     * Most applications should call new OkHttpClient() exactly once, configure it with their cache,
     * and use that same instance everywhere. Otherwise the two cache instances will stomp on each other,
     * corrupt the response cache, and possibly crash your program.
     *
     *
     * https://github.com/square/okhttp/wiki/Recipes#response-caching

     * @return singleTon instance of the OkHttpClient.
     */
    fun getInstance(context: Context): OkHttpClient {
        return if (client == null) {
            val builder = OkHttpClient.Builder()
            builder.connectTimeout(30, TimeUnit.SECONDS)
            builder.writeTimeout(30, TimeUnit.SECONDS)
            builder.readTimeout(30, TimeUnit.SECONDS)

            builder.addNetworkInterceptor(LoggingInterceptor())

            enableCache(context, builder)

            client = builder.build()
            client as OkHttpClient
        } else {
            client as OkHttpClient
        }
    }

    private fun enableCache(context: Context, builder: OkHttpClient.Builder) {
        try {
            val cacheDirectory = File(context.cacheDir.absolutePath, "appupdater")
            val responseCache = Cache(cacheDirectory, SIZE_OF_CACHE)
            builder.cache(responseCache)
        } catch (e: Exception) {
            Log.d(TAG, "Unable to set http cache", e)
        }
    }

    fun clearCache() {
        try {
            client?.cache()?.evictAll()
        } catch (e: IOException) {
            Log.e(TAG, e.message, e)
        }
    }

    private class LoggingInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            val startTime = System.nanoTime()
            Log.v(TAG, "Sending request ${request.url()}")

            val response = chain.proceed(request)

            Log.v(TAG, String.format(
                    "Received response for %s in %.1fms%n",
                    response.request().url(),
                    (System.nanoTime() - startTime) / 1e6))

            return response
        }
    }
}
