package dk.youtec.drchannels.service

import android.app.job.JobScheduler
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.content.Intent
import android.os.Build
import android.util.Log
import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import dk.youtec.drchannels.R
import dk.youtec.drchannels.util.isTv
import java.util.concurrent.TimeUnit

class DrTvBootReceiver : BroadcastReceiver() {
    private val tag = "DrTvBootReceiver"

    override fun onReceive(context: Context, intent: Intent?) {
        if (context.isTv()) {
            val inputId = context.getString(R.string.channelInputId)
            val jobScheduler = context.getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler?

            // If there are not pending jobs. Create a sync job and schedule it.
            val pendingJobs = jobScheduler?.allPendingJobs ?: emptyList()
            if (pendingJobs.isEmpty()) {
                Log.v(tag, "No pending jobs")

                Log.v(tag, "Calling EpgSyncJobService.setUpPeriodicSync")
                // Set up periodic sync only when input has set up.
                EpgSyncJobService.setUpPeriodicSync(
                        context,
                        inputId,
                        ComponentName(context, DrTvEpgJobService::class.java),
                        TimeUnit.HOURS.toMillis(12),
                        TimeUnit.DAYS.toMillis(6))
            } else {
                // On L/L-MR1, reschedule the pending jobs.
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
                    pendingJobs
                            .filter { it.isPersisted }
                            .forEach { jobScheduler?.schedule(it) }
                } else {
                    pendingJobs
                            .forEach {
                                Log.v(tag, "Pending jobs: $it")
                            }
                }
            }

            scheduleCurrentProgramsPreviewUpdate()
        }
    }
}