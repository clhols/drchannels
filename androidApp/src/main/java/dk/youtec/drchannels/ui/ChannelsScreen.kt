package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.NavController
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel

@Composable
fun ChannelsScreen(navController: NavController) {
    val tvChannelsViewModel: AndroidTvChannelsViewModel = viewModel()

    ChannelsList(
            navController,
            tvChannelsViewModel.channels,
            tvChannelsViewModel::playTvChannel
    )
}