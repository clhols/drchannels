package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.work.WorkerParameters
import dk.youtec.drchannels.R
import kotlinx.coroutines.runBlocking

@TargetApi(Build.VERSION_CODES.O)
class MostViewedPreviewUpdater(
        context: Context,
        workerParams: WorkerParameters
) : BasePreviewUpdater(context, workerParams) {
    override val channelKey = "mostViewedChannelId"
    override fun getChannelName(): String = context.getString(R.string.mostViewed)
    override fun getPrograms() = runBlocking {
        api.getMostViewed("", "TV", 10).Items
    }
}