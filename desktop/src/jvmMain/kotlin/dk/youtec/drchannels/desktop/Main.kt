package dk.youtec.drchannels.desktop

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.vectorXmlResource
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModelImpl
import dk.youtec.drchannels.logic.viewmodel.VideoItem
import dk.youtec.drchannels.ui.Channel
import dk.youtec.drchannels.ui.ChannelsScreen
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.io.File

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val vm = TvChannelsViewModelImpl()
    vm.observeChannels {
        println("Got list: $it")
    }
    GlobalScope.launch {
        vm.playback.collect {
            println("Playback of: $it")
            withContext(Dispatchers.IO) {
                if (File("/Applications/VLC.app/Contents/MacOS/VLC").exists()) {
                    Runtime.getRuntime()
                        .exec("/Applications/VLC.app/Contents/MacOS/VLC ${it.videoUrl}")
                } else if (File("/usr/bin/vlc").exists()) {
                    Runtime.getRuntime()
                        .exec("/usr/bin/vlc ${it.videoUrl}")
                } else {
                    Runtime.getRuntime()
                        .exec("open ${it.videoUrl}")
                }
            }
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
        DesktopMaterialTheme {
            val state = channels.collectAsState(initial = emptyList())
            ChannelsScreen(state = state,
                playTvChannel = { channel ->
                    vm.playTvChannel(
                        VideoItem(
                            channel.videoItem.title,
                            channel.videoItem.videoUrl,
                            channel.videoItem.imageUrl
                        )
                    )
                },
                onProgramsClick = {},
                image = {
                    Image(
                        imageVector = vectorXmlResource("images/logo.xml"),
                        "Channel logo"
                    )
                }
            )
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
