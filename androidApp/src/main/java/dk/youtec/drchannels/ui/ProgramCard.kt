package dk.youtec.drchannels.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun ProgramCard(
        program: ProgramCardData,
        onClick: (String) -> Unit
) {
    val context: Context = AmbientContext.current

    Card(
            Modifier
                    .fillMaxWidth()
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
                ) { imageLoadState ->
                    when (imageLoadState) {
                        is ImageLoadState.Success -> {
                            MaterialLoadingImage(
                                    result = imageLoadState,
                                    contentDescription = "Logo",
                                    fadeInEnabled = true,
                                    fadeInDurationMs = 2000,
                            )
                        }
                        is ImageLoadState.Error -> {
                            Box(modifier = Modifier.background(Color.LightGray))
                        }
                        else -> Box(modifier = Modifier.background(Color.White))
                    }
                }
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

data class ProgramCardData(
        val id: String,
        val title: String,
        val description: String,
        val time: String,
        val imageUrl: String
)

@Preview
@Composable
private fun PreviewProgramCard() {
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