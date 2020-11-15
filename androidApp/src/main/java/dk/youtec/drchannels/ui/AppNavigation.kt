package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

lateinit var navController: NavHostController

@Composable
fun AppNavigation() {
    navController = rememberNavController()

    NavHost(navController, startDestination = "channels") {
        composable("channels") {
            ChannelsScreen(navController)
        }
        composable("programs/{channelId}") { backStackEntry ->
            ProgramsScreen(backStackEntry.arguments?.getString("channelId")!!)
        }
    }
}