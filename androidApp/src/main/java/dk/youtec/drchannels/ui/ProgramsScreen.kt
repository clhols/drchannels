package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.viewModel
import dk.youtec.drchannels.logic.viewmodel.AndroidProgramsViewModel

@Composable
fun ProgramsScreen(channelId: String) {
    val programsViewModel: AndroidProgramsViewModel = viewModel()
    programsViewModel.loadPrograms(channelId)

    ProgramsList(programsViewModel.programs)
}