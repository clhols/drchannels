package dk.youtec.drchannels.viewmodel

import android.util.Log
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class TvChannels : CoroutineScope, KoinComponent {
    private val tag = javaClass.simpleName
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private val api: DrMuRepository by inject()
    private var job: Job? = null
    val stream = Channel<List<MuNowNext>>(CONFLATED)

    /**
     * Subscribe to an internal observable that trigger the network request
     */
    fun subscribe() {
        Log.v(tag, "Subscribing for channel data")

        dispose()

        job = launch {
            while (true) {
                stream.offer(try {
                    withContext(Dispatchers.IO) {
                        api.getScheduleNowNext().filter { it.Now != null }
                    }
                } catch (e: Exception) {
                    Log.e(javaClass.simpleName, "Unable to get channel data")
                    emptyList<MuNowNext>()
                })

                delay(30000)
            }
        }
    }

    /**
     * Disposes the current subscription
     */
    fun dispose() {
        job?.cancel()
    }
}