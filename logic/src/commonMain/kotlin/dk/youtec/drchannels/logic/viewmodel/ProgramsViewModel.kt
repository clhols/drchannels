package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.MuScheduleBroadcast
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface ProgramsViewModel {
    val programs: StateFlow<List<MuScheduleBroadcast>>
    val playback: SharedFlow<Pair<String, String>>
    val error: SharedFlow<Exception>
    fun loadPrograms(channelId: String)
    fun playProgram(program: MuScheduleBroadcast)
    fun onCleared()
}