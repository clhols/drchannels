package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel

@Composable
fun ChannelsScreen(
        navController: NavController,
        tvChannelsViewModel: AndroidTvChannelsViewModel
) {
    val channelsList by tvChannelsViewModel.channels.collectAsState(initial = emptyList())
    if (channelsList.isNotEmpty()) {
        ChannelsList(
                navController,
                channelsList,
                tvChannelsViewModel::playTvChannel
        )
    } else {
        Loader()
    }
}