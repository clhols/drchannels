package dk.youtec.drchannels.viewmodel

import android.app.Application
import android.util.Log
import androidx.annotation.Keep
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuNowNext
import dk.youtec.drapi.decryptUri
import dk.youtec.drchannels.R
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.flow
import org.koin.core.KoinComponent
import org.koin.core.inject

@Keep
class TvChannelsViewModel(application: Application) : AndroidViewModel(application), KoinComponent {
    private val api: DrMuRepository by inject()
    private val tag = TvChannelsViewModel::class.java.simpleName

    private val tvChannels = TvChannels()
    private val playbackUriChannel = BroadcastChannel<String>(1)
    private val errorChannel = BroadcastChannel<String>(1)

    val channels = flow {
        tvChannels.channels.consumeEach { emit(it) }
    }
    val playbackUri = flow {
        playbackUriChannel.consumeEach { emit(it) }
    }
    val error = flow {
        errorChannel.consumeEach { emit(it) }
    }

    fun playTvChannel(muNowNext: MuNowNext) {
        viewModelScope.launch {
            try {
                val name = muNowNext.ChannelSlug
                val server = withContext(Dispatchers.IO) {
                    api.getAllActiveDrTvChannels()
                }
                        .first { it.Slug == name }
                        .server() ?: throw Exception("Unable to get streaming server")

                val stream = server
                        .Qualities
                        .sortedByDescending { it.Kbps }.first()
                        .Streams.first().Stream

                playbackUriChannel.offer("${server.Server}/$stream")
            } catch (e: Exception) {
                Log.e(tag, e.message, e)
                errorChannel.offer(if (e.message != null && e.message != "Success") {
                    e.message!!
                } else {
                    getApplication<Application>().getString(R.string.cantChangeChannel)
                })
            }
        }
    }

    fun playProgram(muNowNext: MuNowNext) {
        viewModelScope.launch {
            val uri = muNowNext.Now?.ProgramCard?.PrimaryAsset?.Uri
            if (uri != null) {
                try {
                    val manifest = withContext(Dispatchers.IO) { api.getManifest(uri) }

                    val playbackUri = manifest.getUri() ?: decryptUri(manifest.getEncryptedUri())
                    if (playbackUri.isNotBlank()) {
                        this@TvChannelsViewModel.playbackUriChannel.offer(playbackUri)
                    } else {
                        errorChannel.offer("No stream")
                    }
                } catch (e: Exception) {
                    errorChannel.offer(
                            if (e.message != null && e.message != "Success") e.message!!
                            else getApplication<Application>().getString(R.string.cantChangeChannel))
                }
            } else {
                errorChannel.offer("No stream")
            }
        }
    }

    fun reload() {
        tvChannels.subscribe()
    }

    override fun onCleared() {
        Log.d("", "View model was cleared")
        tvChannels.dispose()
        tvChannels.channels.cancel()
        playbackUriChannel.cancel()
        errorChannel.cancel()
    }
}

