package dk.youtec.drchannels.ui

import android.app.Activity
import android.content.ComponentName
import android.media.tv.TvInputInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.media.tv.companionlibrary.ChannelSetupFragment
import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import dk.youtec.drchannels.R
import dk.youtec.drchannels.service.DrTvEpgJobService
import dk.youtec.drchannels.service.schedulePreviewUpdate
import org.jetbrains.anko.toast
import java.util.concurrent.TimeUnit

class DrTvInputSetupFragment: ChannelSetupFragment() {
    private lateinit var extraInputId: String
    private var scanErrorReason: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        extraInputId = arguments.getString(TvInputInfo.EXTRA_INPUT_ID)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        setButtonText(R.string.cancel)
        setChannelListVisibility(true)
        setDescription(R.string.loading)
        setTitle(R.string.app_name)
        return view
    }

    override fun onScanStarted() {
        EpgSyncJobService.cancelAllSyncRequests(activity)

        EpgSyncJobService.requestImmediateSync(
                activity,
                inputId,
                TimeUnit.DAYS.toMillis(6),
                ComponentName(activity, DrTvEpgJobService::class.java)
        )
    }

    override fun getInputId(): String = extraInputId

    override fun onScanFinished() {
        EpgSyncJobService.cancelAllSyncRequests(activity)

        EpgSyncJobService.setUpPeriodicSync(
                activity,
                inputId,
                ComponentName(activity, DrTvEpgJobService::class.java),
                TimeUnit.HOURS.toMillis(12),
                TimeUnit.DAYS.toMillis(6))

        if (scanErrorReason != null) {
            activity.setResult(Activity.RESULT_CANCELED)
            toast(R.string.error_setup_channels)
        } else {
            activity.setResult(Activity.RESULT_OK)
        }
        activity.finish()

        //Start Live Channels app after channel scan
        activity.packageManager.getLaunchIntentForPackage("com.google.android.tv")?.also {
            startActivity(it)
        }
    }

    override fun onScanError(reason: Int) {
        super.onScanError(reason)

        scanErrorReason = reason
    }
}