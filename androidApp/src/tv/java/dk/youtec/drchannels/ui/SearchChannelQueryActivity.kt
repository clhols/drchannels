package dk.youtec.drchannels.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class SearchChannelQueryActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dialog = SearchChannelQueryDialogFragment()
        dialog.show(supportFragmentManager, "SearchChannelQueryDialogFragment")
    }
}