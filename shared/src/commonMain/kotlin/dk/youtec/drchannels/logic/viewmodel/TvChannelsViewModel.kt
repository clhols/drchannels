package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface TvChannelsViewModel {
    val channels: Flow<List<MuNowNext>>
    val playback: SharedFlow<VideoItem>
    val error: SharedFlow<ChannelsError>

    fun playTvChannel(muNowNext: MuNowNext)
    fun playProgram(muNowNext: MuNowNext)
    fun onCleared()
}