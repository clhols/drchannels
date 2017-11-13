package dk.youtec.drchannels.player

import android.view.Surface
import com.google.android.exoplayer2.LoadControl
import com.google.android.exoplayer2.RenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.media.tv.companionlibrary.TvPlayer

open class TvExoPlayer(
        renderersFactory: RenderersFactory,
        trackSelector: TrackSelector,
        loadControl: LoadControl
) : SimpleExoPlayer(renderersFactory, trackSelector, loadControl), TvPlayer {

    val tvPlayerCallbacks: MutableList<TvPlayer.Callback> = mutableListOf()

    override fun setSurface(surface: Surface?) {
        setVideoSurface(surface)
    }

    override fun pause() {
        playWhenReady = false
    }

    override fun play() {
        playWhenReady = true
    }

    //Used by TvInputService
    override fun registerCallback(callback: TvPlayer.Callback?) {
        if(callback != null) {
            tvPlayerCallbacks.add(callback)
        }
    }

    override fun unregisterCallback(callback: TvPlayer.Callback?) {
        if(callback != null) {
            tvPlayerCallbacks.remove(callback)
        }
    }
}