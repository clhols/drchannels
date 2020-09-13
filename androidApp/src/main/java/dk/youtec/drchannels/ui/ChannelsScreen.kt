package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.viewModel
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel

@Composable
fun ChannelsScreen() {
    val tvChannelsViewModel: AndroidTvChannelsViewModel = viewModel()

    ChannelsList(
            tvChannelsViewModel.channels,
            tvChannelsViewModel::playTvChannel
    )
}