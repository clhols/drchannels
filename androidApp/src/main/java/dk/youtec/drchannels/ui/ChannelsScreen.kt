package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModel

@Composable
fun ChannelsScreen(
        navController: NavController,
        tvChannelsViewModel: TvChannelsViewModel
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