package dk.youtec.drchannels

import android.app.Application
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drchannels.backend.OkHttpClientFactory
import dk.youtec.drchannels.util.koined
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

@Suppress("unused")
class DrApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            logger(Level.DEBUG)
            androidContext(this@DrApplication)
            modules(module {
                single { DrMuRepository(cacheDir.absolutePath) }
                single { OkHttpClientFactory.getInstance(this@DrApplication) }
            })
        }

        Picasso.setSingletonInstance(
                Picasso.Builder(this)
                        .downloader(OkHttp3Downloader(koined<OkHttpClient>()))
                        .build())
    }
}