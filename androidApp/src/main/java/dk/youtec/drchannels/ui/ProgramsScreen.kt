package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import dk.youtec.drchannels.logic.viewmodel.AndroidProgramsViewModel

@Composable
fun ProgramsScreen(
        channelId: String,
        programsViewModel: AndroidProgramsViewModel
) {
    programsViewModel.loadPrograms(channelId)

    ProgramsList(
            programsViewModel.programs,
            programsViewModel::playProgram
    )
}