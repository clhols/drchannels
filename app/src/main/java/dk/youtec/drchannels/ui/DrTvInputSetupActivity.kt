package dk.youtec.drchannels.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dk.youtec.drchannels.R
import android.content.ComponentName
import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import android.media.tv.TvInputInfo
import dk.youtec.drchannels.service.DrTvEpgJobService
import org.jetbrains.anko.toast

class DrTvInputSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragment = DrTvInputSetupFragment()
        fragment.setArguments(intent.extras)
        fragmentManager.beginTransaction().add(android.R.id.content, fragment).commit()
    }
}