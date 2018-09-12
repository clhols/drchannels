package dk.youtec.drchannels.service

import android.content.Context
import android.media.tv.TvContentRating
import android.media.tv.TvInputManager
import android.media.tv.TvInputService
import android.media.tv.TvTrackInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.TextUtils
import android.util.Log
import androidx.core.net.toUri
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS
import com.google.android.exoplayer2.DefaultLoadControl.DEFAULT_MAX_BUFFER_MS
import com.google.android.exoplayer2.offline.FilteringManifestParser
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser
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
import dk.youtec.drchannels.util.serverDateFormat
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import java.util.*
import kotlin.coroutines.CoroutineContext

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
    private val unknownType = -1

    private val defaultBandwidthMeter = DefaultBandwidthMeter.Builder().apply {
        setInitialBitrateEstimate(2_000_000)
    }.build()
    private val trackSelector = DefaultTrackSelector(AdaptiveTrackSelection.Factory(
            defaultBandwidthMeter))
    private val eventLogger = EventLogger(trackSelector)
    private val mediaDataSourceFactory: DataSource.Factory = buildDataSourceFactory(true)

    private var player: TvExoPlayer? = null

    private fun initPlayer(providerData: InternalProviderData) {
        Log.d(tag, "Loading providerData " + providerData.toString())

        val renderersFactory = DefaultRenderersFactory(context)

        releasePlayer()

        // Enable tunneling if supported by the current media and device configuration.
        trackSelector.apply {
            setParameters(
                    buildUponParameters().setTunnelingAudioSessionId(
                            C.generateAudioSessionIdV21(context)))
        }

        val loadControl = DefaultLoadControl.Builder()
                .setBufferDurationsMs(
                        5000,
                        DEFAULT_MAX_BUFFER_MS,
                        1500,
                        DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS)
                .createDefaultLoadControl()

        player = TvExoPlayer(renderersFactory, trackSelector, loadControl).apply {
            addListener(this@DrTvInputSessionImpl)
            addAnalyticsListener(eventLogger)
            prepare(buildMediaSource(providerData.videoUrl.toUri()), true, false)
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
            handlePlayerReady()
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                Math.abs(player!!.playbackParameters.speed - 1) < 0.1 &&
                playWhenReady && playbackState == Player.STATE_BUFFERING) {
            notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_BUFFERING)
        }
    }

    private fun handlePlayerReady() {
        val tracks = ArrayList<TvTrackInfo>()

        val trackSelections = player!!.currentTrackSelections.all.filter { it != null }
        trackSelections.forEach { trackSelection ->

            val format = trackSelection.selectedFormat
            val formatId = format.id
            val trackType = getTrackType(trackSelection)
            if (trackType != unknownType && formatId != null) {
                val builder = TvTrackInfo.Builder(trackType, formatId)

                when (trackType) {
                    TvTrackInfo.TYPE_VIDEO -> {
                        if (format.width != Format.NO_VALUE) {
                            builder.setVideoWidth(format.width)
                        }
                        if (format.height != Format.NO_VALUE) {
                            builder.setVideoHeight(format.height)
                        }
                    }
                    TvTrackInfo.TYPE_AUDIO -> {
                        builder.setAudioChannelCount(format.channelCount)
                        builder.setAudioSampleRate(format.sampleRate)
                        builder.setLanguage(format.language)
                    }
                    TvTrackInfo.TYPE_SUBTITLE -> {
                        builder.setLanguage(format.language)
                    }
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
    }

    private fun getTrackType(trackSelection: TrackSelection): Int {
        val mimeType = trackSelection.selectedFormat.sampleMimeType!!
        if (mimeType.contains("audio/")) {
            return TvTrackInfo.TYPE_AUDIO
        }
        if (mimeType.contains("video/")) {
            return TvTrackInfo.TYPE_VIDEO
        }
        return unknownType
    }

    override fun onSeekProcessed() {
        Log.d(tag, "onSeekProcessed")
    }

    override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
        Log.d(tag, "onShuffleModeEnabledChanged $shuffleModeEnabled")
    }

    override fun onSetCaptionEnabled(enabled: Boolean) {
        Log.d(tag, "onSetCaptionEnabled $enabled")
    }

    override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {
        Log.d(tag, "onPlaybackParametersChanged $playbackParameters")
    }

    override fun onTracksChanged(trackGroups: TrackGroupArray?, trackSelections: TrackSelectionArray?) {
        Log.d(tag, "onTracksChanged $trackSelections")
    }

    override fun onPlayerError(error: ExoPlaybackException?) {
        Log.e(tag, error?.message ?: "Unknown error", error)

        notifyVideoUnavailable(TvInputManager.VIDEO_UNAVAILABLE_REASON_UNKNOWN)
    }

    override fun onLoadingChanged(isLoading: Boolean) {
        Log.d(tag, "onLoadingChanged $isLoading")
    }

    override fun onPositionDiscontinuity(reason: Int) {
        Log.d(tag, "onPositionDiscontinuity $reason")
    }

    override fun onRepeatModeChanged(repeatMode: Int) {
        Log.i(tag, "onRepeatModeChanged $repeatMode")
    }

    override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
        Log.d(tag, "onTimelineChanged $timeline $manifest $reason")
    }

    private fun getVideoId(selectedFormats: List<Format>) =
            selectedFormats.firstOrNull { it.sampleMimeType?.contains("video/") ?: false }?.id
                    ?: "0"

    private fun getAudioId(selectedFormats: List<Format>) =
            selectedFormats.firstOrNull { it.sampleMimeType?.contains("audio/") ?: false }?.id
                    ?: "0"

    private fun buildMediaSource(uri: Uri, overrideExtension: String = ""): MediaSource {
        val type = if (TextUtils.isEmpty(overrideExtension))
            Util.inferContentType(uri)
        else
            Util.inferContentType(".$overrideExtension")

        return when (type) {
            C.TYPE_SS -> SsMediaSource.Factory(DefaultSsChunkSource.Factory(mediaDataSourceFactory),
                    buildDataSourceFactory(false))
                    .setManifestParser(FilteringManifestParser(SsManifestParser(), emptyList()))
                    .createMediaSource(uri)
            C.TYPE_DASH -> DashMediaSource.Factory(DefaultDashChunkSource.Factory(
                    mediaDataSourceFactory),
                    buildDataSourceFactory(false))
                    .setManifestParser(FilteringManifestParser(DashManifestParser(), emptyList()))
                    .createMediaSource(uri)
            C.TYPE_HLS -> HlsMediaSource.Factory(mediaDataSourceFactory)
                    .setPlaylistParser(FilteringManifestParser(HlsPlaylistParser(), emptyList()))
                    .createMediaSource(uri)
            C.TYPE_OTHER -> ExtractorMediaSource.Factory(mediaDataSourceFactory).createMediaSource(
                    uri)
            else -> {
                throw IllegalStateException("Unsupported type: $type")
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
                "${context.packageName} / (Linux;Android ${Build.VERSION.RELEASE}) ",
                if (useBandwidthMeter) defaultBandwidthMeter else null)
    }
}

@RequiresApi(api = Build.VERSION_CODES.N)
class DrTvInputRecordingSessionImpl(
        context: Context,
        private val inputId: String
) : BaseTvInputService.RecordingSession(context, inputId), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val tag = DrTvInputRecordingSessionImpl::class.java.simpleName

    override fun onTune(uri: Uri) {
        super.onTune(uri)

        Log.d(tag, "Tune recording session to $uri")
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
        Log.d(tag, "onStopRecording, programToRecord=$programToRecord")

        // In this drchannels app, since all of the content is VOD, the video URL is stored.
        // If the video was live, the start and stop times should be noted using
        // RecordedProgram.Builder.setStartTimeUtcMillis and .setEndTimeUtcMillis.
        // The recordingstart time will be saved in the InternalProviderData.
        // Additionally, the stream should be recorded and saved as
        // a new file.

        launch {
            val recordedProgram = getRecordedProgram(programToRecord)

            Log.d(tag, "onStopRecording, recorded=$recordedProgram")

            notifyRecordingStopped(recordedProgram)
        }
    }

    private suspend fun getRecordedProgram(
            programToRecord: Program
    ): RecordedProgram? = withContext(Dispatchers.Default) {

        val internalProviderData = programToRecord.internalProviderData
        val assetUri = internalProviderData.get("assetUri") as String
        val endPublish = internalProviderData.get("endPublish") as String?

        val manifestResponse = DrMuRepository().getManifest(assetUri)
        val playbackUrl = manifestResponse.uri ?: ""

        val downloadUrl = manifestResponse.Links
                .asSequence()
                .sortedByDescending { it.Bitrate }
                .firstOrNull { it.Target == "Download" }
                ?.Uri ?: ""

        if (playbackUrl.isNotEmpty()) {
            internalProviderData.videoUrl = playbackUrl
            internalProviderData.videoType = TvContractUtils.SOURCE_TYPE_HLS
        } else {
            internalProviderData.videoUrl = downloadUrl
            internalProviderData.videoType = TvContractUtils.SOURCE_TYPE_INVALID
        }

        internalProviderData.setRecordingStartTime(programToRecord.startTimeUtcMillis)

        with(RecordedProgram.Builder(programToRecord)) {
            setInputId(inputId)
            setRecordingDataUri(internalProviderData.videoUrl)
            setRecordingDurationMillis(programToRecord.endTimeUtcMillis - programToRecord.startTimeUtcMillis)
            if (endPublish != null && endPublish.isNotEmpty()) {
                setRecordingExpireTimeUtcMillis(endPublish.toLong())

                val dateString = serverDateFormat("dd-MM-yyyy HH:mm")
                        .format(Date(endPublish.toLong()))
                setShortDescription((programToRecord.description ?: "") + "\nExpires $dateString")
            }
            setInternalProviderData(internalProviderData)
            build()
        }
    }

    override fun onStopRecordingChannel(channelToRecord: Channel?) {
        Log.d(tag, "onStopRecordingChannel")

        // Program sources in this sample always include program info, so execution here
        // indicates an error.
        notifyError(TvInputManager.RECORDING_ERROR_UNKNOWN)
        return
    }

}