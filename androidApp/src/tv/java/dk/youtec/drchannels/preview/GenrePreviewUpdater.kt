package dk.youtec.drchannels.preview

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.work.WorkerParameters
import dk.youtec.drapi.Genre
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@TargetApi(Build.VERSION_CODES.O)
class GenrePreviewUpdater(
        context: Context,
        workerParams: WorkerParameters
) : BasePreviewUpdater(context, workerParams) {
    private val genre = workerParams.inputData.getString("genre") ?: "unknownGenre"
    override val channelKey = "${genre}ChannelId"
    override fun getChannelName(): String = genre
    override suspend fun getPrograms() = withContext(Dispatchers.IO) {
        api.getPageTvPrograms(Genre.getByValue(genre)).Programs.Items
    }
}