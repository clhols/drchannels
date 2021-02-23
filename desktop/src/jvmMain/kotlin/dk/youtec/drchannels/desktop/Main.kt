package dk.youtec.drchannels.desktop

import androidx.compose.desktop.DesktopTheme
import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModelImpl

fun main() {
    val vm = TvChannelsViewModelImpl()
    vm.observeChannels {
        println("Got list: $it")
    }

    Window(
            title = "DR channels",
            size = getPreferredWindowSize(800, 1000),
            //icon = icAppRounded()
    ) {
        MaterialTheme {
            DesktopTheme {
                ChannelsScreen(vm)
            }
        }
    }
}
