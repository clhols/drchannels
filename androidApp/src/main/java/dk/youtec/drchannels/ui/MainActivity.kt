package dk.youtec.drchannels.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.lifecycleScope
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import dk.youtec.drchannels.logic.viewmodel.ChannelsError
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.toast
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.core.net.toUri

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
            val colorPalette = if (isSystemInDarkTheme()) {
                darkThemeColors
            } else {
                lightThemeColors
            }
            MaterialTheme(colors = colorPalette) {
                ChannelsList(this, tvChannelsViewModel.channels) {
                    tvChannelsViewModel.playTvChannel(it)
                }
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}