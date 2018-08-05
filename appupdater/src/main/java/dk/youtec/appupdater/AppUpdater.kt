package dk.youtec.appupdater

import android.content.Context
import android.content.Intent
import android.support.annotation.WorkerThread
import android.support.v4.content.FileProvider
import android.util.Log
import okhttp3.CacheControl
import okhttp3.Request
import java.io.File
import okio.Okio
import org.json.JSONArray

/**
 * Updates the app to a newer version.
 *
 * @param metaUrl Url pointing to the output.json file from the Gradle build.
 * @param apkUrl Url pointing to the APK file.
 */
@WorkerThread
fun updateApp(context: Context, versionCode: Int, metaUrl: String, apkUrl: String) {
    val tag = "AppUpdater"

    val metaAppVersion = getAppVersionFromMeta(context, metaUrl)
    Log.v(tag, "Meta has version code $metaAppVersion")

    if (metaAppVersion > versionCode) {
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
    } else {
        Log.d(tag, "App is the latest version $versionCode")
    }
}

@WorkerThread
private fun getAppVersionFromMeta(context: Context, metaUrl: String): Int {
    val httpClient = OkHttpClientFactory.getInstance(context)

    val request = Request.Builder().url(metaUrl).build()
    val response = httpClient.newCall(request).execute()
    val metaString = response.body()?.string() ?: ""

    return JSONArray(metaString).optJSONObject(0).optJSONObject("apkInfo")?.optInt("versionCode")
            ?: BuildConfig.VERSION_CODE
}
