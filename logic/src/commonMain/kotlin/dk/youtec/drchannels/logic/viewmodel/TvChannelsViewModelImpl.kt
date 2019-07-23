package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow

@ExperimentalCoroutinesApi
@FlowPreview
open class TvChannelsViewModelImpl(
        private val viewModelScope: CoroutineScope
) : TvChannelsViewModel {
    private val api: DrMuRepository = DrMuRepository()

    private val tvChannels = TvChannels(api, viewModelScope)
    private val playbackUriChannel = BroadcastChannel<String>(1)
    private val errorChannel = BroadcastChannel<String>(1)

    override val channels = tvChannels.channels.asFlow()
    override val playbackUri = playbackUriChannel.asFlow()
    override val error = errorChannel.asFlow()

    override fun playTvChannel(muNowNext: MuNowNext) {
        viewModelScope.launch {
            try {
                val name = muNowNext.channelSlug
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
        viewModelScope.launch {
            val uri = muNowNext.now?.programCard?.primaryAsset?.uri
            if (uri != null) {
                try {
                    val manifest = withContext(Dispatchers.Default) { api.getManifest(uri) }

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
    }
}

