package dk.youtec.drchannels.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class DrTvInputSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragment = DrTvInputSetupFragment().apply {
            arguments = intent.extras
        }

        fragmentManager.beginTransaction().add(android.R.id.content, fragment).commit()
    }
}