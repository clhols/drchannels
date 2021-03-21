package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.Channel
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.Logger
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.logic.decryptUri
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

open class TvChannelsViewModelImpl : TvChannelsViewModel, ViewModel, CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private val api = DrMuRepository()

    override val playback: SharedFlow<VideoItem> = MutableSharedFlow()
    override val error: SharedFlow<ChannelsError> = MutableSharedFlow()

    override val channels: Flow<List<Channel>> = flow {
        while (true) {
            try {
                emit(api.getAllActiveDrTvChannels().sortedBy { it.title.replace(" ", "") }
                    .filter { it.slug in listOf("dr1", "dr2", "dr-ramasjang", "eva") })
                delay(30000)
            } catch (e: CancellationException) {
                return@flow
            } catch (e: Exception) {
                Logger.e(e, e.message ?: "")
                error.emit(ChannelsError.LoadingChannelsFailed)
                delay(5000)
            }
        }
    }


    /**
     * Used by iOS to observe the channels Flow by having this VM collect and call [callback].
     * @return a Cancelable that can cancel the coroutine launched.
     */
    @Suppress("unused")
    fun observeChannels(callback: (List<Channel>) -> Unit): Cancelable {
        val job = launch {
            channels.collect { channels ->
                callback(channels)
            }
        }
        return Cancelable { job.cancel() }
    }

    @Suppress("unused")
    fun observeError(callback: (ChannelsError) -> Unit): Cancelable {
        val job = launch {
            error.collect { error ->
                callback(error)
            }
        }
        return Cancelable { job.cancel() }
    }

    @Suppress("unused")
    fun playTvChannel(videoItem: VideoItem, callback: (VideoItem) -> Unit): Cancelable {
        val job = launch {
            playback.collect { videoItem ->
                callback(videoItem)
            }
        }
        playTvChannel(videoItem)
        return Cancelable { job.cancel() }
    }

    override fun playTvChannel(videoItem: VideoItem) {
        launch {
            try {
                playback.emit(videoItem)
            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    override fun playProgram(muNowNext: MuNowNext) {
        launch {
            val uri = muNowNext.now?.programCard?.primaryAsset?.uri
            if (uri != null) {
                try {
                    val manifest = api.getManifest(uri)

                    val playbackUri = manifest.getUri() ?: decryptUri(manifest.getEncryptedUri())
                    if (playbackUri.isNotBlank()) {
                        this@TvChannelsViewModelImpl.playback.emit(
                            VideoItem(
                                muNowNext.now?.title?.toUpperCase() ?: "",
                                playbackUri,
                                muNowNext.now?.programCard?.primaryImageUri
                            )
                        )
                    } else {
                        error.emit(ChannelsError.NoStream)
                    }
                } catch (e: Exception) {
                    handleException(e)
                }
            } else {
                error.emit(ChannelsError.NoStream)
            }
        }
    }

    override fun onCleared() {
        job.cancel()
    }

    private suspend fun handleException(e: Exception) {
        error.emit(
            if (e.message != null && e.message != "Success") {
                ChannelsError.LoadingChannelFailed(e.message)
            } else {
                ChannelsError.LoadingChannelFailed("Can't change channel")
            }
        )
    }
}

