package dk.youtec.appupdater

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v4.content.FileProvider
import android.util.Log
import kotlinx.coroutines.CommonPool
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.CacheControl
import okhttp3.Request
import java.io.File
import okio.Okio
import org.json.JSONArray

private const val tag = "AppUpdater"

/**
 * Updates the app to a newer version.
 *
 * @param metaUrl Url pointing to the output.json file from the Gradle build.
 * @param apkUrl Url pointing to the APK file.
 */
fun updateApp(context: Context, versionCode: Int, metaUrl: String, apkUrl: String) {
    launch(UI) {
        val metaAppVersion = getAppVersionFromMeta(context, metaUrl)
        Log.v(tag, "Meta has version code $metaAppVersion")

        if (metaAppVersion > versionCode) {
            AlertDialog.Builder(context)
                    .setTitle(context.getString(R.string.updateApp))
                    .setCancelable(true)
                    .setMessage(context.getString(R.string.newAppVersionReady))
                    .setPositiveButton(context.getString(R.string.update)) { _, _ ->
                        launch(UI) {
                            downloadApk(context, apkUrl)?.also {
                                installApk(context, it)
                            }
                        }
                    }
                    .create().show()
        } else {
            Log.d(tag, "App is the latest version $versionCode")
        }
    }
}

private suspend fun downloadApk(context: Context, apkUrl: String): File? = withContext(CommonPool) {
    val httpClient = OkHttpClientFactory.getInstance(context)

    val request = Request.Builder()
            .url(apkUrl)
            .cacheControl(CacheControl.Builder().noStore().build())
            .build()
    val response = httpClient.newCall(request).execute()
    val source = response.body()?.source()

    if (source != null) {
        val cacheDir = context.externalCacheDir ?: context.cacheDir
        val apkCacheFolder = File(cacheDir, "apk").apply { mkdirs() }
        val apkFile = File(apkCacheFolder, "app.apk").apply { createNewFile() }
        Okio.buffer(Okio.sink(apkFile)).apply {
            writeAll(source)
            close()
        }

        Log.v(tag, "Downloaded APK to ${apkFile.absolutePath} with size ${apkFile.length()}")

        apkFile
    } else {
        null
    }
}

private fun installApk(context: Context, apkFile: File) {
    try {
        val authority = "${context.packageName}.fileprovider"
        val uri = FileProvider.getUriForFile(context, authority, apkFile)
        val type = "application/vnd.android.package-archive"

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, type)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
        }

        context.startActivity(intent)
    } catch (e: Exception) {
        Log.e(tag, e.message, e)
    }
}

private suspend fun getAppVersionFromMeta(context: Context, metaUrl: String): Int = withContext(
        CommonPool) {
    val httpClient = OkHttpClientFactory.getInstance(context)

    val request = Request.Builder().url(metaUrl).build()
    val response = httpClient.newCall(request).execute()
    val metaString = response.body()?.string() ?: ""

    JSONArray(metaString).optJSONObject(0).optJSONObject("apkInfo")?.optInt("versionCode")
            ?: BuildConfig.VERSION_CODE
}
