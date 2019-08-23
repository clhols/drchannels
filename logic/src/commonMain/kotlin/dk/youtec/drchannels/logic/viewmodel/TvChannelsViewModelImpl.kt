package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MainDispatcher
import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
open class TvChannelsViewModelImpl : TvChannelsViewModel, CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + MainDispatcher

    private val api = DrMuRepository()

    private val tvChannels = TvChannels(api, this)
    private val playbackUriChannel = BroadcastChannel<String>(1)
    private val errorChannel = BroadcastChannel<String>(1)

    override val channels = tvChannels.channels.asFlow()
    override val playbackUri = playbackUriChannel.asFlow()
    override val error = errorChannel.asFlow()

    fun observeChannels(callback: (List<MuNowNext>) -> Unit) {
        launch {
            channels.collect { channels ->
                callback(channels)
            }
        }
    }

    override fun playTvChannel(muNowNext: MuNowNext) {
        launch {
            try {
                val name = muNowNext.channelSlug
                //Change to Dispatchers.IO when available
                val server = withContext(Dispatchers.Default) {
                    api.getAllActiveDrTvChannels()
                }
                        .first { it.slug == name }
                        .server() ?: throw Exception("Unable to get streaming server")

                val stream = server
                        .qualities.maxBy { it.kbps }!!
                        .streams.first().stream

                playbackUriChannel.offer("${server.server}/$stream")
            } catch (e: Exception) {
                errorChannel.offer(if (e.message != null && e.message != "Success") {
                    e.message!!
                } else {
                    "Can't change channel"
                })
            }
        }
    }

    override fun playProgram(muNowNext: MuNowNext) {
        launch {
            val uri = muNowNext.now?.programCard?.primaryAsset?.uri
            if (uri != null) {
                try {
                    //Change to Dispatchers.IO when available
                    val manifest = withContext(Dispatchers.Default) {
                        api.getManifest(uri)
                    }

                    val playbackUri = manifest.getUri() ?: decryptUri(manifest.getEncryptedUri())
                    if (playbackUri.isNotBlank()) {
                        this@TvChannelsViewModelImpl.playbackUriChannel.offer(playbackUri)
                    } else {
                        errorChannel.offer("No stream")
                    }
                } catch (e: Exception) {
                    errorChannel.offer(
                            if (e.message != null && e.message != "Success") e.message!!
                            else "Can't change channel")
                }
            } else {
                errorChannel.offer("No stream")
            }
        }
    }

    override fun reload() {
        tvChannels.subscribe()
    }

    override fun onCleared() {
        tvChannels.dispose()
        tvChannels.channels.cancel()
        playbackUriChannel.cancel()
        errorChannel.cancel()
        job.cancel()
    }
}

