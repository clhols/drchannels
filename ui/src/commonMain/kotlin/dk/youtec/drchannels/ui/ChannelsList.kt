package dk.youtec.drchannels.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import dk.youtec.drapi.Channel

@Composable
fun ChannelsList(
        channelsList: List<Channel>,
        onChannelClick: (Channel) -> Unit,
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
                            channel.primaryImageUri
                    ),
                    percentage = 2f,
                    onChannelClick = { id ->
                        channelsList.firstOrNull { it.slug == id }?.run {
                            onChannelClick(this)
                        }
                    },
                    onProgramsClick = { id ->
                        //navController.navigate("programs/$id")
                    }
            )
        }
    }
}
