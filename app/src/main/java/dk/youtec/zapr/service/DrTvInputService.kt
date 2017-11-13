package dk.youtec.zapr.service

import android.content.Context
import android.media.tv.TvContentRating
import android.media.tv.TvInputManager
import android.media.tv.TvInputService
import android.media.tv.TvTrackInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelection
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.*
import com.google.android.media.tv.companionlibrary.BaseTvInputService
import com.google.android.media.tv.companionlibrary.TvPlayer
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.model.RecordedProgram
import dk.youtec.zapr.log.EventLogger
import dk.youtec.zapr.player.TvExoPlayer
import java.util.ArrayList

class DrTvInputService : BaseTvInputService() {
    override fun onCreateSession(inputId: String): TvInputService.Session {
        val session = DrTvInputSessionImpl(this, inputId)
        session.setOverlayViewEnabled(true)
        return super.sessionCreated(session)
    }
}

class DrTvInputSessionImpl(
        private val context: Context,
        inputId: String
) : BaseTvInputService.Session(context, inputId), Player.EventListener {
    private val tag = DrTvInputSessionImpl::class.java.simpleName
    private val mainHandler = Handler()
    private val unknownType = -1

    private val defaultBandwidthMeter = DefaultBandwidthMeter()
    private val trackSelector = DefaultTrackSelector(AdaptiveTrackSelection.Factory(defaultBandwidthMeter))
    private val eventLogger = EventLogger(trackSelector)
    private val mediaDataSourceFactory: DataSource.Factory = buildDataSourceFactory(true)

    private var player: TvExoPlayer? = null

    override fun onPlayProgram(program: Program?, startPosMs: Long): Boolean {
        if (program == null) {
            notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_TUNING)
            return false
        }

        val drmSessionManager = null
        val renderersFactory = DefaultRenderersFactory(
                context,
                drmSessionManager,
                DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF)

        releasePlayer()

        player = TvExoPlayer(renderersFactory, trackSelector, DefaultLoadControl())
        player!!.addListener(this)
        player!!.addListener(eventLogger)
        player!!.setAudioDebugListener(eventLogger)
        player!!.setVideoDebugListener(eventLogger)
        player!!.setMetadataOutput(eventLogger)

        val type = program.internalProviderData.videoType
        val uri = Uri.parse(program.internalProviderData.videoUrl)

        val mediaSource: MediaSource
        if (type == C.TYPE_HLS) {
            mediaSource = HlsMediaSource(uri, mediaDataSourceFactory, mainHandler, eventLogger)
        } else {
            throw IllegalStateException("Unsupported type: " + type)
        }

        player!!.prepare(mediaSource, true, false)

        /*
        if (startPosMs > 0) {
            Log.d(tag, "Seek to " + startPosMs)
            player!!.seekTo(startPosMs)
        }
        */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notifyTimeShiftStatusChanged(TvInputManager.TIME_SHIFT_STATUS_AVAILABLE)
        }

        player!!.playWhenReady = true

        return true
    }

    override fun onTune(channelUri: Uri?, params: Bundle?): Boolean {
        Log.d(tag, "Tune to " + channelUri.toString())

        notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_TUNING)
        releasePlayer()

        return super.onTune(channelUri, params)
    }

    override fun onRelease() {
        Log.d(tag, "onRelease")
        super.onRelease()
        releasePlayer()
    }

    override fun onBlockContent(rating: TvContentRating) {
        Log.d(tag, "onBlockContent $rating")
        super.onBlockContent(rating)
        releasePlayer()
    }

    private fun releasePlayer() {
        player?.removeListener(this)
        player?.setSurface(null)
        player?.stop()
        player?.release()
        player = null
    }

    override fun getTvPlayer(): TvPlayer? = player

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        if (player == null) {
            return
        }

        Log.d(tag, "onPlayerStateChanged $playWhenReady with state $playbackState")

        if (playWhenReady && playbackState == Player.STATE_READY) {
            val tracks = ArrayList<TvTrackInfo>()

            val trackSelections = player!!.currentTrackSelections.all.filter { it != null }
            trackSelections.forEach { trackSelection ->

                val trackType = getTrackType(trackSelection)
                if (trackType != unknownType) {
                    val format = trackSelection.selectedFormat

                    val builder = TvTrackInfo.Builder(trackType, format.id)

                    if (trackType == TvTrackInfo.TYPE_VIDEO) {
                        if (format.width != Format.NO_VALUE) {
                            builder.setVideoWidth(format.width)
                        } else if (format.width != Format.NO_VALUE) {
                            builder.setVideoWidth(format.width)
                        }
                        if (format.height != Format.NO_VALUE) {
                            builder.setVideoHeight(format.height)
                        } else if (format.height != Format.NO_VALUE) {
                            builder.setVideoHeight(format.height)
                        }
                    } else if (trackType == TvTrackInfo.TYPE_AUDIO) {
                        builder.setAudioChannelCount(format.channelCount)
                        builder.setAudioSampleRate(format.sampleRate)
                        builder.setLanguage(format.language)
                    } else if (trackType == TvTrackInfo.TYPE_SUBTITLE) {
                        builder.setLanguage(format.language)
                    }

                    tracks.add(builder.build())
                }
            }
            notifyTracksChanged(tracks)

            val selectedFormats = trackSelections.map { it.selectedFormat }
            val audioId = selectedFormats.firstOrNull { it.sampleMimeType.contains("audio/") }?.id ?: "0"
            val videoId = selectedFormats.firstOrNull { it.sampleMimeType.contains("video/") }?.id ?: "0"
            val textId = "0"

            notifyTrackSelected(TvTrackInfo.TYPE_AUDIO, audioId)
            notifyTrackSelected(TvTrackInfo.TYPE_VIDEO, videoId)
            //notifyTrackSelected(TvTrackInfo.TYPE_SUBTITLE, textId)
            notifyVideoAvailable()
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                Math.abs(player!!.playbackParameters.speed - 1) < 0.1 &&
                playWhenReady && playbackState == Player.STATE_BUFFERING) {
            notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_BUFFERING)
        }
    }

    private fun getTrackType(trackSelection: TrackSelection): Int {
        val mimeType = trackSelection.selectedFormat.sampleMimeType
        if (mimeType.contains("audio/")) {
            return TvTrackInfo.TYPE_AUDIO
        }
        if (mimeType.contains("video/")) {
            return TvTrackInfo.TYPE_VIDEO
        }
        return unknownType
    }

    override fun onSetCaptionEnabled(enabled: Boolean) {
        Log.i(tag, "onSetCaptionEnabled $enabled")
    }

    override fun onPlayRecordedProgram(recordedProgram: RecordedProgram?): Boolean {
        Log.i(tag, "onPlayRecordedProgram $recordedProgram")
        return false
    }

    override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {
        Log.i(tag, "onPlaybackParametersChanged $playbackParameters")
    }

    override fun onTracksChanged(trackGroups: TrackGroupArray?, trackSelections: TrackSelectionArray?) {
        Log.i(tag, "onTracksChanged $trackSelections")
    }

    override fun onPlayerError(error: ExoPlaybackException?) {
        Log.e(tag, error?.message ?: "Unknown error", error)
    }

    override fun onLoadingChanged(isLoading: Boolean) {
        Log.i(tag, "onLoadingChanged $isLoading")
    }

    override fun onPositionDiscontinuity() {
        Log.i(tag, "onPositionDiscontinuity")
    }

    override fun onRepeatModeChanged(repeatMode: Int) {
        Log.i(tag, "onRepeatModeChanged $repeatMode")
    }

    override fun onTimelineChanged(timeline: Timeline?, manifest: Any?) {
        Log.i(tag, "onTimelineChanged $timeline $manifest")
    }

    private fun buildDataSourceFactory(useBandwidthMeter: Boolean): DataSource.Factory {
        return DefaultDataSourceFactory(
                context,
                if (useBandwidthMeter) defaultBandwidthMeter else null,
                buildHttpDataSourceFactory(useBandwidthMeter))
    }

    private fun buildHttpDataSourceFactory(useBandwidthMeter: Boolean): HttpDataSource.Factory {
        return DefaultHttpDataSourceFactory(
                "Zapr/" + " (Linux;Android " + Build.VERSION.RELEASE + ") ",
                if (useBandwidthMeter) defaultBandwidthMeter else null)
    }
}