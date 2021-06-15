package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.Logger
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drchannels.logic.decryptUri
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock
import kotlin.coroutines.CoroutineContext
import kotlin.time.ExperimentalTime
import kotlin.time.days

open class ProgramsViewModelImpl : ProgramsViewModel, ViewModel, CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private val api = DrMuRepository()

    override val programs: StateFlow<List<MuScheduleBroadcast>> = MutableStateFlow(emptyList())
    override val playback: SharedFlow<Pair<String, String>> = MutableSharedFlow()
    override val error: SharedFlow<Exception> = MutableSharedFlow()

    override fun loadPrograms(channelId: String) {
        launch {
            try {
                supervisorScope {
                    programs.emit(emptyList())
                }
            } catch (e: Exception) {
                error.emit(ChannelsError.LoadingChannelsFailed)
            }
        }
    }

    override fun playProgram(program: MuScheduleBroadcast) {
        launch {
            val uri = program.programCard.primaryAsset?.uri
            if (uri != null) {
                try {
                    val manifest = api.getManifest(uri)
                    val playbackUri = manifest.getUri() ?: decryptUri(manifest.getEncryptedUri())
                    if (playbackUri.isNotBlank()) {
                        playback.emit(Pair(playbackUri, program.programCard.primaryImageUri))
                    } else {
                        error.emit(Exception("No stream"))
                    }
                } catch (e: Exception) {
                    error.emit(e)
                }
            } else {
                error.emit(Exception("No stream"))
            }
        }
    }

    override fun onCleared() {
        job.cancel()
    }

    private suspend fun <T> Deferred<T>.awaitOrNull(): T? {
        return try {
            await()
        } catch (e: Exception) {
            null
        }
    }
}

