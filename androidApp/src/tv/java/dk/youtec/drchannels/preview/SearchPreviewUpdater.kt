package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.tvprovider.media.tv.Channel
import androidx.tvprovider.media.tv.TvContractCompat
import androidx.work.WorkerParameters
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.SearchChannelQueryActivity
import dk.youtec.drchannels.util.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@TargetApi(Build.VERSION_CODES.O)
class SearchPreviewUpdater(
        context: Context,
        workerParams: WorkerParameters
) : BasePreviewUpdater(context, workerParams) {

    private val query = SharedPreferences.getString(context, searchChannelKey, "Tæt på sandheden")
    override val channelKey = "searchChannelId"
    override fun getChannelName(): String = context.getString(R.string.channelSearch)
    override suspend fun getPrograms() = withContext(Dispatchers.IO) {
        var programs = api.search(query).items.sortedByDescending { it.sortDateTime }
        if (programs.isEmpty()) {
            programs = api.search("Program").items.sortedByDescending { it.sortDateTime }
        }
        programs
    }

    override fun buildChannel(): Channel {
        return Channel.Builder().apply {
            setType(TvContractCompat.Channels.TYPE_PREVIEW)
            setDisplayName(getChannelName())
            setAppLinkIntent(Intent(context, SearchChannelQueryActivity::class.java))

        }.build()
    }

    companion object {
        const val searchChannelKey: String = "SEARCH_CHANNEL_KEY"
    }
}