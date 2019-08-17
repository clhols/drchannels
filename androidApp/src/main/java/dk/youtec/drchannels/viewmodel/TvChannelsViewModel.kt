package dk.youtec.drchannels.viewmodel

import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModel
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModelImpl

@Keep
class TvChannelsViewModel : ViewModel(), TvChannelsViewModel by TvChannelsViewModelImpl()