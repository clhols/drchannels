package dk.youtec.drchannels.ui

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.core.graphics.drawable.toBitmap
import androidx.core.net.toUri
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.ImageAsset
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
import androidx.ui.livedata.observeAsState
import androidx.ui.material.Card
import androidx.ui.material.ListItem
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.ripple
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import coil.ImageLoader
import coil.request.LoadRequest
import dk.youtec.drapi.MuNowNext
import dk.youtec.drapi.ProgramCard
import dk.youtec.drchannels.R
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import dk.youtec.drchannels.logic.viewmodel.ChannelsError
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.toast
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent.inject

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
                when (error) {
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
        Card(shape = RoundedCornerShape(8.dp),
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
                }, icon = {
                    NetworkImageComponentCoil(
                            programCard = channel.now!!.programCard,
                            modifier = Modifier.preferredWidth(120.dp)
                                    + Modifier.wrapContentHeight(Alignment.Top)
                    )
                })
            }
        }
    }
}

@Composable
fun NetworkImageComponentCoil(programCard: ProgramCard,
                              modifier: Modifier = Modifier) {
    var image by state<ImageAsset?> { null }
    var drawable by state<Drawable?> { null }
    onCommit(programCard) {
        val context: Context by inject(Context::class.java)
        val imageLoader: ImageLoader by inject(ImageLoader::class.java)
        val request: LoadRequest = LoadRequest.Builder(context)
                .data(programCard)
                .crossfade(true)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_placeholder)
                //.transformations(RoundedCornersTransformation(40f))
                .target(
                        onStart = { placeholder ->
                            drawable = placeholder
                        },
                        onSuccess = { result ->
                            image = result.toBitmap().asImageAsset()
                        },
                        onError = { error ->
                            drawable = error
                        }
                )
                .build()
        imageLoader.execute(request)

        onDispose {
            image = null
            drawable = null
        }
    }

    val theImage = image
    val theDrawable = drawable
    if (theImage != null) {
        Box(modifier = modifier) {
            Image(asset = theImage)
        }
    } else if (theDrawable != null) {
        Canvas(modifier = modifier) {
            theDrawable.draw(this.nativeCanvas)
        }
    }
}