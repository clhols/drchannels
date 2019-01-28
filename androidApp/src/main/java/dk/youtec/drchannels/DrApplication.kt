package dk.youtec.drchannels

import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dk.youtec.drchannels.backend.OkHttpClientFactory

@Suppress("unused")
class DrApplication : android.app.Application() {
    override fun onCreate() {
        super.onCreate()

        Picasso.setSingletonInstance(
                Picasso.Builder(this)
                        .downloader(OkHttp3Downloader(OkHttpClientFactory.getInstance(this)))
                        .build())
    }
}