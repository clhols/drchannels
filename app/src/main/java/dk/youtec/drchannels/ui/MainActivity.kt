package dk.youtec.drchannels.ui

import android.app.ActivityOptions
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.adapter.ChannelsAdapter
import dk.youtec.drchannels.viewmodel.ChannelsViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.contentView
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), AnkoLogger, ChannelsAdapter.OnChannelClickListener {

    private val tag = MainActivity::class.java.simpleName

    private val listsGroup = 1

    private val api by lazy { DrMuReactiveRepository(this) }
    private val recyclerView by lazy { find<RecyclerView>(R.id.recycler_view) }
    private val emptyState by lazy { find<ViewGroup>(R.id.empty_state) }
    private val swipeRefresh by lazy { find<SwipeRefreshLayout>(R.id.swipe_refresh) }
    private val progressBar by lazy { find<ProgressBar>(R.id.progressBar) }

    private lateinit var viewModel: ChannelsViewModel
    private var adapter: ChannelsAdapter? = null

    private val disposables = CompositeDisposable()

    companion object {
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initToolbar()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        swipeRefresh.setOnRefreshListener {
            viewModel.channels.load()
        }

        viewModel = ViewModelProviders.of(this)
                .get(ChannelsViewModel::class.java)

        viewModel.channels.observe(
                this,
                android.arch.lifecycle.Observer<List<MuNowNext>> { channels ->
                    handleChannelsChanged(channels)
                })

        //Schedule task
        /*
        val gcmNetworkManager = GcmNetworkManager.getInstance(this)
        gcmNetworkManager.cancelAllTasks(UpcomingProgramsService::class.java)

        val nowTask = OneoffTask.Builder()
                .setService(UpcomingProgramsService::class.java)
                .setExecutionWindow(0L, 10L)
                //.setRequiredNetwork(PeriodicTask.NETWORK_STATE_CONNECTED)
                .setTag(UpcomingProgramsService.UPCOMING_PROGRAMS)
                .build()
        gcmNetworkManager.schedule(nowTask)

        val task = PeriodicTask.Builder()
                .setService(UpcomingProgramsService::class.java)
                .setPeriod(24 * 60 * 60)
                //.setRequiredNetwork(PeriodicTask.NETWORK_STATE_CONNECTED)
                .setTag(UpcomingProgramsService.UPCOMING_PROGRAMS)
                .build()
        gcmNetworkManager.schedule(task)
        */
    }

    /**
     * Called when a change has been observed on channels in ChannelsViewModel
     */
    private fun handleChannelsChanged(channels: List<MuNowNext>?) {
        if (channels != null && !isFinishing) {
            if (adapter != null) {
                progressBar.visibility = View.GONE
                swipeRefresh.isRefreshing = false

                adapter?.updateList(channels)
            } else {
                setEmptyState(false)

                adapter = ChannelsAdapter(
                        this@MainActivity.contentView,
                        channels.filter { it.Now != null },
                        this@MainActivity)
                recyclerView.adapter = adapter
            }
        }
    }

    private fun initToolbar() {
        val toolbar = find<Toolbar>(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)
    }

    override fun onDestroy() {
        super.onDestroy()

        disposables.clear()
    }

    fun setEmptyState(show: Boolean) {
        if (show) {
            emptyState.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyState.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
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
                api.getAllActiveDrTvChannelsObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onNext = { channels ->
                                    val channel = channels.first { it.Slug == name }
                                    val server = channel.StreamingServers.first { it.LinkType == "HLS" }
                                    val stream = server.Qualities.sortedByDescending { it.Kbps }.first().Streams.first().Stream
                                    val playbackUri = "${server.Server}/$stream"
                                    val intent = buildIntent(this@MainActivity, playbackUri)
                                    startActivity(intent)

                                },
                                onError = { e ->
                                    Log.e(tag, e.message, e)
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
                    api.getManifestObservable(uri)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeBy(
                                    onNext = { manifest ->
                                        val playbackUri = manifest.Links.firstOrNull { it.Target == "HLS" }?.Uri
                                        if (playbackUri != null) {
                                            val intent = buildIntent(this@MainActivity, playbackUri)
                                            startActivity(intent)
                                        } else {
                                            toast("No HLS stream")
                                        }
                                    },
                                    onError = { e ->
                                        Log.e(tag, e.message, e)
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
        val preferExtensionDecoders = false

        val intent = Intent(context, PlayerActivity::class.java)
        with(intent) {
            action = PlayerActivity.ACTION_VIEW
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS, preferExtensionDecoders)
            setData(Uri.parse(uri))
        }

        return intent
    }

    override fun showChannel(context: Context, channel: MuNowNext) {
        val intent = Intent(context, ProgramsActivity::class.java)
        with(intent) {
            putExtra(ProgramsActivity.CHANNEL_NAME, channel.Channel)
            putExtra(ProgramsActivity.CHANNEL_ID, channel.ChannelSlug)
        }

        if (Build.VERSION.SDK_INT > 15) {
            val translateBundle = ActivityOptions.makeCustomAnimation(context,
                    R.anim.slide_in_left, R.anim.slide_out_left).toBundle()

            context.startActivity(intent, translateBundle)
        } else {
            context.startActivity(intent)
        }
    }
}
