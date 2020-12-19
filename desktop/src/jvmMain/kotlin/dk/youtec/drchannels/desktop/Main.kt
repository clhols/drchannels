package dk.youtec.drchannels.desktop

import androidx.compose.desktop.DesktopTheme
import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.remember

fun main() {
    Window(
            title = "DR channels",
            size = getPreferredWindowSize(800, 1000),
            //icon = icAppRounded()
    ) {
        MaterialTheme {
            DesktopTheme {
                Loader()
            }
        }
    }
}
