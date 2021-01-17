@file:Suppress("unused")

package dk.youtec.drchannels.backend

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.koin.java.KoinJavaComponent.inject
import java.io.IOException

const val TAG = "http"

/**
 * Get a response from a http request to the URL.

 * @param urlAddress The URL to open.
 * *
 * @return [Response] response of the http request. Remember to close it when done.
 */
@Throws(IOException::class)
fun getHttpResponse(urlAddress: String): Response {
    try {
        val request = Request.Builder()
                .url(urlAddress)
                .build()

        val client: OkHttpClient by inject(OkHttpClient::class.java)

        var response: Response? = null
        try {
            response = client.newCall(request).execute()
            if (!response.isSuccessful)
                throw HttpException(response.code, "Unexpected code $response")

            return response
        } catch (e: HttpException) {
            if (e.code != 404) {
                Log.w(TAG, e.message, e)
            } else {
                Log.w(TAG, e.message!!)
            }
            closeResponse(response)
            throw e
        }

    } catch (e: IllegalArgumentException) {
        throw IOException(e.message, e)
    }
}

fun closeResponse(response: Response?) {
    response?.body?.close()
}

class HttpException(val code: Int, httpMessage: String) : IOException(httpMessage)