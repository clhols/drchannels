package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface TvChannelsViewModel {
    val channels: StateFlow<List<MuNowNext>>
    val playback: SharedFlow<VideoItem>
    val error: SharedFlow<ChannelsError>

    fun playTvChannel(muNowNext: MuNowNext)
    fun playProgram(muNowNext: MuNowNext)
    fun onCleared()
}