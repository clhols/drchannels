package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class TvChannels(val api: DrMuRepository, override val coroutineContext: CoroutineContext) : CoroutineScope {
    private var job: Job? = null
    val channels = ConflatedBroadcastChannel<List<MuNowNext>>()

    /**
     * Start a coroutine that offers the list of channels every 30 seconds.
     */
    fun subscribe() {
        dispose()

        job = launch {
            while (true) {
                channels.offer(try {
                    withContext(Dispatchers.Default) {
                        api.getScheduleNowNext().filter { it.Now != null }
                    }
                } catch (e: Exception) {
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