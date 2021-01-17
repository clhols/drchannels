package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dk.youtec.drchannels.logic.viewmodel.ProgramsViewModel
import dk.youtec.drchannels.logic.viewmodel.TvChannelsViewModel

lateinit var navController: NavHostController

@Composable
fun AppNavigation(
        tvChannelsViewModel: TvChannelsViewModel,
        programsViewModel: ProgramsViewModel,
) {
    navController = rememberNavController()

    NavHost(navController, startDestination = "channels") {
        composable("channels") {
            ChannelsScreen(navController, tvChannelsViewModel)
        }
        composable("programs/{channelId}") { backStackEntry ->
            programsViewModel.loadPrograms(backStackEntry.arguments?.getString("channelId")!!)
            ProgramsScreen(programsViewModel)
        }
    }
}