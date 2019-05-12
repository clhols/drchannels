package dk.youtec.appupdater

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import okhttp3.Request
import java.io.IOException

private const val tag = "AppUpdater"

/**
 * Updates the app to a newer version.
 *
 * @param metaUrl Url pointing to the output.json file from the Gradle build.
 * @param apkUrl Url pointing to the APK file.
 * @param changelogUrl Url pointing to a file with the changelog.
 */
@JvmOverloads
fun updateApp(
        activity: Activity,
        versionCode: Int,
        metaUrl: String,
        apkUrl: String,
        changelogUrl: String = "") = GlobalScope.launch(Dispatchers.Main) {
    if (versionCode == 1) {
        Log.v(tag, "App has debug version code $versionCode")
    } else {
        val metaAppVersion = getAppVersionFromMeta(activity, metaUrl)
        Log.v(tag, "Meta has version code $metaAppVersion")

        if (metaAppVersion > versionCode) {
            val message = activity.getString(R.string.newAppVersionReady) +
                    getChangelog(activity, changelogUrl).let {
                        if (it.isNotBlank()) "\n\n$it" else ""
                    }

            if (!activity.isFinishing) {
                showUpdateDialog(activity, message, apkUrl)
            }
        } else {
            Log.d(tag, "App is the latest version $versionCode")
        }
    }
}

private fun showUpdateDialog(activity: Activity, message: String, apkUrl: String) {
    AlertDialog.Builder(activity)
            .setTitle(activity.getString(R.string.updateApp))
            .setCancelable(true)
            .setMessage(message)
            .setPositiveButton(activity.getString(R.string.update)) { _, _ ->
                activity.startActivity(Intent(activity, UpdateActivity::class.java).apply {
                    putExtra("apkUrl", apkUrl)
                })
            }
            .create().show()
}

private suspend fun getAppVersionFromMeta(
        context: Context,
        metaUrl: String
): Int = withContext(Dispatchers.IO) {
    try {
        val httpClient = OkHttpClientFactory.getInstance(context)

        val request = Request.Builder().url(metaUrl).build()
        val response = httpClient.newCall(request).execute()
        val metaString = response.body()?.string() ?: ""

        extractVersionCode(metaString)
    } catch (e: IOException) {
        Log.w(tag, e.message)
        BuildConfig.VERSION_CODE
    }
}

internal fun extractVersionCode(metaString: String): Int {
    val outputs = Json.nonstrict.parse(Output.serializer().list, metaString) as? List<*>
            ?: emptyList<Output>()

    return outputs
            .asSequence()
            .filterIsInstance<Output>()
            .firstOrNull()?.apkInfo?.versionCode ?: BuildConfig.VERSION_CODE
}

private suspend fun getChangelog(
        context: Context,
        changelogUrl: String
): String = withContext(Dispatchers.IO) {
    if (changelogUrl.isNotBlank()) {
        try {
            val httpClient = OkHttpClientFactory.getInstance(context)

            val request = Request.Builder().url(changelogUrl).build()
            val response = httpClient.newCall(request).execute()
            response.body()?.string() ?: ""
        } catch (e: IOException) {
            Log.e(tag, e.message, e)
            ""
        }
    } else ""
}
