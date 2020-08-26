/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.youtec.drchannels.ui.exoplayer;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.C.ContentType;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.ext.cast.MediaItem;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.DebugTextViewHelper;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.EventLogger;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.firebase.analytics.FirebaseAnalytics;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.media.MediaRouteSelector;

import dk.youtec.drchannels.R;

import static androidx.mediarouter.media.MediaControlIntent.CATEGORY_LIVE_VIDEO;
import static dk.youtec.drchannels.util.ContextExtensionsKt.isTv;

/** An activity that plays media using {@link SimpleExoPlayer}. */
public class PlayerActivity extends AppCompatActivity
        implements OnClickListener, PlaybackPreparer, PlayerControlView.VisibilityListener {

    public static final String PREFER_EXTENSION_DECODERS_EXTRA = "prefer_extension_decoders";

    public static final String ACTION_VIEW = "com.google.android.exoplayer.demo.action.VIEW";
    public static final String EXTENSION_EXTRA = "extension";
    public static final String TITLE_EXTRA = "title";
    public static final String IMAGE_EXTRA = "image_url";

    public static final String ACTION_VIEW_LIST =
            "com.google.android.exoplayer.demo.action.VIEW_LIST";
    public static final String URI_LIST_EXTRA = "uri_list";
    public static final String EXTENSION_LIST_EXTRA = "extension_list";

    public static final String ABR_ALGORITHM_EXTRA = "abr_algorithm";
    public static final String ABR_ALGORITHM_DEFAULT = "default";
    public static final String ABR_ALGORITHM_RANDOM = "random";

    public static final String SPHERICAL_STEREO_MODE_EXTRA = "spherical_stereo_mode";
    public static final String SPHERICAL_STEREO_MODE_MONO = "mono";
    public static final String SPHERICAL_STEREO_MODE_TOP_BOTTOM = "top_bottom";
    public static final String SPHERICAL_STEREO_MODE_LEFT_RIGHT = "left_right";

    // Saved instance state keys.
    private static final String KEY_TRACK_SELECTOR_PARAMETERS = "track_selector_parameters";
    private static final String KEY_WINDOW = "window";
    private static final String KEY_POSITION = "position";
    private static final String KEY_AUTO_PLAY = "auto_play";

    private static final CookieManager DEFAULT_COOKIE_MANAGER;

    static {
        DEFAULT_COOKIE_MANAGER = new CookieManager();
        DEFAULT_COOKIE_MANAGER.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    private PlayerView playerView;
    private LinearLayout debugRootView;
    private Button selectTracksButton;
    private TextView debugTextView;
    private boolean isShowingTrackSelectionDialog;

    private DataSource.Factory dataSourceFactory;
    private SimpleExoPlayer player;
    private FrameworkMediaDrm mediaDrm;
    private MediaSource mediaSource;
    private DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private DebugTextViewHelper debugViewHelper;
    private TrackGroupArray lastSeenTrackGroupArray;

    private boolean startAutoPlay;
    private int startWindow;
    private long startPosition;

    // Fields used only for ad playback. The ads loader is loaded via reflection.

    private boolean useExtensionRenderers = false;
    private CastContext castContext;
    private PlayerControlView playerControlView;
    private PlayerManager playerManager;
    private MediaRouteButton mediaRouteButton;
    private View castInfoView;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.v("PlayerActivity", "Key pressed: " + keyCode);

        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                playerView.setUseController(true);
                if (!playerView.isControllerVisible()) {
                    playerView.showController();
                }
                break;
            case KeyEvent.KEYCODE_BUTTON_A:
                if (!playerView.isControllerVisible()) {
                    int playbackState = player.getPlaybackState();
                    if (playbackState == Player.STATE_IDLE) {
                        preparePlayback();
                    } else if (playbackState == Player.STATE_ENDED) {
                        player.seekTo(player.getCurrentWindowIndex(), C.TIME_UNSET);
                    } else if (playbackState == Player.STATE_READY) {
                        player.setPlayWhenReady(!player.getPlayWhenReady());
                    }
                }
                break;
            case KeyEvent.KEYCODE_BUTTON_X:
                selectTracksButton.performClick();
                return true;
            case KeyEvent.KEYCODE_BUTTON_B:
                break;
            case KeyEvent.KEYCODE_BUTTON_Y:
                player.setPlayWhenReady(!player.getPlayWhenReady());
                return true;
            case KeyEvent.KEYCODE_BUTTON_THUMBL:
                break;
            case KeyEvent.KEYCODE_BUTTON_THUMBR:
                break;
            case KeyEvent.KEYCODE_BUTTON_R1:
                player.seekTo(player.getCurrentPosition() + 5000);
                return true;
            case KeyEvent.KEYCODE_BUTTON_L1:
                player.seekTo(player.getCurrentPosition() - 5000);
                return true;
            case KeyEvent.KEYCODE_BUTTON_START:
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (!playerView.isControllerVisible()) {
                    player.seekTo(player.getCurrentPosition() - 10000);
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (!playerView.isControllerVisible()) {
                    player.seekTo(player.getCurrentPosition() + 10000);
                }
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                break;
        }

        return super.onKeyUp(keyCode, event);
    }

    // Activity lifecycle

    @Override
    public void onCreate(Bundle savedInstanceState) {
        String sphericalStereoMode = getIntent().getStringExtra(SPHERICAL_STEREO_MODE_EXTRA);

        super.onCreate(savedInstanceState);
        dataSourceFactory = buildDataSourceFactory();
        if (CookieHandler.getDefault() != DEFAULT_COOKIE_MANAGER) {
            CookieHandler.setDefault(DEFAULT_COOKIE_MANAGER);
        }

        setContentView(R.layout.player_activity);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root), (v, insets) -> {
            v.setPadding(
                    v.getPaddingLeft(),
                    v.getPaddingTop(),
                    v.getPaddingRight(),
                    insets.getSystemWindowInsetBottom()
            );
            return insets;
        });

        debugRootView = findViewById(R.id.controls_root);
        debugTextView = findViewById(R.id.debug_text_view);
        selectTracksButton = findViewById(R.id.select_tracks_button);
        selectTracksButton.setOnClickListener(this);

        if (!isTv(this)) {
            castContext = CastContext.getSharedInstance(this);
        }
        playerControlView = findViewById(R.id.player_control_view);
        castInfoView = findViewById(R.id.cast_info_view);

        playerView = findViewById(R.id.player_view);
        playerView.setControllerVisibilityListener(this);
        playerView.setErrorMessageProvider(new PlayerErrorMessageProvider());
        playerView.requestFocus();
        if (sphericalStereoMode != null) {
            int stereoMode;
            if (SPHERICAL_STEREO_MODE_MONO.equals(sphericalStereoMode)) {
                stereoMode = C.STEREO_MODE_MONO;
            } else if (SPHERICAL_STEREO_MODE_TOP_BOTTOM.equals(sphericalStereoMode)) {
                stereoMode = C.STEREO_MODE_TOP_BOTTOM;
            } else if (SPHERICAL_STEREO_MODE_LEFT_RIGHT.equals(sphericalStereoMode)) {
                stereoMode = C.STEREO_MODE_LEFT_RIGHT;
            } else {
                showToast("error_unrecognized_stereo_mode");
                finish();
                return;
            }
            ((SphericalGLSurfaceView) playerView.getVideoSurfaceView()).setDefaultStereoMode(stereoMode);
        }

        if (savedInstanceState != null) {
            trackSelectorParameters = savedInstanceState.getParcelable(KEY_TRACK_SELECTOR_PARAMETERS);
            startAutoPlay = savedInstanceState.getBoolean(KEY_AUTO_PLAY);
            startWindow = savedInstanceState.getInt(KEY_WINDOW);
            startPosition = savedInstanceState.getLong(KEY_POSITION);
        } else {
            DefaultTrackSelector.ParametersBuilder builder = new DefaultTrackSelector.ParametersBuilder(/* context= */ this);
            builder.setDisabledTextTrackSelectionFlags(C.SELECTION_FLAG_DEFAULT);
            trackSelectorParameters = builder.build();
            clearStartPosition();
        }

        mediaRouteButton = findViewById(R.id.media_route_button);
        mediaRouteButton.setVisibility(castContext == null ? View.GONE : View.VISIBLE);
        mediaRouteButton.setRouteSelector(new MediaRouteSelector.Builder()
                .addControlCategory(CATEGORY_LIVE_VIDEO)
                .build());
        CastButtonFactory.setUpMediaRouteButton(this, mediaRouteButton);

        FirebaseAnalytics.getInstance(this).logEvent("playback", null);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        releasePlayer();
        clearStartPosition();
        setIntent(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
            if (playerView != null) {
                playerView.onResume();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Util.SDK_INT <= 23 || player == null) {
            initializePlayer();
            if (playerView != null) {
                playerView.onResume();
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            if (playerView != null) {
                playerView.onPause();
            }
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            if (playerView != null) {
                playerView.onPause();
            }
            releasePlayer();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (grantResults.length == 0) {
            // Empty results are triggered if a permission is requested while another request was already
            // pending and can be safely ignored in this case.
            return;
        }
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            initializePlayer();
        } else {
            showToast(R.string.storage_permission_denied);
            finish();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        updateTrackSelectorParameters();
        updateStartPosition();
        outState.putParcelable(KEY_TRACK_SELECTOR_PARAMETERS, trackSelectorParameters);
        outState.putBoolean(KEY_AUTO_PLAY, startAutoPlay);
        outState.putInt(KEY_WINDOW, startWindow);
        outState.putLong(KEY_POSITION, startPosition);
    }

    // Activity input

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // See whether the player view wants to handle media or DPAD keys events.
        boolean handled = playerManager != null ? playerManager.dispatchKeyEvent(event) : playerView.dispatchKeyEvent(event);
        return handled || super.dispatchKeyEvent(event);
    }

    // OnClickListener methods

    @Override
    public void onClick(View view) {
        if (view == selectTracksButton
                && !isShowingTrackSelectionDialog
                && TrackSelectionDialog.willHaveContent(trackSelector)) {
            isShowingTrackSelectionDialog = true;
            TrackSelectionDialog trackSelectionDialog =
                    TrackSelectionDialog.createForTrackSelector(
                            trackSelector,
                            /* onDismissListener= */ dismissedDialog -> isShowingTrackSelectionDialog = false);
            trackSelectionDialog.show(getSupportFragmentManager(), /* tag= */ null);
        }
    }

    // PlaybackControlView.PlaybackPreparer implementation

    @Override
    public void preparePlayback() {
        player.retry();
    }

    // PlaybackControlView.VisibilityListener implementation

    @Override
    public void onVisibilityChange(int visibility) {
        debugRootView.setVisibility(visibility);

        //Hide the statusbar together with controls
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        (visibility == View.VISIBLE ?
                                View.SYSTEM_UI_FLAG_VISIBLE :
                                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        );

        if (visibility != View.VISIBLE && getResources().getBoolean(R.bool.isTv)) {
            playerView.setUseController(false);
        }
    }

    // Internal methods

    private void initializePlayer() {
        if (player == null) {
            Intent intent = getIntent();
            String action = intent.getAction();
            Uri[] uris;
            String title = "";
            String imageUrl = "";
            String[] extensions;
            if (ACTION_VIEW.equals(action)) {
                uris = new Uri[]{intent.getData()};
                extensions = new String[]{intent.getStringExtra(EXTENSION_EXTRA)};
                title = intent.getStringExtra(TITLE_EXTRA);
                if (intent.hasExtra(IMAGE_EXTRA)) {
                    imageUrl = intent.getStringExtra(IMAGE_EXTRA);
                }
            } else if (ACTION_VIEW_LIST.equals(action)) {
                String[] uriStrings = intent.getStringArrayExtra(URI_LIST_EXTRA);
                uris = new Uri[uriStrings.length];
                for (int i = 0; i < uriStrings.length; i++) {
                    uris[i] = Uri.parse(uriStrings[i]);
                }
                extensions = intent.getStringArrayExtra(EXTENSION_LIST_EXTRA);
                if (extensions == null) {
                    extensions = new String[uriStrings.length];
                }
            } else {
                showToast(getString(R.string.unexpected_intent_action, action));
                finish();
                return;
            }

            TrackSelection.Factory trackSelectionFactory;
            String abrAlgorithm = intent.getStringExtra(ABR_ALGORITHM_EXTRA);
            if (abrAlgorithm == null || ABR_ALGORITHM_DEFAULT.equals(abrAlgorithm)) {
                trackSelectionFactory = new AdaptiveTrackSelection.Factory();
            } else if (ABR_ALGORITHM_RANDOM.equals(abrAlgorithm)) {
                trackSelectionFactory = new RandomTrackSelection.Factory();
            } else {
                showToast(R.string.error_unrecognized_abr_algorithm);
                finish();
                return;
            }

            boolean preferExtensionDecoders =
                    intent.getBooleanExtra(PREFER_EXTENSION_DECODERS_EXTRA, false);
            @DefaultRenderersFactory.ExtensionRendererMode int extensionRendererMode =
                    useExtensionRenderers
                            ? (preferExtensionDecoders ? DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
                            : DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)
                            : DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF;
            DefaultRenderersFactory renderersFactory =
                    new DefaultRenderersFactory(/* context= */ this)
                            .setExtensionRendererMode(extensionRendererMode);

            trackSelector = new DefaultTrackSelector(trackSelectionFactory);
            trackSelector.setParameters(trackSelectorParameters);
            lastSeenTrackGroupArray = null;

            player =
                    new SimpleExoPlayer.Builder(/* context= */ this, renderersFactory)
                            .setTrackSelector(trackSelector)
                            .build();
            player.addListener(new PlayerEventListener());
            player.setPlayWhenReady(startAutoPlay);
            player.addAnalyticsListener(new EventLogger(trackSelector));
            playerView.setPlayer(player);
            playerView.setPlaybackPreparer(this);
            debugViewHelper = new DebugTextViewHelper(player, debugTextView);
            debugViewHelper.start();

            if (castContext != null) {
                playerManager =
                        PlayerManager.createPlayerManager(
                                new PlayerManager.Listener() {
                                    @Override
                                    public void onQueuePositionChanged(int previousIndex, int newIndex) {
                                        Log.d("PlayerActivity", "onQueuePositionChanged");
                                    }

                                    @Override
                                    public void onUnsupportedTrack(int trackType) {

                                    }
                                },
                                playerView,
                                playerControlView,
                                castInfoView,
                                /* context= */ this,
                                castContext,
                                trackSelector);
            }

            MediaSource[] mediaSources = new MediaSource[uris.length];
            for (int i = 0; i < uris.length; i++) {
                mediaSources[i] = buildMediaSource(uris[i], extensions[i]);
            }
            mediaSource =
                    mediaSources.length == 1 ? mediaSources[0] : new ConcatenatingMediaSource(mediaSources);

            if (playerManager != null) {
                playerManager.addItem(
                        new MediaItem.Builder()
                                .setUri(uris[0].toString())
                                .setTitle(title)
                                .setMimeType("video/mp4")
                                .setDrmConfiguration(new MediaItem.DrmConfiguration(
                                        UUID.randomUUID(),
                                        Uri.parse(imageUrl), //Hack to the image url in media item
                                        null
                                ))
                                .build()
                );
            }
        }

        if (playerManager == null) {
            boolean haveStartPosition = startWindow != C.INDEX_UNSET;
            if (haveStartPosition) {
                player.seekTo(startWindow, startPosition);
            }
            player.prepare(mediaSource, !haveStartPosition, false);
        } else {
            playerManager.selectQueueItem(0);
        }
    }

    @SuppressWarnings("unchecked")
    private MediaSource buildMediaSource(Uri uri, @Nullable String overrideExtension) {
        @ContentType int type = Util.inferContentType(uri, overrideExtension);
        switch (type) {
            /*
            case C.TYPE_DASH:
                return new DashMediaSource.Factory(dataSourceFactory)
                        .setManifestParser(
                                new FilteringManifestParser<>(new DashManifestParser(), getOfflineStreamKeys(uri)))
                        .createMediaSource(uri);
            case C.TYPE_SS:
                return new SsMediaSource.Factory(dataSourceFactory)
                        .setManifestParser(
                                new FilteringManifestParser<>(new SsManifestParser(), getOfflineStreamKeys(uri)))
                        .createMediaSource(uri);
            */
            case C.TYPE_HLS:
                return new HlsMediaSource.Factory(dataSourceFactory)
                        .setPlaylistParserFactory(
                                new DefaultHlsPlaylistParserFactory())
                        .createMediaSource(uri);
            case C.TYPE_OTHER:
                return new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
            default: {
                throw new IllegalStateException("Unsupported type: " + type);
            }
        }
    }

    private void releasePlayer() {
        if (player != null) {
            updateTrackSelectorParameters();
            updateStartPosition();
            debugViewHelper.stop();
            debugViewHelper = null;
            if (playerManager != null) {
                playerManager.release();
            }
            player.release();
            player = null;
            mediaSource = null;
            trackSelector = null;
        }
    }

    private void updateTrackSelectorParameters() {
        if (trackSelector != null) {
            trackSelectorParameters = trackSelector.getParameters();
        }
    }

    private void updateStartPosition() {
        if (player != null) {
            startAutoPlay = player.getPlayWhenReady();
            startWindow = player.getCurrentWindowIndex();
            startPosition = Math.max(0, player.getContentPosition());
        }
    }

    private void clearStartPosition() {
        startAutoPlay = true;
        startWindow = C.INDEX_UNSET;
        startPosition = C.TIME_UNSET;
    }

    /**
     * Returns a new DataSource factory.
     */
    private DataSource.Factory buildDataSourceFactory() {
        return new DefaultDataSourceFactory(this, buildHttpDataSourceFactory());
    }

    /**
     * Returns a {@link HttpDataSource.Factory}.
     */
    public HttpDataSource.Factory buildHttpDataSourceFactory() {
        String name = getPackageName();
        String version = "";
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return new DefaultHttpDataSourceFactory(name + "/" + version + " (Linux;Android " + Build.VERSION.RELEASE + ") ");
    }

    // User controls

    private void updateButtonVisibility() {
        selectTracksButton.setEnabled(
                player != null && TrackSelectionDialog.willHaveContent(trackSelector));
    }

    private void showControls() {
        debugRootView.setVisibility(View.VISIBLE);
    }

    private void showToast(int messageId) {
        showToast(getString(messageId));
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private static boolean isBehindLiveWindow(ExoPlaybackException e) {
        if (e.type != ExoPlaybackException.TYPE_SOURCE) {
            return false;
        }
        Throwable cause = e.getSourceException();
        while (cause != null) {
            if (cause instanceof BehindLiveWindowException) {
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }

    private class PlayerEventListener implements Player.EventListener {

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, @Player.State int playbackState) {
            if (playbackState == Player.STATE_ENDED) {
                showControls();
            }
            updateButtonVisibility();
        }

        @Override
        public void onPlayerError(ExoPlaybackException e) {
            if (isBehindLiveWindow(e)) {
                clearStartPosition();
                initializePlayer();
            } else {
                updateButtonVisibility();
                showControls();
            }
        }

        @Override
        @SuppressWarnings("ReferenceEquality")
        public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
            updateButtonVisibility();
            if (trackGroups != lastSeenTrackGroupArray) {
                MappedTrackInfo mappedTrackInfo = trackSelector.getCurrentMappedTrackInfo();
                if (mappedTrackInfo != null) {
                    if (mappedTrackInfo.getTypeSupport(C.TRACK_TYPE_VIDEO)
                            == MappedTrackInfo.RENDERER_SUPPORT_UNSUPPORTED_TRACKS) {
                        showToast(R.string.error_unsupported_video);
                    }
                    if (mappedTrackInfo.getTypeSupport(C.TRACK_TYPE_AUDIO)
                            == MappedTrackInfo.RENDERER_SUPPORT_UNSUPPORTED_TRACKS) {
                        showToast(R.string.error_unsupported_audio);
                    }
                }
                lastSeenTrackGroupArray = trackGroups;
            }
        }
    }

    private class PlayerErrorMessageProvider implements ErrorMessageProvider<ExoPlaybackException> {

        @Override
        public Pair<Integer, String> getErrorMessage(ExoPlaybackException e) {
            String errorString = getString(R.string.error_generic);
            if (e.type == ExoPlaybackException.TYPE_RENDERER) {
                Exception cause = e.getRendererException();
                if (cause instanceof DecoderInitializationException) {
                    // Special case for decoder initialization failures.
                    DecoderInitializationException decoderInitializationException =
                            (DecoderInitializationException) cause;
                    if (decoderInitializationException.codecInfo == null) {
                        if (decoderInitializationException.getCause() instanceof DecoderQueryException) {
                            errorString = getString(R.string.error_querying_decoders);
                        } else if (decoderInitializationException.secureDecoderRequired) {
                            errorString =
                                    getString(
                                            R.string.error_no_secure_decoder, decoderInitializationException.mimeType);
                        } else {
                            errorString =
                                    getString(R.string.error_no_decoder, decoderInitializationException.mimeType);
                        }
                    } else {
                        errorString =
                                getString(
                                        R.string.error_instantiating_decoder,
                                        decoderInitializationException.codecInfo.name);
                    }
                }
            } else if (e.type == ExoPlaybackException.TYPE_SOURCE) {
                IOException cause = e.getSourceException();
                if (cause instanceof HttpDataSource.InvalidResponseCodeException) {
                    HttpDataSource.InvalidResponseCodeException responseCodeException =
                            (HttpDataSource.InvalidResponseCodeException) cause;
                    if (responseCodeException.responseCode == 403) {
                        errorString = getString(R.string.invalid_country);
                    }
                }
            }
            return Pair.create(0, errorString);
        }
    }

}