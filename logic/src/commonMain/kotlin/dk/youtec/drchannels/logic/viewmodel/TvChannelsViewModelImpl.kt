package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi @FlowPreview
open class TvChannelsViewModelImpl(
        override val coroutineContext: CoroutineContext
) : CoroutineScope, TvChannelsViewModel {
    private val api: DrMuRepository = DrMuRepository()

    private val tvChannels = TvChannels(api, coroutineContext)
    private val playbackUriChannel = BroadcastChannel<String>(1)
    private val errorChannel = BroadcastChannel<String>(1)

    override val channels = tvChannels.channels.asFlow()
    override val playbackUri = playbackUriChannel.asFlow()
    override val error = errorChannel.asFlow()

    override fun playTvChannel(muNowNext: MuNowNext) {
        launch {
            try {
                val name = muNowNext.ChannelSlug
                val server = withContext(Dispatchers.Default) {
                    api.getAllActiveDrTvChannels()
                }
                        .first { it.Slug == name }
                        .server() ?: throw Exception("Unable to get streaming server")

                val stream = server
                        .Qualities.maxBy { it.Kbps }!!
                        .Streams.first().Stream

                playbackUriChannel.offer("${server.Server}/$stream")
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
            val uri = muNowNext.Now?.ProgramCard?.PrimaryAsset?.Uri
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

