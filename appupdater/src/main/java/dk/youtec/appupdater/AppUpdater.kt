package dk.youtec.appupdater

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.CommonPool
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Request
import org.json.JSONArray
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
        context: Context,
        versionCode: Int,
        metaUrl: String,
        apkUrl: String,
        changelogUrl: String = "") = launch(UI) {
    val metaAppVersion = getAppVersionFromMeta(context, metaUrl)
    Log.v(tag, "Meta has version code $metaAppVersion")

    if (metaAppVersion > versionCode) {
        val changelog = getChangelog(context, changelogUrl)
        var message = context.getString(R.string.newAppVersionReady)
        if (changelog.isNotBlank()) message += "\n\n$changelog"

        AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.updateApp))
                .setCancelable(true)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.update)) { _, _ ->
                    context.startActivity(Intent(context, UpdateActivity::class.java).apply {
                        putExtra("apkUrl", apkUrl)
                    })
                }
                .create().show()
    } else {
        Log.d(tag, "App is the latest version $versionCode")
    }
}

private suspend fun getAppVersionFromMeta(
        context: Context,
        metaUrl: String
): Int = withContext(CommonPool) {
    val httpClient = OkHttpClientFactory.getInstance(context)

    val request = Request.Builder().url(metaUrl).build()
    val response = httpClient.newCall(request).execute()
    val metaString = response.body()?.string() ?: ""

    JSONArray(metaString)
            .optJSONObject(0)
            .optJSONObject("apkInfo")
            ?.optInt("versionCode") ?: BuildConfig.VERSION_CODE
}

private suspend fun getChangelog(
        context: Context,
        changelogUrl: String
): String = withContext(CommonPool) {
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
