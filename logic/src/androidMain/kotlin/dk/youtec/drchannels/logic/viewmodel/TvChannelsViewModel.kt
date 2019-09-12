package dk.youtec.drchannels.logic.viewmodel

import androidx.lifecycle.ViewModel

@Suppress("unused")
class AndroidTvChannelsViewModel : ViewModel(), TvChannelsViewModel by TvChannelsViewModelImpl()