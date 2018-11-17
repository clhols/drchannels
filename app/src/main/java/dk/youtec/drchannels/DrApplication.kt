package dk.youtec.drchannels

import android.os.Looper
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dk.youtec.drchannels.backend.OkHttpClientFactory
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers

@Suppress("unused")
class DrApplication : android.app.Application() {
    override fun onCreate() {
        super.onCreate()

        Picasso.setSingletonInstance(
                Picasso.Builder(this)
                        .downloader(OkHttp3Downloader(OkHttpClientFactory.getInstance(this)))
                        .build())

        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            AndroidSchedulers.from(Looper.getMainLooper(), true)
        }
    }
}