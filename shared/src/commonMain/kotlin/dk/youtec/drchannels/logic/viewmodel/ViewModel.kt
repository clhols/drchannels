package dk.youtec.drchannels.logic.viewmodel

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface ViewModel {
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