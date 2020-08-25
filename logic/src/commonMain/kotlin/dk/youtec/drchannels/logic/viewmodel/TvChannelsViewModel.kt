package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface TvChannelsViewModel {
    val channels: StateFlow<List<MuNowNext>>
    val playback: Flow<VideoItem>
    val error: Flow<ChannelsError>

    fun playTvChannel(muNowNext: MuNowNext)
    fun playProgram(muNowNext: MuNowNext)
    fun onCleared()

    var <T> StateFlow<T>.state
        get() = value
        set(value: T) {
            if (this is MutableStateFlow<T>) {
                this.value = value
            } else {
                throw IllegalStateException("Not an instance of MutableStateFlow")
            }
        }
}