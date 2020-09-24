package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.Logger
import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

open class TvChannelsViewModelImpl : TvChannelsViewModel, CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private val api = DrMuRepository()

    private val playbackChannel = BroadcastChannel<VideoItem>(1)
    private val errorChannel = BroadcastChannel<ChannelsError>(1)

    override val channels: StateFlow<List<MuNowNext>> = MutableStateFlow(emptyList())

    override val playback = playbackChannel.asFlow()
    override val error = errorChannel.asFlow()

    init {
        launch {
            //TODO Find a way to connect this coroutine to collecting from [channels]
            while (true) {
                try {
                    channels.state = api.getScheduleNowNext().filter { it.now != null }
                    delay(30000)
                } catch (e: CancellationException) {
                    return@launch
                } catch (e: Exception) {
                    Logger.e(e, e.message ?: "")
                    errorChannel.send(ChannelsError.LoadingChannelsFailed)
                    delay(5000)
                }
            }
        }
    }

    /**
     * Used by iOS to observe the channels Flow by having this VM collect and call [callback].
     * @return a Cancelable that can cancel the coroutine launched.
     */
    @Suppress("unused")
    fun observeChannels(callback: (List<MuNowNext>) -> Unit): Cancelable {
        val job = launch {
            channels.collect { channels ->
                callback(channels)
            }
        }
        return object : Cancelable {
            override fun cancel() {
                job.cancel()
            }
        }
    }

    @Suppress("unused")
    fun observeError(callback: (ChannelsError) -> Unit): Cancelable {
        val job = launch {
            error.collect { error ->
                callback(error)
            }
        }
        return object : Cancelable {
            override fun cancel() {
                job.cancel()
            }
        }
    }

    @Suppress("unused")
    fun playTvChannel(muNowNext: MuNowNext, callback: (VideoItem) -> Unit): Cancelable {
        val job = launch {
            playback.collect { videoItem ->
                callback(videoItem)
            }
        }
        playTvChannel(muNowNext)
        return object : Cancelable {
            override fun cancel() {
                job.cancel()
            }
        }
    }

    override fun playTvChannel(muNowNext: MuNowNext) {
        launch {
            try {
                val title = muNowNext.now?.title ?: muNowNext.channelSlug.toUpperCase()
                val server = api.getAllActiveDrTvChannels()
                        .firstOrNull { it.slug == muNowNext.channelSlug }
                        ?.server() ?: throw Exception("Unable to get streaming server")

                val stream = server
                        .qualities.maxByOrNull { it.kbps }
                        ?.streams?.first()?.stream ?: ""

                playbackChannel.offer(
                        VideoItem(
                                title,
                                "${server.server}/$stream",
                                muNowNext.now?.programCard?.primaryImageUri
                        )
                )
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
                        this@TvChannelsViewModelImpl.playbackChannel.offer(
                                VideoItem(
                                        muNowNext.now?.title?.toUpperCase() ?: "",
                                        playbackUri,
                                        muNowNext.now?.programCard?.primaryImageUri
                                )
                        )
                    } else {
                        errorChannel.offer(ChannelsError.NoStream)
                    }
                } catch (e: Exception) {
                    handleException(e)
                }
            } else {
                errorChannel.offer(ChannelsError.NoStream)
            }
        }
    }

    override fun onCleared() {
        playbackChannel.cancel()
        errorChannel.cancel()
        job.cancel()
    }

    private fun handleException(e: Exception) {
        errorChannel.offer(if (e.message != null && e.message != "Success") {
            ChannelsError.LoadingChannelFailed(e.message)
        } else {
            ChannelsError.LoadingChannelFailed("Can't change channel")
        })
    }
}

