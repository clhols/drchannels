package dk.youtec.drchannels.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
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
import com.google.android.exoplayer2.util.Util
import dk.youtec.appupdater.updateApp
import dk.youtec.drchannels.BuildConfig

open class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            if (!Util.isTv(this) && !BuildConfig.DEBUG) {
                updateApp(this,
                        BuildConfig.VERSION_CODE,
                        "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                        "https://www.dropbox.com/s/tw9gpldrwicd3kj/drchannels.apk?dl=1",
                        "https://www.dropbox.com/s/6prmp1cnnsrhr4y/drchannels.log?dl=1")
            }
        }

        val tvChannelsViewModel: AndroidTvChannelsViewModel by viewModel()
        //val programsViewModel: AndroidProgramsViewModel by viewModel()

        lifecycleScope.launch {
            tvChannelsViewModel.playback.collect { videoItem ->
                Log.d(TAG, "Playback video item")
                startActivity(Intent(this@MainActivity, PlayerActivity::class.java).apply {
                    action = PlayerActivity.ACTION_VIEW
                    putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                    putExtra(PlayerActivity.TITLE_EXTRA, videoItem.title)
                    putExtra(PlayerActivity.IMAGE_EXTRA, videoItem.imageUrl)
                    data = Uri.parse(videoItem.videoUrl)
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
                ChannelsScreen()
                //ProgramsScreen("dr1")
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}