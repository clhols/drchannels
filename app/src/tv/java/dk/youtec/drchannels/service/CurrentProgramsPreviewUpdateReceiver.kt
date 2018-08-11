package dk.youtec.drchannels.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class CurrentProgramsPreviewUpdateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(CurrentProgramsPreviewUpdateReceiver::class.java.simpleName,
                "Scheduling new current programs preview update from alarm")
        scheduleCurrentProgramsPreviewUpdate()
    }
}