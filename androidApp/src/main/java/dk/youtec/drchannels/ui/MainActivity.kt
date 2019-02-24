package dk.youtec.drchannels.ui

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dk.youtec.appupdater.updateApp
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.adapter.ChannelsAdapter
import dk.youtec.drchannels.util.isTv
import dk.youtec.drchannels.viewmodel.ChannelsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.coroutines.*
import org.jetbrains.anko.toast
import kotlin.coroutines.CoroutineContext

open class MainActivity : AppCompatActivity(), ChannelsAdapter.OnChannelClickListener, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var viewModel: ChannelsViewModel

    companion object {
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        toolbar.title = ""
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        swipeRefresh.setOnRefreshListener {
            viewModel.channels.subscribe()
        }

        viewModel = ViewModelProviders.of(this)
                .get(ChannelsViewModel::class.java)

        progressBar.isVisible = true

        viewModel.channels.observe(
                this,
                Observer<List<MuNowNext>> { channels ->
                    isEmptyState = channels.isNullOrEmpty()
                    handleChannelsChanged(channels)
                    progressBar.isVisible = false
                    swipeRefresh.isRefreshing = false
                })

        viewModel.playbackUri.observe(this,
                Observer { uri ->
                    startActivity(Intent(this, PlayerActivity::class.java).apply {
                        action = PlayerActivity.ACTION_VIEW
                        putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                        data = uri.toUri()
                    })
                })

        viewModel.error.observe(this,
                Observer {
                    toast(it)
                })

        if (!isTv()) {
            updateApp(this@MainActivity,
                    BuildConfig.VERSION_CODE,
                    "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                    "https://www.dropbox.com/s/tw9gpldrwicd3kj/drchannels.apk?dl=1",
                    "https://www.dropbox.com/s/8miqyro43qn71k0/drchannels.log?dl=1")
        }
    }

    /**
     * Called when a change has been observed on channels in ChannelsViewModel
     */
    private fun handleChannelsChanged(channels: List<MuNowNext>) {
        if (!isFinishing) {
            if (recyclerView.adapter != null) {
                (recyclerView.adapter as ChannelsAdapter?)?.submitList(channels)
            } else {
                recyclerView.adapter = ChannelsAdapter(this).apply {
                    submitList(channels)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        job.cancel()
    }

    private var isEmptyState: Boolean = false
        set(value) {
            emptyState.isVisible = value
            recyclerView.isVisible = !value
            field = value
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return BuildConfig.DEBUG && isTv()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_update) {
            if (isTv()) {
                updateApp(this@MainActivity,
                        BuildConfig.VERSION_CODE,
                        "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                        "https://www.dropbox.com/s/xs9qr72cgyh31r8/drchannels-tv-debug.apk?dl=1",
                        "https://www.dropbox.com/s/8miqyro43qn71k0/drchannels.log?dl=1")
            }
        }

        return true
    }

    override fun playChannel(muNowNext: MuNowNext) = viewModel.playChannel(muNowNext)

    override fun playProgram(muNowNext: MuNowNext) = viewModel.playProgram(muNowNext)

    override fun showChannel(context: Context, channel: MuNowNext) {
        val intent = Intent(context, ProgramsActivity::class.java).apply {
            putExtra(ProgramsActivity.CHANNEL_NAME, channel.ChannelSlug.toUpperCase())
            putExtra(ProgramsActivity.CHANNEL_ID, channel.ChannelSlug)
        }

        context.startActivity(intent, ActivityOptions.makeCustomAnimation(context,
                R.anim.slide_in_left, R.anim.slide_out_left).toBundle())
    }
}
