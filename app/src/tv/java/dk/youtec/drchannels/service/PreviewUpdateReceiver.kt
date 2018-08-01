package dk.youtec.drchannels.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class PreviewUpdateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("PreviewUpdateReceiver", "Scheduling new preview update from alarm")
        schedulePreviewUpdate()
    }
}