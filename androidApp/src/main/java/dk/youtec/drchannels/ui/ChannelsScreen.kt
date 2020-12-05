package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel

@Composable
fun ChannelsScreen(
        navController: NavController,
        tvChannelsViewModel: AndroidTvChannelsViewModel
) {
        ChannelsList(
                navController,
                tvChannelsViewModel.channels,
                tvChannelsViewModel::playTvChannel
        )
}