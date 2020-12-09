package dk.youtec.drchannels.ui

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import dev.chrisbanes.accompanist.coil.CoilImage
import androidx.compose.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.insets.AmbientWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues
import dk.youtec.drapi.MuScheduleBroadcast
import kotlinx.datetime.*

@Composable
fun ProgramsList(
        programsList: List<MuScheduleBroadcast>,
        playProgram: (MuScheduleBroadcast) -> Unit
) {
    LazyColumnFor(
            items = programsList,
            contentPadding = AmbientWindowInsets.current.systemBars.toPaddingValues()
    ) { program ->
        val timeZone = TimeZone.currentSystemDefault()
        val nowLocalDateTime = Clock.System.todayAt(timeZone)
        val startInstant = Instant.fromEpochMilliseconds(program.startTime)
        val endInstant = Instant.fromEpochMilliseconds(program.endTime)
        val startLocalDateTime = startInstant.toLocalDateTime(timeZone)
        val endLocalDateTime = endInstant.toLocalDateTime(timeZone)

        val time = if (startLocalDateTime.dayOfMonth == nowLocalDateTime.dayOfMonth) {
            "${getTime(startLocalDateTime)} ‣ ${getTime(endLocalDateTime)}"
        } else {
            "${startLocalDateTime.dayOfMonth}/${startLocalDateTime.monthNumber} ⁃ ${getTime(startLocalDateTime)} ‣ ${getTime(endLocalDateTime)}"
        }

        ProgramCard(
                ProgramCardData(
                        program.title+program.startTime,
                        program.title,
                        program.description,
                        time,
                        program.programCard.primaryImageUri
                ),
                onClick = { id ->
                    programsList.firstOrNull { it.title+it.startTime == id }?.run {
                        playProgram(this)
                    }
                }
        )
    }
}

fun getTime(dateTime: LocalDateTime): String {
    val hour = dateTime.hour
    val minute = if (dateTime.minute < 10) {
        "0${dateTime.minute}"
    } else {
        dateTime.minute
    }
    return "$hour:$minute"
}

data class ProgramCardData(
        val id: String,
        val title: String,
        val description: String,
        val time: String,
        val imageUrl: String
)

@Composable
private fun ProgramCard(
        program: ProgramCardData,
        onClick: (String) -> Unit
) {
    val context: Context = AmbientContext.current

    Card(
            Modifier.fillMaxWidth()
                    .padding(4.dp)
                    .clickable(onClick = { onClick(program.id) }),
            shape = RoundedCornerShape(4.dp),
    ) {
        Column(Modifier.padding(12.dp)) {
            Row {
                CoilImage(
                        request = ImageRequest.Builder(context)
                                .data(program.imageUrl)
                                .transformations(RoundedCornersTransformation(
                                        topLeft = 40f,
                                        bottomRight = 40f
                                ))
                                .build(),
                        modifier = Modifier
                                .preferredWidth(120.dp)
                                .preferredHeight(80.dp)
                )
                Column {
                    Text(
                            text = program.title,
                            modifier = Modifier.padding(start = 16.dp),
                            style = TextStyle(
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 22.sp,
                            )
                    )
                    Text(
                            text = program.time,
                            modifier = Modifier.padding(start = 16.dp),
                            style = TextStyle(
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18.sp,
                            )
                    )
                }
            }
            if (program.description.isNotBlank()) {
                Text(
                        text = program.description,
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

@Preview
@Composable
private fun PreviewChannelCard() {
    ProgramCard(
            program = ProgramCardData(
                    "id",
                    "Some program title",
                    "Some not too long description",
                    "12:00 ‣ 13:00",
                    "https://asset.dr.dk/ImageScaler/?file=/mu-online/api/1.4/asset/5f394ae171401441844c2e2c%2525253Fraw=True&w=940&h=529&scaleAfter=crop&quality=75"
            ),
            onClick = {}
    )
}