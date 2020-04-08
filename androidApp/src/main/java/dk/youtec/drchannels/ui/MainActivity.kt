package dk.youtec.drchannels.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.onCommit
import androidx.compose.remember
import androidx.compose.state
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.ui.core.setContent
import androidx.ui.foundation.Text

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        //setContentView(R.layout.activity_main)
        setContent {
            Text("Hello, World!")
        }
    }

    // general purpose observe effect. this will likely be provided by LiveData. effect API for
    // compose will also simplify soon.
    @Composable
    fun <T> observe(data: LiveData<T>): T? {
        var result by state { data.value }
        val observer = remember { Observer<T> { result = it } }

        onCommit(data) {
            data.observeForever(observer)
            onDispose { data.removeObserver(observer) }
        }

        return result
    }
}