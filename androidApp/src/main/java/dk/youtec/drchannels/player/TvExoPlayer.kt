package dk.youtec.drchannels.player

import android.content.Context
import android.media.PlaybackParams
import android.os.Build
import android.os.Looper
import android.view.Surface
import androidx.annotation.RequiresApi
import com.google.android.exoplayer2.LoadControl
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.RenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.analytics.AnalyticsCollector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.util.Clock
import com.google.android.media.tv.companionlibrary.TvPlayer
import dk.youtec.drchannels.util.koined
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class TvExoPlayer(
        context: Context,
        renderersFactory: RenderersFactory,
        trackSelector: TrackSelector,
        loadControl: LoadControl,
        bandwidthMeter: BandwidthMeter
) : SimpleExoPlayer(context,
        renderersFactory,
        trackSelector,
        loadControl,
        bandwidthMeter,
        AnalyticsCollector(Clock.DEFAULT),
        Clock.DEFAULT,
        Looper.getMainLooper()), TvPlayer {
    private var seekJob: Job? = null
    private val applicationScope: CoroutineScope = koined()

    override fun setSurface(surface: Surface?) {
        setVideoSurface(surface)
    }

    override fun pause() {
        playWhenReady = false
    }

    override fun play() {
        playWhenReady = true
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun setPlaybackParams(params: PlaybackParams?) {
        val speed = params?.speed ?: 1f
        seekJob?.cancel()

        if (speed != 1f) {
            pause()

            seekJob = applicationScope.launch {
                while (true) {
                    val position = Math.max(0, (currentPosition + speed * 5000).toLong())
                    seekTo(position)
                    if (position == 0L) return@launch
                    delay(1000)
                }
            }
        } else {
            setPlaybackParameters(PlaybackParameters(speed, 1f))
            play()
        }
    }

    override fun registerCallback(callback: TvPlayer.Callback?) {
        //Not used
    }

    override fun unregisterCallback(callback: TvPlayer.Callback?) {
        //Not used
    }
}