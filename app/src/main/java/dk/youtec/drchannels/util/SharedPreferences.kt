package dk.youtec.drchannels.util

import android.content.Context
import org.jetbrains.anko.defaultSharedPreferences

inline fun Context.putPreference(
        block: android.content.SharedPreferences.Editor.() -> android.content.SharedPreferences.Editor) {
    defaultSharedPreferences
            .edit()
            .block()
            .apply()
}

object SharedPreferences {
    const val REMOTE_CONTROL_MODE = "remoteControlMode"

    fun getString(context: Context, key: String, default: String = ""): String =
            context.defaultSharedPreferences.getString(key, default)

    fun setString(context: Context, key: String, value: String) {
        context.defaultSharedPreferences
                .edit()
                .putString(key, value)
                .apply()
    }

    fun setInt(context: Context, key: String, value: Int) {
        context.defaultSharedPreferences
                .edit()
                .putInt(key, value)
                .apply()
    }

    fun getBoolean(context: Context, key: String, default: Boolean = false): Boolean =
            context.defaultSharedPreferences.getBoolean(key, default)

    fun setBoolean(context: Context, key: String, value: Boolean) {
        context.defaultSharedPreferences
                .edit()
                .putBoolean(key, value)
                .apply()
    }


}