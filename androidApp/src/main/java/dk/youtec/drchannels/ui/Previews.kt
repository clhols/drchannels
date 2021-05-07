package dk.youtec.drchannels.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PreviewChannelCard() {
    ChannelCard(
        channel = ChannelCardData(
            "id",
            "Some program title (1:4): Episode 10",
            "Some not too long description",
        ),
        percentage = 0.42f,
        onChannelClick = {},
        onProgramsClick = {}
    ) {}
}