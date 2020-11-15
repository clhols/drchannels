package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.Logger
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drapi.Schedule
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock
import kotlin.coroutines.CoroutineContext
import kotlin.time.days

open class ProgramsViewModelImpl : ProgramsViewModel, CoroutineScope {

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
                    val tomorrowDeferred = async { getSchedule(channelId, 1) }
                    val todayDeferred = async { getSchedule(channelId, 0) }
                    val yesterdayDeferred = async { getSchedule(channelId, -1) }
                    val twoDaysAgoDeferred = async { getSchedule(channelId, -2) }

                    val tomorrow = tomorrowDeferred.awaitOrNull() ?: emptySchedule()
                    val today = todayDeferred.awaitOrNull() ?: emptySchedule()
                    val yesterday = yesterdayDeferred.awaitOrNull() ?: emptySchedule()
                    val twoDaysAgo = twoDaysAgoDeferred.awaitOrNull() ?: emptySchedule()

                    val allBroadcasts = twoDaysAgo.broadcasts +
                            yesterday.broadcasts +
                            today.broadcasts +
                            tomorrow.broadcasts

                    programs.emit(allBroadcasts)
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

    /**
     * Gets the schedule of [channelId] with [daysOffset] relative to the current date.
     */
    private suspend fun getSchedule(
            channelId: String,
            daysOffset: Int
    ): Schedule {
        val date = Clock.System.now().plus(daysOffset.days).toString()
        return try {
            api.getSchedule(channelId, date)
        } catch (e: Exception) {
            Logger.e(e, e.message ?: "")
            emptySchedule()
        }
    }

    override fun onCleared() {
        job.cancel()
    }

    private fun emptySchedule() = Schedule(emptyList(), 0, "", "")

    private suspend fun <T> Deferred<T>.awaitOrNull(): T? {
        return try {
            await()
        } catch (e: Exception) {
            null
        }
    }
}

