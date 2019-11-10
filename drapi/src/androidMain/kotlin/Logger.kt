package dk.youtec.drapi

import android.util.Log

actual object Logger {
    private const val tag = "drapi"

    actual fun v(message: String) {
        Log.v(tag,  message)
    }

    actual fun d(message: String) {
        Log.d(tag,  message)
    }

    actual fun e(e: Exception, message: String) {
        Log.e(tag,  message, e)
    }
}