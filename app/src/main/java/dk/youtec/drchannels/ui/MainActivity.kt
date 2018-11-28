package dk.youtec.drchannels.ui

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dk.youtec.appupdater.updateApp
import dk.youtec.drapi.multiplatform.MuNowNext
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.adapter.ChannelsAdapter
import dk.youtec.drchannels.util.isTv
import dk.youtec.drchannels.viewmodel.ChannelsViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.empty_state.*
import org.jetbrains.anko.toast

open class MainActivity : AppCompatActivity(), ChannelsAdapter.OnChannelClickListener {
    private val api by lazy { DrMuReactiveRepository(this) }

    private lateinit var viewModel: ChannelsViewModel

    private val disposables = CompositeDisposable()

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

        if (!isTv()) {
            updateApp(this@MainActivity,
                    BuildConfig.VERSION_CODE,
                    "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                    "https://www.dropbox.com/s/fwc2q3a3vw67rhv/drchannels.apk?dl=1",
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

        disposables.clear()
    }

    private var isEmptyState: Boolean = false
        set(value) {
            emptyState.isVisible = value
            recyclerView.isVisible = !value
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        /*
        val listsMenu = menu.findItem(R.id.menu_favourite_lists)
        val subMenu = listsMenu.subMenu
        for ((key, name) in favouriteLists) {
            subMenu.add(listsGroup, key, Menu.NONE, name)
        }
        listsMenu.isVisible = favouriteLists.isNotEmpty()
        */

        return false
    }

    private fun loadGenres() {
        /*
        disposables.add(
                api.retrieveEpgGenres()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onNext = { genres ->
                                    genreAdapter.clear()
                                    genreAdapter.add(Genre(0, getString(R.string.all)))
                                    genreAdapter.addAll(genres)
                                    genreAdapter.notifyDataSetChanged()
                                },
                                onError = { toast("Error loading genres") }
                        ))
                        */
    }

    override fun playChannel(muNowNext: MuNowNext) {
        val name = muNowNext.ChannelSlug
        disposables.add(
                api.getAllActiveDrTvChannels()
                        .subscribeOn(Schedulers.io())
                        .map { it.first { it.Slug == name } }
                        .map { it.server ?: throw Exception("Unable to get streaming server") }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onSuccess = { server ->
                                    val stream = server
                                            .Qualities
                                            .sortedByDescending { it.Kbps }.first()
                                            .Streams.first().Stream
                                    startActivity(
                                            buildIntent(
                                                    this@MainActivity,
                                                    "${server.Server}/$stream"))
                                },
                                onError = { e ->
                                    toast(
                                            if (e.message != null
                                                    && e.message != "Success") e.message!!
                                            else getString(R.string.cantChangeChannel))
                                }
                        ))
    }

    override fun playProgram(muNowNext: MuNowNext) {
        val uri = muNowNext.Now?.ProgramCard?.PrimaryAsset?.Uri
        if (uri != null) {
            disposables.add(
                    api.getManifest(uri)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeBy(
                                    onSuccess = { manifest ->
                                        val playbackUri = manifest.uri
                                        if (playbackUri != null) {
                                            startActivity(
                                                    buildIntent(this@MainActivity, playbackUri))
                                        } else {
                                            toast("No stream")
                                        }
                                    },
                                    onError = { e ->
                                        toast(
                                                if (e.message != null
                                                        && e.message != "Success") e.message!!
                                                else getString(R.string.cantChangeChannel))
                                    }
                            ))
        } else {
            toast("No stream")
        }
    }

    private fun buildIntent(context: Context, uri: String): Intent {
        return Intent(context, PlayerActivity::class.java).apply {
            action = PlayerActivity.ACTION_VIEW
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
            data = uri.toUri()
        }
    }

    override fun showChannel(context: Context, channel: MuNowNext) {
        val intent = Intent(context, ProgramsActivity::class.java).apply {
            putExtra(ProgramsActivity.CHANNEL_NAME, channel.ChannelSlug.toUpperCase())
            putExtra(ProgramsActivity.CHANNEL_ID, channel.ChannelSlug)
        }

        context.startActivity(intent, ActivityOptions.makeCustomAnimation(context,
                R.anim.slide_in_left, R.anim.slide_out_left).toBundle())
    }
}
