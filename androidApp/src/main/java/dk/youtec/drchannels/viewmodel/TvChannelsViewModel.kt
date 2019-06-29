package dk.youtec.drchannels.viewmodel

import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModel
import kotlinx.coroutines.flow.Flow

@Keep
class TvChannelsViewModel : ViewModel(), TvChannelsViewModel {
    private val viewModel = dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModelImpl(viewModelScope)

    override val channels: Flow<List<MuNowNext>> = viewModel.channels
    override val playbackUri: Flow<String> = viewModel.playbackUri
    override val error: Flow<String> = viewModel.error

    override fun playTvChannel(muNowNext: MuNowNext) = viewModel.playTvChannel(muNowNext)
    override fun playProgram(muNowNext: MuNowNext) = viewModel.playProgram(muNowNext)
    override fun reload() = viewModel.reload()
    override fun onCleared() = viewModel.onCleared()
}