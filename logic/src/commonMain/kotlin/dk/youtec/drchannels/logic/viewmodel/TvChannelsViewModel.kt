package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
interface TvChannelsViewModel {
    val channels: Flow<List<MuNowNext>>
    val playbackUri: Flow<String>
    val error: Flow<String>

    fun playTvChannel(muNowNext: MuNowNext)
    fun playProgram(muNowNext: MuNowNext)
    fun reload()
    fun onCleared()
}