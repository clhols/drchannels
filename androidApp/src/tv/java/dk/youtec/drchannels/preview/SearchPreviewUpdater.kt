package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.work.WorkerParameters
import kotlinx.coroutines.runBlocking

@TargetApi(Build.VERSION_CODES.O)
class SearchPreviewUpdater(
        context: Context,
        workerParams: WorkerParameters
) : BasePreviewUpdater(context, workerParams) {
    private val query = "Tæt på sandheden"
    override val channelKey = "searchChannelId"
    override fun getChannelName(): String = query
    override fun getPrograms() = runBlocking {
        api.search(query).Items
    }
}