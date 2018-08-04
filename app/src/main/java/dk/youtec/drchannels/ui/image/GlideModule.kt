package dk.youtec.drchannels.ui.image

import android.content.Context
import android.support.annotation.Keep
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import dk.youtec.drchannels.BuildConfig
import okhttp3.OkHttpClient
import java.io.InputStream
import java.util.concurrent.TimeUnit

@Keep
@GlideModule
class GlideModule : com.bumptech.glide.module.AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean = false

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.append(
                GlideUrl::class.java,
                InputStream::class.java,
                OkHttpUrlLoader.Factory(OkHttpClient.Builder().apply {
                    readTimeout(10, TimeUnit.SECONDS)
                    writeTimeout(10, TimeUnit.SECONDS)
                    connectTimeout(10, TimeUnit.SECONDS)
                }.build()))
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        if (BuildConfig.DEBUG) {
            builder.setLogLevel(Log.DEBUG)
        }
    }
}
