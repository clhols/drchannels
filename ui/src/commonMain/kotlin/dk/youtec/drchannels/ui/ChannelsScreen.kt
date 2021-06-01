package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun ChannelsScreen(
    modifier: Modifier = Modifier,
    state: State<List<Channel>>,
    playTvChannel: (channel: Channel) -> Unit,
    onProgramsClick: (String) -> Unit,
    image: @Composable (String) -> Unit
) {
    val channelsList by state
    if (channelsList.isNotEmpty()) {
        ChannelsList(
            modifier,
            channelsList,
            playTvChannel,
            onProgramsClick,
            image
        )
    } else {
        Loader()
    }
}