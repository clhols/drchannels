package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel

lateinit var navController: NavHostController

@Composable
fun AppNavigation(tvChannelsViewModel: AndroidTvChannelsViewModel) {
    navController = rememberNavController()

    NavHost(navController, startDestination = "channels") {
        composable("channels") {
            ChannelsScreen(navController, tvChannelsViewModel)
        }
        composable("programs/{channelId}") { backStackEntry ->
            ProgramsScreen(backStackEntry.arguments?.getString("channelId")!!)
        }
    }
}