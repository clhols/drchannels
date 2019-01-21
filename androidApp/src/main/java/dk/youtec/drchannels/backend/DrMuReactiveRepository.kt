package dk.youtec.drchannels.backend

import android.content.Context
import android.util.Log
import dk.youtec.drapi.*
import dk.youtec.drapi.Channel
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drchannels.R
import dk.youtec.drchannels.util.serverDateFormat
import io.reactivex.Single
import kotlinx.coroutines.*
import java.io.IOException
import java.util.Date
import kotlin.coroutines.CoroutineContext

class DrMuReactiveRepository(private val context: Context) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val api = DrMuRepository(context.cacheDir.absolutePath)

    fun getAllActiveDrTvChannels(): Single<List<Channel>> {
        return Single.create<List<Channel>> { subscriber ->
            try {
                launch {
                    val channels = withContext(Dispatchers.IO) { api.getAllActiveDrTvChannels() }
                    if (!subscriber.isDisposed) {
                        subscriber.onSuccess(channels)
                    }
                }
            } catch (e: IOException) {
                if (!subscriber.isDisposed) {
                    subscriber.onError(DrMuException(e.message))
                }
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    /**
     * @param uri Uri from a [PrimaryAsset] from a [ProgramCard]
     */
    fun getManifest(uri: String): Single<Manifest> {
        return Single.create<Manifest> { subscriber ->
            try {
                launch {
                    val manifest: Manifest? = withContext(Dispatchers.IO) { api.getManifest(uri) }
                    if (!subscriber.isDisposed) {
                        if (manifest != null) {
                            subscriber.onSuccess(manifest)
                        } else {
                            subscriber.onError(DrMuException(context.getString(R.string.missingResponse)))
                        }
                    }
                }
            } catch (e: IOException) {
                if (!subscriber.isDisposed) {
                    subscriber.onError(DrMuException(e.message))
                }
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    /**
     * @param id Channel id from [Channel.Slug]
     * @param date Day to load schedule from
     */
    fun getSchedule(id: String, date: Date): Single<Schedule> {
        return Single.create<Schedule> { subscriber ->
            try {
                val dateString = serverDateFormat("yyyy-MM-dd HH:mm:ss").format(date)
                launch {
                    val schedule: Schedule? = withContext(Dispatchers.IO) { api.getSchedule(id, dateString) }
                    if (!subscriber.isDisposed) {
                        if (schedule != null) {
                            subscriber.onSuccess(schedule)
                        } else {
                            subscriber.onError(DrMuException(context.getString(R.string.missingResponse)))
                        }
                    }
                }
            } catch (e: IOException) {
                if (!subscriber.isDisposed) {
                    subscriber.onError(DrMuException(e.message))
                }
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    fun getScheduleNowNext(): Single<List<MuNowNext>> {
        return Single.create<List<MuNowNext>> { subscriber ->
            try {
                launch {
                    val schedules: List<MuNowNext> = withContext(Dispatchers.IO) { api.getScheduleNowNext() }
                    if (!subscriber.isDisposed) {
                        subscriber.onSuccess(schedules)
                    }
                }
            } catch (e: IOException) {
                if (!subscriber.isDisposed) {
                    subscriber.onError(DrMuException(e.message))
                }
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    /**
     * @param id Channel id from [Channel.Slug]
     */
    fun getScheduleNowNext(id: String): Single<MuNowNext> {
        return Single.create<MuNowNext> { subscriber ->
            try {
                launch {
                    val schedule: MuNowNext? = withContext(Dispatchers.IO) { api.getScheduleNowNext(id) }
                    if (!subscriber.isDisposed) {
                        if (schedule != null) {
                            subscriber.onSuccess(schedule)
                        } else {
                            subscriber.onError(DrMuException(context.getString(R.string.missingResponse)))
                        }
                    }
                }
            } catch (e: IOException) {
                if (!subscriber.isDisposed) {
                    subscriber.onError(DrMuException(e.message))
                }
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    fun getMostViewed(channel: String, channelType: String, limit: Int): Single<MostViewed> {
        return Single.create<MostViewed> { subscriber ->
            try {
                launch {
                    val mostViewed: MostViewed = withContext(Dispatchers.IO) { api.getMostViewed(channel, channelType, limit) }
                    if (!subscriber.isDisposed) {
                        subscriber.onSuccess(mostViewed)
                    }
                }
            } catch (e: IOException) {
                if (!subscriber.isDisposed) {
                    subscriber.onError(DrMuException(e.message))
                }
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    fun search(query: String): Single<SearchResult> {
        return Single.create<SearchResult> { subscriber ->
            try {
                launch {
                    val searchResult: SearchResult = withContext(Dispatchers.IO) { api.search(query) }
                    if (!subscriber.isDisposed) {
                        subscriber.onSuccess(searchResult)
                    }
                }
            } catch (e: IOException) {
                if (!subscriber.isDisposed) {
                    subscriber.onError(DrMuException(e.message))
                }
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }
}

val Channel.streamingUrl: String
    get() {
        val stream = server()!!.Qualities.sortedByDescending { it.Kbps }.first()
                .Streams.first().Stream
        return "${server()!!.Server}/$stream"
    }