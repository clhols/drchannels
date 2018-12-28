package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.work.WorkerParameters
import dk.youtec.drapi.Genre
import dk.youtec.drchannels.R
import kotlinx.coroutines.runBlocking

@TargetApi(Build.VERSION_CODES.O)
class GenrePreviewUpdater(
        context: Context,
        workerParams: WorkerParameters
) : BasePreviewUpdater(context, workerParams) {
    private val genre = workerParams.inputData.getString("genre") ?: "unknownGenre"
    override val channelKey = "${genre}ChannelId"
    override fun getChannelName(): String = genre
    override fun getPrograms() = runBlocking {
        api.getPageTvPrograms(Genre.getByValue(genre)).Programs.Items
    }
}