package dk.youtec.drchannels.ui

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.exoplayer2.util.Util.isTv
import dk.youtec.appupdater.updateApp
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.BuildConfig
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.adapter.TvChannelsAdapter
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.util.toast
import dk.youtec.drchannels.viewmodel.TvChannelsViewModel
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.android.synthetic.main.fragment_channels.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ChannelsFragment : Fragment(), TvChannelsAdapter.OnChannelClickListener, CoroutineScope by MainScope() {
    private val viewModel: TvChannelsViewModel by viewModels()

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
            viewModel.reload()
        }

        progressBar.isVisible = true

        with(viewModel) {
            launch {
                channels.collect { channels ->
                    Log.d(TAG, "Tv channels $this")
                    isEmptyState = channels.isNullOrEmpty()
                    handleChannelsChanged(channels)
                    progressBar.isVisible = false
                    swipeRefresh.isRefreshing = false
                }
            }

            launch {
                playbackUri.collect { uri ->
                    Log.d(TAG, "Playback uri")
                    startActivity(Intent(activity, PlayerActivity::class.java).apply {
                        action = PlayerActivity.ACTION_VIEW
                        putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, false)
                        data = uri.toUri()
                    })
                }
            }

            launch {
                error.collect { message ->
                    context?.toast(message)
                }
            }
        }

        if (savedInstanceState == null) {
            viewModel.reload()

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

    /**
     * Called when a change has been observed on channels in ChannelsViewModel
     */
    private fun handleChannelsChanged(channels: List<MuNowNext>) {
        getAdapter().submitList(channels)
    }

    private fun getAdapter(): TvChannelsAdapter {
        return (recyclerView.adapter as? TvChannelsAdapter) ?: TvChannelsAdapter(this).also {
            recyclerView.adapter = it
        }
    }

    private var isEmptyState: Boolean = false
        set(value) {
            emptyState.isVisible = value
            recyclerView.isVisible = !value
            field = value
        }

    override fun playTvChannel(muNowNext: MuNowNext) = viewModel.playTvChannel(muNowNext)

    override fun playProgram(muNowNext: MuNowNext) = viewModel.playProgram(muNowNext)

    override fun showTvChannel(context: Context, tvChannel: MuNowNext) {
        context.startActivity(
                Intent(context, ProgramsActivity::class.java).apply {
                    putExtra(ProgramsActivity.CHANNEL_NAME, tvChannel.channelSlug.toUpperCase())
                    putExtra(ProgramsActivity.CHANNEL_ID, tvChannel.channelSlug)
                },
                ActivityOptions.makeCustomAnimation(
                        context,
                        R.anim.slide_in_left,
                        R.anim.slide_out_left
                ).toBundle())
    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }

    companion object {
        const val TAG = "ChannelsFragment"
    }
}