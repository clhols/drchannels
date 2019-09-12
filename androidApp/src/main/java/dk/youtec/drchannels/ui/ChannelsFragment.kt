package dk.youtec.drchannels.ui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.exoplayer2.util.Util.isTv
import dk.youtec.appupdater.updateApp
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.logic.viewmodel.AndroidTvChannelsViewModel
import dk.youtec.drchannels.ui.adapter.TvChannelsAdapter
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.toast
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.android.synthetic.main.fragment_channels.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ChannelsFragment : Fragment() {
    private var channelsJob: Job? = null
    private val viewModel: AndroidTvChannelsViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_channels, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        swipeRefresh.setOnRefreshListener {
            reload()
        }

        progressBar.isVisible = true

        lifecycleScope.launch {
            viewModel.playbackUri.collect { uri ->
                Log.d(TAG, "Playback uri")
                startActivity(Intent(activity, PlayerActivity::class.java).apply {
                    action = PlayerActivity.ACTION_VIEW
                    putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                    data = uri.toUri()
                })
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect { message ->
                context?.toast(message)
            }
        }

        lifecycleScope.launch {
            adapter.itemClicked.collect {
                viewModel.playTvChannel(it)
            }
        }

        lifecycleScope.launch {
            adapter.startOverClicked.collect {
                viewModel.playProgram(it)
            }
        }

        lifecycleScope.launch {
            adapter.moreClicked.collect {
                context?.startActivity(
                        Intent(context, ProgramsActivity::class.java).apply {
                            putExtra(ProgramsActivity.CHANNEL_NAME, it.channelSlug.toUpperCase())
                            putExtra(ProgramsActivity.CHANNEL_ID, it.channelSlug)
                        },
                        ActivityOptions.makeCustomAnimation(
                                context,
                                R.anim.slide_in_left,
                                R.anim.slide_out_left
                        ).toBundle())
            }
        }

        if (savedInstanceState == null) {
            if (!isTv(context) && !BuildConfig.DEBUG) {
                activity?.let {
                    updateApp(it,
                            BuildConfig.VERSION_CODE,
                            "https://www.dropbox.com/s/ywgq3zyap9f2v7l/drchannels.json?dl=1",
                            "https://www.dropbox.com/s/tw9gpldrwicd3kj/drchannels.apk?dl=1",
                            "https://www.dropbox.com/s/8miqyro43qn71k0/drchannels.log?dl=1")
                }
            }
        }
    }

    private fun reload() {
        channelsJob?.cancel()
        channelsJob = viewLifecycleOwner.lifecycleScope.launch {
            viewModel.channels.collect { channels ->
                isEmptyState = channels.isNullOrEmpty()
                handleChannelsChanged(channels)
                progressBar.isVisible = false
                swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        reload()
    }

    override fun onStop() {
        channelsJob?.cancel()
        super.onStop()
    }

    /**
     * Called when a change has been observed on channels in ChannelsViewModel
     */
    private fun handleChannelsChanged(channels: List<MuNowNext>) {
        adapter.submitList(channels)
    }

    private val adapter: TvChannelsAdapter
        get() {
            return (recyclerView.adapter as? TvChannelsAdapter)
                    ?: TvChannelsAdapter(lifecycleScope).also {
                        recyclerView.adapter = it
                    }
        }

    private var isEmptyState: Boolean = false
        set(value) {
            emptyState.isVisible = value
            recyclerView.isVisible = !value
            field = value
        }

    companion object {
        const val TAG = "ChannelsFragment"
    }
}