package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue

@Composable
fun ChannelsScreen(
    state: State<List<Channel>>,
    playTvChannel: (channel: Channel) -> Unit,
    onProgramsClick: (String) -> Unit,
    image: @Composable (String) -> Unit
) {
    val channelsList by state
    if (channelsList.isNotEmpty()) {
        ChannelsList(
            channelsList,
            playTvChannel,
            onProgramsClick,
            image
        )
    } else {
        Loader()
    }
}