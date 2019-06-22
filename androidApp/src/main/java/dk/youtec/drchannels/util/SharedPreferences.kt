package dk.youtec.drchannels.util

import android.content.Context
import androidx.core.content.edit

object SharedPreferences {
    fun getString(context: Context, key: String, default: String = ""): String =
            context.defaultSharedPreferences.getString(key, default) ?: default

    fun getLong(context: Context, key: String, default: Long = 0): Long =
            context.defaultSharedPreferences.getLong(key, default)

    fun setString(context: Context, key: String, value: String): Unit =
            context.defaultSharedPreferences.edit {
                putString(key, value)
            }

    fun setInt(context: Context, key: String, value: Int): Unit =
            context.defaultSharedPreferences.edit {
                putInt(key, value)
            }

    fun getBoolean(context: Context, key: String, default: Boolean = false): Boolean =
            context.defaultSharedPreferences.getBoolean(key, default)

    fun setBoolean(context: Context, key: String, value: Boolean): Unit =
            context.defaultSharedPreferences.edit {
                putBoolean(key, value)
            }
}