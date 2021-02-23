package dk.youtec.drchannels.desktop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChannelCard(
        channel: ChannelCardData,
        percentage: Float,
        onChannelClick: (String) -> Unit,
        onProgramsClick: (String) -> Unit,
) {

    Card(
            Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clickable(onClick = { onChannelClick(channel.id) }),
            shape = RoundedCornerShape(4.dp),
    ) {
        Column(Modifier.padding(12.dp)) {
            Row {
                Column {
                    Row {
                        Text(
                                text = channel.title,
                                modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .padding(start = 12.dp, end = 4.dp)
                                        .weight(1f),
                                style = TextStyle(
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 22.sp,
                                )
                        )
                        IconButton(
                                onClick = { onProgramsClick(channel.id) },
                                modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .padding(start = 4.dp)
                                        .width(40.dp),
                                content = { Icon(Icons.Default.Menu, "Menu") }
                        )
                    }
                    if (percentage <= 1.0f) {
                        LinearProgressIndicator(
                                modifier = Modifier
                                        .height(4.dp)
                                        .padding(8.dp)
                                        .fillMaxWidth(),
                                progress = percentage
                        )
                    }
                }
            }
            if (channel.description.isNotBlank()) {
                Text(
                        text = channel.description,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                        style = TextStyle(
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Light,
                                fontSize = 16.sp,
                        )
                )
            }
        }
    }
}

//@Preview
@Composable
private fun PreviewChannelCard() {
    ChannelCard(
            channel = ChannelCardData(
                    "id",
                    "Some program title (1:4): Episode 10",
                    "Some not too long description",
                    "https://asset.dr.dk/ImageScaler/?file=/mu-online/api/1.4/asset/5f394ae171401441844c2e2c%2525253Fraw=True&w=940&h=529&scaleAfter=crop&quality=75"
            ),
            percentage = 0.42f,
            onChannelClick = {},
            onProgramsClick = {}
    )
}

data class ChannelCardData(
        val id: String,
        val title: String,
        val description: String,
        val imageUrl: String
)