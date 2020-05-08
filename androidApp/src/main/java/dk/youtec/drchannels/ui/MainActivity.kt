package dk.youtec.drchannels.ui

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.core.net.toUri
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
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
import dk.youtec.drapi.MuScheduleBroadcast
import androidx.ui.livedata.observeAsState
import androidx.ui.foundation.*
import androidx.ui.graphics.ImageAsset
import androidx.ui.layout.*
import androidx.ui.material.ripple.ripple
import androidx.ui.tooling.preview.Preview
import dk.youtec.drchannels.logic.viewmodel.ChannelsError
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.toast
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tvChannelsViewModel: AndroidTvChannelsViewModel by viewModel()

        lifecycleScope.launch {
            tvChannelsViewModel.playback.collect { videoItem ->
                Log.d(TAG, "Playback video item")
                startActivity(Intent(this@MainActivity, PlayerActivity::class.java).apply {
                    action = PlayerActivity.ACTION_VIEW
                    putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                    putExtra(PlayerActivity.TITLE_EXTRA, videoItem.title)
                    putExtra(PlayerActivity.IMAGE_EXTRA, videoItem.imageUrl)
                    data = videoItem.videoUrl.toUri()
                })
            }
        }

        lifecycleScope.launch {
            tvChannelsViewModel.error.collect { error ->
                when(error) {
                    is ChannelsError.NoStream -> toast("No stream")
                    is ChannelsError.LoadingChannelsFailed -> toast("Unable to load channels")
                    is ChannelsError.LoadingChannelFailed -> toast(error.message ?: "Unknown error")
                }
            }
        }

        setContent {
            MaterialTheme {
                ChannelsList(tvChannelsViewModel)
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}

@Preview
@Composable
fun ChannelsList(
        viewModel: AndroidTvChannelsViewModel
) {
    val channelsList by viewModel.channels.asLiveData().observeAsState(initial = emptyList())

    AdapterList<MuNowNext>(
            data = channelsList,
            modifier = Modifier.padding(top = 25.dp)
    ) { channel ->
        Card(shape = RoundedCornerShape(4.dp),
                color = Color.White,
                modifier = Modifier.fillMaxWidth() + Modifier.padding(4.dp)
        ) {
            Clickable(
                    onClick = { viewModel.playTvChannel(channel) },
                    modifier = Modifier.ripple(bounded = true)
            ) {
                ListItem(text = {
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
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                    )
                })
            }
        }
    }
}

@Composable
fun NetworkImageComponentCoil(url: String,
                              modifier: Modifier = Modifier.fillMaxWidth() +
                                      Modifier.preferredHeightIn(maxHeight = 200.dp)) {
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
        Box(modifier = modifier,
                gravity = ContentGravity.Center
        ) {
            Image(asset = theImage)
        }
    } else if (theDrawable != null) {
        Canvas(modifier = modifier) {
            theDrawable.draw(this.nativeCanvas)
        }
    }
}