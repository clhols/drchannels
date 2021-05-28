package dk.youtec.drchannels.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import dk.youtec.drchannels.logic.viewmodel.ChannelsError
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.google.android.exoplayer2.util.Util
import dk.youtec.appupdater.updateApp
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.logic.viewmodel.AndroidProgramsViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            if (!Util.isTv(this) && !BuildConfig.DEBUG) {
                updateApp(
                    this,
                    BuildConfig.VERSION_CODE,
                    "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                    "https://www.dropbox.com/s/tw9gpldrwicd3kj/drchannels.apk?dl=1",
                    "https://www.dropbox.com/s/6prmp1cnnsrhr4y/drchannels.log?dl=1"
                )
            }
        }

        val tvChannelsViewModel: AndroidTvChannelsViewModel by viewModel()
        val programsViewModel: AndroidProgramsViewModel by viewModel()

        tvChannelsViewModel.playback
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { videoItem ->
                Log.d(TAG, "Playback video item: $videoItem")
                startActivity(Intent(this@MainActivity, PlayerActivity::class.java).apply {
                    action = PlayerActivity.ACTION_VIEW
                    putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                    putExtra(PlayerActivity.TITLE_EXTRA, videoItem.title)
                    putExtra(PlayerActivity.IMAGE_EXTRA, videoItem.imageUrl)
                    data = Uri.parse(videoItem.videoUrl)
                })
            }.launchIn(lifecycleScope)

        tvChannelsViewModel.error
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { error ->
                when (error) {
                    is ChannelsError.NoStream -> toast("No stream")
                    is ChannelsError.LoadingChannelsFailed -> toast("Unable to load channels")
                    is ChannelsError.LoadingChannelFailed -> toast(error.message ?: "Unknown error")
                }
            }.launchIn(lifecycleScope)

        programsViewModel.playback
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { videoItem ->
                Log.d(TAG, "Playback video item")
                startActivity(Intent(this@MainActivity, PlayerActivity::class.java).apply {
                    action = PlayerActivity.ACTION_VIEW
                    putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                    //putExtra(PlayerActivity.TITLE_EXTRA, videoItem.title)
                    putExtra(PlayerActivity.IMAGE_EXTRA, videoItem.second)
                    data = Uri.parse(videoItem.first)
                })
            }.launchIn(lifecycleScope)

        programsViewModel.error
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { error ->
                toast(error.message ?: "Unknown error")
            }.launchIn(lifecycleScope)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val colorPalette = if (isSystemInDarkTheme()) {
                darkThemeColors
            } else {
                lightThemeColors
            }
            MaterialTheme(colors = colorPalette) {
                AppNavigation(this, tvChannelsViewModel, programsViewModel)
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}