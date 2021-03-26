package dk.youtec.drchannels.desktop

import androidx.compose.desktop.DesktopTheme
import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.vectorXmlResource
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModelImpl
import dk.youtec.drchannels.logic.viewmodel.VideoItem
import dk.youtec.drchannels.ui.Channel
import dk.youtec.drchannels.ui.ChannelsScreen
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

fun main() {
    val vm = TvChannelsViewModelImpl()
    vm.observeChannels {
        println("Got list: $it")
    }
    GlobalScope.launch {
        vm.playback.collect {
            println("Playback of: $it")
        }
    }
    val channels = vm.channels.map { channels ->
        channels.map { it.toChannel() }
    }

    Window(
        title = "DR channels",
        size = getPreferredWindowSize(800, 1000),
        //icon = icAppRounded()
    ) {
        MaterialTheme {
            DesktopTheme {
                val state = channels.collectAsState(initial = emptyList())
                ChannelsScreen(state, { channel ->
                    vm.playTvChannel(
                        VideoItem(
                            channel.videoItem.title,
                            channel.videoItem.videoUrl,
                            channel.videoItem.imageUrl
                        )
                    )
                }, {}, {
                    Image(
                        imageVector = vectorXmlResource("images/logo.xml"),
                        "Channel logo"
                    )
                })
            }
        }
    }
}

private fun dk.youtec.drapi.Channel.toChannel(): Channel {
    return Channel(
        slug,
        title,
        subtitle,
        primaryImageUri,
        dk.youtec.drchannels.ui.VideoItem(
            title,
            "${server()?.server}/${
                server()
                    ?.qualities?.maxByOrNull { it.kbps }
                    ?.streams?.first()?.stream ?: ""
            }",
            primaryImageUri
        )
    )
}
