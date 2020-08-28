package dk.youtec.drchannels.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dk.youtec.drchannels.R

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}