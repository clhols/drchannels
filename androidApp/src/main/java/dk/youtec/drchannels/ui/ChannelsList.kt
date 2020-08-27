package dk.youtec.drchannels.ui

import android.content.Context
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import dev.chrisbanes.accompanist.coil.CoilImage
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.Flow

@Preview
@Composable
fun ChannelsList(
        context: Context,
        channels: Flow<List<MuNowNext>>,
        onClick: (MuNowNext) -> Unit
) {
    val channelsList by channels.collectAsState(initial = emptyList())

    LazyColumnFor(
            items = channelsList,
            modifier = Modifier.padding(top = 25.dp)
    ) { channel ->
        Card(shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
                        then Modifier.padding(4.dp)
                        then Modifier.clickable(onClick = { onClick(channel) })
        ) {
            ListItem(text = {
                Text(
                        text = channel.now!!.title,
                        style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 25.sp,
                                fontWeight = FontWeight.Bold, color = Color.Black
                        )
                )
            }, secondaryText = {
                Text(
                        text = channel.now!!.description,
                        style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 15.sp,
                                fontWeight = FontWeight.Light, color = Color.DarkGray
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                )
            }, icon = {
                CoilImage(
                        request = ImageRequest.Builder(context)
                                .data(channel.now!!.programCard)
                                .transformations(RoundedCornersTransformation(40f))
                                .build(),
                        modifier = Modifier.preferredWidth(120.dp)
                                + Modifier.preferredHeight(80.dp)
                )
            })
        }
    }
}