package dk.youtec.drchannels.service

import android.app.job.JobScheduler
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.Data
import com.google.android.media.tv.companionlibrary.EpgSyncJobService
import dk.youtec.drapi.Genre
import dk.youtec.drchannels.R
import dk.youtec.drchannels.preview.*
import dk.youtec.drchannels.util.isTv
import java.util.concurrent.TimeUnit

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class DrTvScheduleJobsReceiver : BroadcastReceiver() {
    private val tag = DrTvScheduleJobsReceiver::class.java.simpleName

    override fun onReceive(context: Context, intent: Intent?) {
        Log.d(tag, "DrTvScheduleJobsReceiver onReceive")
        if (context.isTv()) {
            val inputId = context.getString(R.string.channelInputId)
            val jobScheduler = context.getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler?

            // If there are not pending jobs. Create a sync job and schedule it.
            val pendingJobs = jobScheduler?.allPendingJobs.orEmpty()
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

            with(context) {
                scheduleCurrentProgramsPreviewUpdate()
                schedulePreviewUpdate<MostViewedPreviewUpdater>()
                schedulePreviewUpdate<SearchPreviewUpdater>()
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Sport))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.NaturViden))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.NyhederAktualitet))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Drama))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Dokumentar))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Kultur))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Underholdning))
                schedulePreviewUpdate<GenrePreviewUpdater>(with(Genre.Livsstil))
            }
        }
    }
}

internal fun with(genre: Genre) = Data.Builder().putString("genre", genre.toString()).build()