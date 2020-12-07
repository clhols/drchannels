package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dk.youtec.drchannels.logic.viewmodel.AndroidProgramsViewModel

@Composable
fun ProgramsScreen(programsViewModel: AndroidProgramsViewModel) {
    val programsList by programsViewModel.programs.collectAsState(initial = emptyList())
    if (programsList.isNotEmpty()) {
        ProgramsList(
                programsList,
                programsViewModel::playProgram
        )
    } else {
        Loader()
    }
}