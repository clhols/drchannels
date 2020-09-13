package dk.youtec.drchannels.ui

import android.content.Context
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import dev.chrisbanes.accompanist.coil.CoilImage
import dk.youtec.drapi.MuNowNext
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ContextAmbient
import kotlinx.coroutines.flow.Flow

@Composable
fun ChannelsList(
        channels: Flow<List<MuNowNext>>,
        onClick: (MuNowNext) -> Unit
) {
    val context: Context = ContextAmbient.current
    val channelsList by channels.collectAsState(initial = emptyList())

    LazyColumnFor(
            items = channelsList,
            modifier = Modifier.padding(top = 25.dp)
    ) { channel ->
        val now = channel.now!!
        val programDuration = now.endTime - now.startTime
        val programTime = System.currentTimeMillis() - now.startTime
        val percentage = programTime.toFloat() / programDuration

        Card(
                Modifier.fillMaxWidth()
                        .padding(4.dp)
                        .clickable(onClick = { onClick(channel) }),
                shape = RoundedCornerShape(4.dp),
        ) {
            Column(Modifier.padding(12.dp)) {
                Row {
                    CoilImage(
                            request = ImageRequest.Builder(context)
                                    .data(now.programCard)
                                    .transformations(RoundedCornersTransformation(
                                            topLeft = 40f,
                                            bottomRight = 40f
                                    ))
                                    .build(),
                            modifier = Modifier
                                    .preferredWidth(120.dp)
                                    .preferredHeight(80.dp)
                                    .gravity(Alignment.CenterVertically)
                    )
                    Text(
                            text = now.title,
                            modifier = Modifier.padding(start = 16.dp),
                            style = TextStyle(
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 22.sp,
                            )
                    )
                }
                LinearProgressIndicator(
                        modifier = Modifier.padding(top = 8.dp),
                        progress = percentage
                )
                if (now.description.isNotBlank()) {
                    Text(
                            text = now.description,
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
}