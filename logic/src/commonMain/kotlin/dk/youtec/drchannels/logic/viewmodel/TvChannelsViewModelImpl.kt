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
    private val errorChannel = BroadcastChannel<String>(1)

    override val channels: Flow<List<MuNowNext>> = flow {
        while (true) {
            try {
                emit(api.getScheduleNowNext().filter { it.now != null })
                delay(30000)
            } catch (e: CancellationException) {
                return@flow
            } catch (e: Exception) {
                emit(emptyList())
                Logger.e(e, e.message ?: "")
                errorChannel.send(e.message ?: "Unknown error")
                delay(5000)
            }
        }
    }.flowOn(Dispatchers.Main)
    override val playback = playbackChannel.asFlow()
    override val error = errorChannel.asFlow()

    /**
     * Used by iOS to observe the channels Flow by having this VM collect and call [callback].
     * @return a Cancelable that can cancel the coroutine launched.
     */
    @Suppress("unused")
    fun observeChannels(callback: (List<MuNowNext>) -> Unit) : Cancelable {
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
    fun playTvChannel(muNowNext: MuNowNext, callback: (VideoItem) -> Unit) : Cancelable {
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
                //Change to Dispatchers.IO when available
                val server = withContext(Dispatchers.Default) {
                    api.getAllActiveDrTvChannels()
                }
                        .firstOrNull { it.slug == muNowNext.channelSlug }
                        ?.server() ?: throw Exception("Unable to get streaming server")

                val stream = server
                        .qualities.maxBy { it.kbps }!!
                        .streams.first().stream

                playbackChannel.offer(
                        VideoItem(
                                title,
                                "${server.server}/$stream",
                                muNowNext.now?.programCard?.primaryImageUri
                        )
                )
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
                        this@TvChannelsViewModelImpl.playbackChannel.offer(
                                VideoItem(
                                        muNowNext.now?.title?.toUpperCase() ?: "",
                                        playbackUri,
                                        muNowNext.now?.programCard?.primaryImageUri
                                )
                        )
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

    override fun onCleared() {
        playbackChannel.cancel()
        errorChannel.cancel()
        job.cancel()
    }
}

