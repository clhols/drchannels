package dk.youtec.drchannels.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import dev.chrisbanes.accompanist.insets.AmbientWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues
import dk.youtec.drapi.MuScheduleBroadcast
import kotlinx.datetime.*
import java.time.Instant.now

@Composable
fun ProgramsList(
        programsList: List<MuScheduleBroadcast>,
        playProgram: (MuScheduleBroadcast) -> Unit
) {
    val nowIndex = programsList.indexOfFirst {
        it.endTime >= now().toEpochMilli()
    }.coerceAtLeast(0)
    val programsListState = rememberLazyListState(nowIndex)

    LazyColumn(
            contentPadding = AmbientWindowInsets.current.systemBars.toPaddingValues(),
            state = programsListState
    ) {
        items(programsList.size) { index ->
            val program = programsList[index]
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
                            program.title + program.startTime,
                            program.title,
                            program.description,
                            time,
                            program.programCard.primaryImageUri
                    ),
                    onClick = { id ->
                        programsList.firstOrNull { it.title + it.startTime == id }?.run {
                            playProgram(this)
                        }
                    }
            )
        }
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