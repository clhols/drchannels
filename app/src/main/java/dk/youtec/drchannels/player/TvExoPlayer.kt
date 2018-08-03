package dk.youtec.drchannels.player

import android.media.PlaybackParams
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Surface
import com.google.android.exoplayer2.LoadControl
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.RenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.media.tv.companionlibrary.TvPlayer
import kotlinx.coroutines.Job
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class TvExoPlayer(
        renderersFactory: RenderersFactory,
        trackSelector: TrackSelector,
        loadControl: LoadControl
) : SimpleExoPlayer(renderersFactory, trackSelector, loadControl, null), TvPlayer {

    private var seekJob: Job? = null

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

            seekJob = launch(UI) {
                while (true) {
                    val position = Math.max(0, (currentPosition + speed * 5000).toLong())
                    seekTo(position)
                    if (position == 0L) return@launch
                    delay(1000)
                }
            }
        } else {
            playbackParameters = PlaybackParameters(speed, 1f)
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