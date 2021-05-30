package dk.youtec.drchannels.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.coil.rememberCoilPainter
import dk.youtec.drchannels.logic.viewmodel.ProgramsViewModel
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModel
import dk.youtec.drchannels.logic.viewmodel.VideoItem
import kotlinx.coroutines.flow.map

lateinit var navController: NavHostController

@Composable
fun AppNavigation(
    context: Context,
    tvChannelsViewModel: TvChannelsViewModel,
    programsViewModel: ProgramsViewModel,
) {
    navController = rememberNavController()

    val lifecycleOwner = LocalLifecycleOwner.current
    val channels = tvChannelsViewModel.channels
    val channelsFlowLifecycleAware = remember(channels, lifecycleOwner) {
        channels
            .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .map { channels ->
                channels.map { it.toChannel() }
            }
    }

    NavHost(navController, startDestination = "channels") {
        composable("channels") {
            ChannelsScreen(
                channelsFlowLifecycleAware.collectAsState(initial = emptyList()),
                {
                    tvChannelsViewModel.playTvChannel(
                        VideoItem(
                            it.videoItem.title,
                            it.videoItem.videoUrl,
                            it.videoItem.imageUrl
                        )
                    )
                }, {
                    navController.navigate("programs/$it")
                }) { url ->
                Image(
                    painter = rememberCoilPainter(
                        request = ImageRequest.Builder(context)
                            .data(url)
                            .transformations(
                                RoundedCornersTransformation(
                                    topLeft = 40f,
                                    bottomRight = 40f
                                )
                            )
                            .build(),
                        shouldRefetchOnSizeChange = { _, _ -> false },
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .height(80.dp),
                )
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