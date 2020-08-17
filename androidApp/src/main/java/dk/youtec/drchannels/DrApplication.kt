package dk.youtec.drchannels

import android.app.Application
import coil.Coil
import coil.ImageLoader
import com.google.firebase.analytics.FirebaseAnalytics
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drchannels.backend.OkHttpClientFactory
import dk.youtec.drchannels.coil.ProgramCardMapper
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import dk.youtec.drchannels.util.koined
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.PrintLogger
import org.koin.dsl.module

@Suppress("unused")
class DrApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            logger(PrintLogger(Level.ERROR))
            androidContext(this@DrApplication)
            modules(module {
                single { CoroutineScope(SupervisorJob()) }
                single { DrMuRepository(cacheDir.absolutePath) }
                single { this@DrApplication }
                single { OkHttpClientFactory.getInstance(get()) }
                single { FirebaseAnalytics.getInstance(get()) }
                viewModel { AndroidTvChannelsViewModel() }
                single { Coil.imageLoader(get()) }
            })
        }

        Coil.setImageLoader(
                ImageLoader.Builder(koined())
                        .availableMemoryPercentage(0.3)
                        .crossfade(true)
                        .componentRegistry {
                            add(ProgramCardMapper())
                        }
                        .okHttpClient(koined() as OkHttpClient)
                        .build()
        )
    }
}