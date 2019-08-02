package dk.youtec.drchannels.ui

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dk.youtec.appupdater.updateApp
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.adapter.TvChannelsAdapter
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.isTv
import dk.youtec.drchannels.util.toast
import dk.youtec.drchannels.viewmodel.TvChannelsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import android.view.View

open class MainActivity : AppCompatActivity(), TvChannelsAdapter.OnChannelClickListener, CoroutineScope by MainScope() {
    private val viewModel: TvChannelsViewModel by viewModels()

    companion object {
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        swipeRefresh.setOnRefreshListener {
            viewModel.reload()
        }

        progressBar.isVisible = true

        with(viewModel) {
            launch {
                channels.collect { channels ->
                    Log.d("MainActivity", "Tv channels " + this@MainActivity)
                    isEmptyState = channels.isNullOrEmpty()
                    handleChannelsChanged(channels)
                    progressBar.isVisible = false
                    swipeRefresh.isRefreshing = false
                }
            }

            launch {
                playbackUri.collect { uri ->
                    Log.d("MainActivity", "Playback uri")
                    startActivity(Intent(this@MainActivity, PlayerActivity::class.java).apply {
                        action = PlayerActivity.ACTION_VIEW
                        putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                        data = uri.toUri()
                    })
                }
            }

            launch {
                error.collect { message ->
                    toast(message)
                }
            }
        }

        if (savedInstanceState == null) {
            viewModel.reload()

            if (!isTv() && !BuildConfig.DEBUG) {
                updateApp(this@MainActivity,
                        BuildConfig.VERSION_CODE,
                        "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                        "https://www.dropbox.com/s/tw9gpldrwicd3kj/drchannels.apk?dl=1",
                        "https://www.dropbox.com/s/8miqyro43qn71k0/drchannels.log?dl=1")
            }
        }
    }

    /**
     * Called when a change has been observed on channels in ChannelsViewModel
     */
    private fun handleChannelsChanged(channels: List<MuNowNext>) {
        if (!isFinishing) {
            getAdapter().submitList(channels)
        }
    }

    private fun getAdapter(): TvChannelsAdapter {
        return (recyclerView.adapter as? TvChannelsAdapter) ?: TvChannelsAdapter(this).also {
            recyclerView.adapter = it
        }
    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }

    private var isEmptyState: Boolean = false
        set(value) {
            emptyState.isVisible = value
            recyclerView.isVisible = !value
            field = value
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return !BuildConfig.DEBUG && isTv()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_update) {
            updateApp(this@MainActivity,
                    BuildConfig.VERSION_CODE,
                    "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                    "https://www.dropbox.com/s/a4oc5xmtl5naea7/drchannels-tv-release.apk?dl=1",
                    "https://www.dropbox.com/s/8miqyro43qn71k0/drchannels.log?dl=1")
        }

        return true
    }

    override fun playTvChannel(muNowNext: MuNowNext) = viewModel.playTvChannel(muNowNext)

    override fun playProgram(muNowNext: MuNowNext) = viewModel.playProgram(muNowNext)

    override fun showTvChannel(context: Context, tvChannel: MuNowNext) {
        val intent = Intent(context, ProgramsActivity::class.java).apply {
            putExtra(ProgramsActivity.CHANNEL_NAME, tvChannel.channelSlug.toUpperCase())
            putExtra(ProgramsActivity.CHANNEL_ID, tvChannel.channelSlug)
        }

        context.startActivity(intent, ActivityOptions.makeCustomAnimation(context,
                R.anim.slide_in_left, R.anim.slide_out_left).toBundle())
    }
}
