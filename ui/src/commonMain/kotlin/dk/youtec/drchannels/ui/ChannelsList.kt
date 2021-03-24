package dk.youtec.drchannels.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun ChannelsList(
    channelsList: List<Channel>,
    onChannelClick: (Channel) -> Unit,
    onProgramsClick: (String) -> Unit,
    image: @Composable (String) -> Unit
) {
    LazyColumn {
        items(channelsList.size) { index ->
            val channel = channelsList[index]
            //val programDuration = now.endTime - now.startTime
            //val programTime = System.currentTimeMillis() - now.startTime
            //val percentage = programTime.toFloat() / programDuration

            ChannelCard(
                channel = ChannelCardData(
                    channel.slug,
                    channel.title,
                    channel.subtitle,
                ),
                percentage = 2f,
                onChannelClick = { id ->
                    channelsList.firstOrNull { it.slug == id }?.run {
                        onChannelClick(this)
                    }
                },
                onProgramsClick = onProgramsClick,
                image = { image(channel.primaryImageUri) },
            )
        }
    }
}
