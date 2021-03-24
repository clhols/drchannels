package dk.youtec.drchannels.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage
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
            }, {
                navController.navigate("programs/$it")
            }) { url ->
                CoilImage(
                    request = ImageRequest.Builder(context)
                        .data(url)
                        .transformations(
                            RoundedCornersTransformation(
                            topLeft = 40f,
                            bottomRight = 40f
                        )
                        )
                        .build(),
                    modifier = Modifier
                        .width(120.dp)
                        .height(80.dp)
                ) { imageLoadState ->
                    when (imageLoadState) {
                        is ImageLoadState.Success -> {
                            MaterialLoadingImage(
                                result = imageLoadState,
                                contentDescription = "Logo",
                                fadeInEnabled = true,
                                fadeInDurationMs = 2000,
                            )
                        }
                        is ImageLoadState.Error -> {
                            Box(modifier = Modifier.background(Color.LightGray))
                        }
                        else -> Box(modifier = Modifier.background(Color.White))
                    }
                }
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