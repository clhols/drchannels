package dk.youtec.drchannels.service

import android.content.Context
import android.media.tv.TvContentRating
import android.media.tv.TvInputManager
import android.media.tv.TvInputService
import android.media.tv.TvTrackInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.text.TextUtils
import android.util.Log
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelection
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.*
import com.google.android.exoplayer2.util.Util
import com.google.android.media.tv.companionlibrary.BaseTvInputService
import com.google.android.media.tv.companionlibrary.TvPlayer
import com.google.android.media.tv.companionlibrary.model.Channel
import com.google.android.media.tv.companionlibrary.model.InternalProviderData
import com.google.android.media.tv.companionlibrary.model.Program
import com.google.android.media.tv.companionlibrary.model.RecordedProgram
import com.google.android.media.tv.companionlibrary.utils.TvContractUtils
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drchannels.log.EventLogger
import dk.youtec.drchannels.player.TvExoPlayer
import java.util.*

class DrTvInputService : BaseTvInputService() {
    override fun onCreateSession(inputId: String): TvInputService.Session {
        val session = DrTvInputSessionImpl(this, inputId).apply {
            setOverlayViewEnabled(true)
        }

        return super.sessionCreated(session)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateRecordingSession(inputId: String): TvInputService.RecordingSession =
            DrTvInputRecordingSessionImpl(this, inputId)
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

    private fun initPlayer(providerData: InternalProviderData) {
        Log.d(tag, "Loading providerData " + providerData.toString())

        val drmSessionManager = null
        val renderersFactory = DefaultRenderersFactory(
                context,
                drmSessionManager,
                DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF)

        releasePlayer()

        player = TvExoPlayer(renderersFactory, trackSelector, DefaultLoadControl()).apply {
            addListener(this@DrTvInputSessionImpl)
            addListener(eventLogger)
            setAudioDebugListener(eventLogger)
            setVideoDebugListener(eventLogger)
            setMetadataOutput(eventLogger)
            prepare(buildMediaSource(Uri.parse(providerData.videoUrl)), true, false)
        }
    }

    override fun onPlayProgram(program: Program?, startPosMs: Long): Boolean {
        if (program == null) {
            notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_TUNING)
            return false
        }

        initPlayer(program.internalProviderData)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notifyTimeShiftStatusChanged(TvInputManager.TIME_SHIFT_STATUS_AVAILABLE)
        }

        player?.playWhenReady = true

        return true
    }

    override fun onPlayRecordedProgram(recordedProgram: RecordedProgram?): Boolean {
        Log.i(tag, "onPlayRecordedProgram $recordedProgram")
        if (recordedProgram == null) {
            notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_TUNING)
            return false
        }

        initPlayer(recordedProgram.internalProviderData)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notifyTimeShiftStatusChanged(TvInputManager.TIME_SHIFT_STATUS_AVAILABLE)
        }

        onSetStreamVolume(1.0f)

        player?.playWhenReady = true

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
        player?.apply {
            removeListener(this@DrTvInputSessionImpl)
            setSurface(null)
            stop()
            release()
        }
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

            notifyTrackSelected(TvTrackInfo.TYPE_AUDIO, getAudioId(selectedFormats))
            notifyTrackSelected(TvTrackInfo.TYPE_VIDEO, getVideoId(selectedFormats))
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

    private fun getVideoId(selectedFormats: List<Format>) =
            selectedFormats.firstOrNull { it.sampleMimeType.contains("video/") }?.id ?: "0"

    private fun getAudioId(selectedFormats: List<Format>) =
            selectedFormats.firstOrNull { it.sampleMimeType.contains("audio/") }?.id ?: "0"

    private fun buildMediaSource(uri: Uri, overrideExtension: String = ""): MediaSource {
        val type = if (TextUtils.isEmpty(overrideExtension))
            Util.inferContentType(uri)
        else
            Util.inferContentType("." + overrideExtension)
        when (type) {
            C.TYPE_SS -> return SsMediaSource(uri, buildDataSourceFactory(false),
                    DefaultSsChunkSource.Factory(mediaDataSourceFactory), mainHandler, eventLogger)
            C.TYPE_DASH -> return DashMediaSource(uri, buildDataSourceFactory(false),
                    DefaultDashChunkSource.Factory(mediaDataSourceFactory), mainHandler, eventLogger)
            C.TYPE_HLS -> return HlsMediaSource(uri, mediaDataSourceFactory, mainHandler, eventLogger)
            C.TYPE_OTHER -> return ExtractorMediaSource(uri, mediaDataSourceFactory, DefaultExtractorsFactory(),
                    mainHandler, eventLogger)
            else -> {
                throw IllegalStateException("Unsupported type: " + type)
            }
        }
    }

    private fun buildDataSourceFactory(useBandwidthMeter: Boolean): DataSource.Factory {
        return DefaultDataSourceFactory(
                context,
                if (useBandwidthMeter) defaultBandwidthMeter else null,
                buildHttpDataSourceFactory(useBandwidthMeter))
    }

    private fun buildHttpDataSourceFactory(useBandwidthMeter: Boolean): HttpDataSource.Factory {
        return DefaultHttpDataSourceFactory(
                "Drchannels/" + " (Linux;Android " + Build.VERSION.RELEASE + ") ",
                if (useBandwidthMeter) defaultBandwidthMeter else null)
    }
}

