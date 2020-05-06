package dk.youtec.drchannels.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.LiveData
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.material.MaterialTheme
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.asLiveData
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Card
import androidx.ui.material.ListItem
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import dk.youtec.drapi.MuNowNext
import androidx.ui.livedata.observeAsState

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tvChannelsViewModel: AndroidTvChannelsViewModel by viewModel()

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setContent {
            MaterialTheme {
                ChannelsList(tvChannelsViewModel.channels.asLiveData())
            }
        }
    }
}

@Composable
fun ChannelsList(channels: LiveData<List<MuNowNext>>) {
    val channelsList by channels.observeAsState(initial = emptyList())

    // AdapterList is a vertically scrolling list that only composes and lays out the currently
    // visible items. This is very similar to what RecylerView tries to do as it's more optimized
    // than the VerticalScroller.
    AdapterList<List<MuNowNext>>(data = channelsList) { channel ->
        // Card composable is a predefined composable that is meant to represent the
        // card surface as specified by the Material Design specification. We also
        // configure it to have rounded corners and apply a modifier.

        // You can think of Modifiers as implementations of the decorators pattern that are used to
        // modify the composable that its applied to. In this example, we assign a padding of
        // 16dp to the Card along with specifying it to occupy the entire available width.
        Card(shape = RoundedCornerShape(4.dp), color = Color.White,
                modifier = Modifier.fillMaxWidth() + Modifier.padding(8.dp)) {
            // ListItem is a predefined composable that is a Material Design implementation of [list
            // items](https://material.io/components/lists). This component can be used to achieve the
            // list item templates existing in the spec
            ListItem(text = {
                // The Text composable is pre-defined by the Compose UI library; you can use this
                // composable to render text on the screen
                Text(
                        text = channel.toString(),
                        style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                        )
                )
            }, secondaryText = {
                Text(
                        text = "Channel: ${channel.toString()}",
                        style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 15.sp,
                                fontWeight = FontWeight.Light, color = Color.DarkGray
                        )
                )
            })
        }
    }
}