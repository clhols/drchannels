package dk.youtec.drchannels.ui

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import dk.youtec.drchannels.R
import dk.youtec.drchannels.preview.SearchPreviewUpdater
import dk.youtec.drchannels.preview.schedulePreviewUpdate
import dk.youtec.drchannels.util.SharedPreferences

class SearchChannelQueryDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_search_channel_query, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.let {
            val queryEditText = view.findViewById<EditText>(R.id.query)
            queryEditText.setText(SharedPreferences.getString(it, SearchPreviewUpdater.searchChannelKey))
            queryEditText.setOnEditorActionListener { textView: TextView, _: Int, _: KeyEvent? ->
                SharedPreferences.setString(it, SearchPreviewUpdater.searchChannelKey, textView.text.toString())
                it.schedulePreviewUpdate<SearchPreviewUpdater>()
                it.finish()
                true
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        activity?.finish()
    }
}