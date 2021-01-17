package dk.youtec.drchannels.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import dk.youtec.drapi.MuNowNext
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.insets.AmbientWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues

@Composable
fun ChannelsList(
        navController: NavController,
        channelsList: List<MuNowNext>,
        onChannelClick: (MuNowNext) -> Unit,
) {
    LazyColumn(contentPadding = AmbientWindowInsets.current.systemBars.toPaddingValues()) {
        items(items = channelsList,
                itemContent = { channel ->
                    val now = channel.now!!
                    val programDuration = now.endTime - now.startTime
                    val programTime = System.currentTimeMillis() - now.startTime
                    val percentage = programTime.toFloat() / programDuration

                    ChannelCard(
                            channel = ChannelCardData(
                                    channel.channelSlug,
                                    now.title,
                                    now.description,
                                    now.programCard.primaryImageUri
                            ),
                            percentage = percentage,
                            onChannelClick = { id ->
                                channelsList.firstOrNull { it.channelSlug == id }?.run {
                                    onChannelClick(this)
                                }
                            },
                            onProgramsClick = { id ->
                                navController.navigate("programs/$id")
                            }
                    )
                })
    }
}
