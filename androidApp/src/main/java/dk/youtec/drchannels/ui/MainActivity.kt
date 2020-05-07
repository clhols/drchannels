package dk.youtec.drchannels.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.lifecycle.LiveData
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.asLiveData
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.material.Card
import androidx.ui.material.ListItem
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import dk.youtec.drapi.MuNowNext
import androidx.ui.livedata.observeAsState
import androidx.ui.foundation.*
import androidx.ui.graphics.ImageAsset
import androidx.ui.layout.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tvChannelsViewModel: AndroidTvChannelsViewModel by viewModel()

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
    AdapterList<MuNowNext>(
            data = channelsList,
            modifier = Modifier.padding(top = 25.dp)
    ) { channel ->
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
                        text = channel.now!!.title,
                        style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                        )
                )
            }, secondaryText = {
                Text(
                        text = channel.now!!.description,
                        style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 15.sp,
                                fontWeight = FontWeight.Light, color = Color.DarkGray
                        )
                )
            })
        }
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun NetworkImageComponentCoil(url: String,
                              modifier: Modifier = Modifier.fillMaxWidth() +
                                      Modifier.preferredHeightIn(maxHeight = 200.dp)) {
    // Source code inspired from - https://kotlinlang.slack.com/archives/CJLTWPH7S/p1573002081371500.
    // Made some minor changes to the code Leland posted.
    var image by state<ImageAsset?> { null }
    var drawable by state<Drawable?> { null }
    onCommit(url) {

        onDispose {
            image = null
            drawable = null
        }
    }

    val theImage = image
    val theDrawable = drawable
    if (theImage != null) {
        // Box is a predefined convenience composable that allows you to apply common draw & layout
        // logic. In addition we also pass a few modifiers to it.

        // You can think of Modifiers as implementations of the decorators pattern that are
        // used to modify the composable that its applied to. In this example, we configure the
        // Box composable to have a max height of 200dp and fill out the entire available
        // width.
        Box(modifier = modifier,
                gravity = ContentGravity.Center
        ) {
            // Image is a pre-defined composable that lays out and draws a given [ImageAsset].
            Image(asset = theImage)
        }
    } else if (theDrawable != null) {
        Canvas(modifier = modifier) {
            theDrawable.draw(this.nativeCanvas)
        }
    }
}