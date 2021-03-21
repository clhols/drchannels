package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dk.youtec.drchannels.logic.viewmodel.ProgramsViewModel
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModel
import dk.youtec.drchannels.logic.viewmodel.VideoItem
import kotlinx.coroutines.flow.map

lateinit var navController: NavHostController

@Composable
fun AppNavigation(
    tvChannelsViewModel: TvChannelsViewModel,
    programsViewModel: ProgramsViewModel,
) {
    navController = rememberNavController()

    val channels = tvChannelsViewModel.channels.map { channels ->
        channels.map { it.toChannel() }
    }
    val state = channels.collectAsState(initial = emptyList())

    NavHost(navController, startDestination = "channels") {
        composable("channels") {
            ChannelsScreen(state, {
                tvChannelsViewModel.playTvChannel(
                    VideoItem(
                        it.videoItem.title,
                        it.videoItem.videoUrl,
                        it.videoItem.imageUrl
                    )
                )
            }) {
                navController.navigate("programs/$it")
            }
        }
        composable("programs/{channelId}") { backStackEntry ->
            programsViewModel.loadPrograms(backStackEntry.arguments?.getString("channelId")!!)
            ProgramsScreen(programsViewModel)
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