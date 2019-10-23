package dk.youtec.drchannels.logic.viewmodel

import androidx.lifecycle.ViewModel

@Suppress("unused", "DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
class AndroidTvChannelsViewModel : ViewModel(), TvChannelsViewModel by TvChannelsViewModelImpl()