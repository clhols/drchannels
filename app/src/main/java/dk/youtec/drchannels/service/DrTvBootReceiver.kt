package dk.youtec.drchannels.service

import android.app.job.JobScheduler
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import java.util.concurrent.TimeUnit

class DrTvBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        // If there are not pending jobs. Create a sync job and schedule it.
        val pendingJobs = jobScheduler.allPendingJobs
        if (pendingJobs.isEmpty()) {
            val inputId = context.getSharedPreferences(
                    EpgSyncJobService.PREFERENCE_EPG_SYNC,
                    Context.MODE_PRIVATE)
                    .getString(EpgSyncJobService.BUNDLE_KEY_INPUT_ID, null)

            if (inputId != null) {
                // Set up periodic sync only when input has set up.
                EpgSyncJobService.setUpPeriodicSync(
                        context,
                        inputId,
                        ComponentName(context, DrTvEpgJobService::class.java),
                        TimeUnit.HOURS.toMillis(12),
                        TimeUnit.DAYS.toMillis(6))
            }
            return
        }
        // On L/L-MR1, reschedule the pending jobs.
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
            pendingJobs
                    .filter { it.isPersisted }
                    .forEach { jobScheduler.schedule(it) }
        }
    }
}