@RequiresApi(api = Build.VERSION_CODES.N)
class DrTvInputRecordingSessionImpl(
        context: Context,
        private val inputId: String
) : BaseTvInputService.RecordingSession(context, inputId) {
    private val tag = DrTvInputRecordingSessionImpl::class.java.simpleName

    override fun onTune(uri: Uri) {
        super.onTune(uri)

        Log.d(tag, "Tune recording session to " + uri)
        // By default, the number of tuners for this service is one. When a channel is being
        // recorded, no other channel from this TvInputService will be accessible. Developers
        // should call notifyError(TvInputManager.RECORDING_ERROR_RESOURCE_BUSY) to alert
        // the framework that this recording cannot be completed.
        // Developers can update the tuner count in xml/richtvinputservice or programmatically
        // by adding it to TvInputInfo.updateTvInputInfo.
        notifyTuned(uri)
    }

    override fun onStartRecording(uri: Uri?) {
        super.onStartRecording(uri)
        Log.d(tag, "onStartRecording")
    }

    override fun onRelease() {
        Log.d(tag, "onRelease")
    }

    override fun onStopRecording(programToRecord: Program) {
        Log.d(tag, "onStopRecording, programToRecord=" + programToRecord)

        // In this sample app, since all of the content is VOD, the video URL is stored.
        // If the video was live, the start and stop times should be noted using
        // RecordedProgram.Builder.setStartTimeUtcMillis and .setEndTimeUtcMillis.
        // The recordingstart time will be saved in the InternalProviderData.
        // Additionally, the stream should be recorded and saved as
        // a new file.

        val internalProviderData = programToRecord.internalProviderData

        var playbackUrl = ""
        var downloadUrl = ""

        val assetUri = programToRecord.internalProviderData!!.get("assetUri") as String
        val endPublish = programToRecord.internalProviderData!!.get("endPublish") as String?
        val manifestResponse = DrMuRepository().getManifest(assetUri)
        manifestResponse?.Links
                ?.asSequence()
                ?.firstOrNull { it.Target == "HLS" }
                ?.Uri?.let {
            playbackUrl = it
        }
        manifestResponse?.Links
                ?.asSequence()
                ?.sortedByDescending { it.Bitrate }
                ?.firstOrNull { it.Target == "Download" }
                ?.Uri?.let {
            downloadUrl = it
        }

        if (playbackUrl.isNotEmpty()) {
            internalProviderData.videoUrl = playbackUrl
            internalProviderData.videoType = TvContractUtils.SOURCE_TYPE_HLS
        } else {
            internalProviderData.videoUrl = downloadUrl
            internalProviderData.videoType = TvContractUtils.SOURCE_TYPE_INVALID
        }

        internalProviderData.setRecordingStartTime(programToRecord.startTimeUtcMillis)

        val recordedProgram = with(RecordedProgram.Builder(programToRecord)) {
            setInputId(inputId)
            setRecordingDataUri(internalProviderData.videoUrl)
            setRecordingDurationMillis(programToRecord.endTimeUtcMillis - programToRecord.startTimeUtcMillis)
            if (endPublish != null && endPublish.isNotEmpty()) {
                setRecordingExpireTimeUtcMillis(endPublish.toLong())
            }
            setInternalProviderData(internalProviderData)
            build()
        }

        Log.d(tag, "onStopRecording, recorded=" + recordedProgram)

        notifyRecordingStopped(recordedProgram)
    }

    override fun onStopRecordingChannel(channelToRecord: Channel?) {
        Log.d(tag, "onStopRecordingChannel")

        // Program sources in this sample always include program info, so execution here
        // indicates an error.
        notifyError(TvInputManager.RECORDING_ERROR_UNKNOWN)
        return
    }

}