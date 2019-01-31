package dk.youtec.drchannels.viewmodel

import android.util.Log
import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.CoroutineContext

@Keep
class ChannelsViewModel : ViewModel() {
    val channels: ChannelsLiveData = ChannelsLiveData()

    override fun onCleared() {
        channels.dispose()
    }
}

class ChannelsLiveData : LiveData<List<MuNowNext>>(), CoroutineScope, KoinComponent {
    private val tag = javaClass.simpleName
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private val api: DrMuRepository by inject()
    private var job: Job? = null

    /**
     * Subscribe to an internal observable that trigger the network request
     */
    fun subscribe() {
        Log.v(tag, "Subscribing for channel data")

        dispose()

        job = launch {
            while (true) {
                value = try {
                    withContext(Dispatchers.IO) {
                        api.getScheduleNowNext().filter { it.Now != null }
                    }
                } catch (e: Exception) {
                    Log.e(javaClass.simpleName, "Unable to get channel data")
                    emptyList()
                }

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

    override fun getValue(): List<MuNowNext> {
        return super.getValue().orEmpty()
    }

    override fun onActive() {
        subscribe()
    }

    override fun onInactive() {
        dispose()
    }
}