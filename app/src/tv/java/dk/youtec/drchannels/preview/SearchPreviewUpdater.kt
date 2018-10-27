package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.work.WorkerParameters

@TargetApi(Build.VERSION_CODES.O)
class SearchPreviewUpdater(
        val context: Context,
        workerParams: WorkerParameters
) : BasePreviewUpdater(context, workerParams) {
    private val query = "Tæt på sandheden"
    override val channelKey = "searchChannelId"
    override fun getChannelName(): String = query
    override fun getPrograms() = api.search(query)?.Items ?: emptyList()
}