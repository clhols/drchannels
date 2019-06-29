package dk.youtec.drchannels.viewmodel

import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModel

@Keep
class TvChannelsViewModel(
        private val viewModel: dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModelImpl
) : ViewModel(), TvChannelsViewModel by viewModel {
    override fun onCleared() {
        viewModel.onCleared()
    }
}

class TvChannelsViewModelFactory(
        private val viewModel: dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModelImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvChannelsViewModel(viewModel) as T
    }

}
