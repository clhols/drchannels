package dk.youtec.drchannels.logic.viewmodel

import dk.youtec.drapi.MuNowNext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface TvChannelsViewModel {
    val channels: StateFlow<List<MuNowNext>>
    val playback: SharedFlow<VideoItem>
    val error: SharedFlow<ChannelsError>

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

    suspend fun <T> SharedFlow<T>.emit(value: T) {
        if (this is MutableSharedFlow<T>) {
            this.emit(value)
        } else {
            throw IllegalStateException("Not an instance of MutableSharedFlow")
        }
    }
}