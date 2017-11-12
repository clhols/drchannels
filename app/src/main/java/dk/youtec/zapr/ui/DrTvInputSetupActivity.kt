package dk.youtec.zapr.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dk.youtec.zapr.R
import android.content.ComponentName
import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import android.media.tv.TvInputInfo
import dk.youtec.zapr.service.DrTvEpgJobService
import org.jetbrains.anko.toast

class DrTvInputSetupActivity : AppCompatActivity() {

    private val DEFAULT_SYNC_PERIOD_MILLIS = (1000 * 60 * 60 * 12).toLong() // 12 hour
    private val DEFAULT_PERIODIC_EPG_DURATION_MILLIS = (1000 * 60 * 60 * 24).toLong() // 24 Hour

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setBackgroundDrawableResource(android.R.color.transparent)

        val inputId = intent.getStringExtra(TvInputInfo.EXTRA_INPUT_ID)

        EpgSyncJobService.cancelAllSyncRequests(this)

        EpgSyncJobService.setUpPeriodicSync(
                this,
                inputId,
                ComponentName(this, DrTvEpgJobService::class.java),
                DEFAULT_SYNC_PERIOD_MILLIS,
                DEFAULT_PERIODIC_EPG_DURATION_MILLIS)

        toast(R.string.channels_configured)
        finish()
    }
}