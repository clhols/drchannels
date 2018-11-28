package dk.youtec.drchannels.backend

import android.content.Context
import android.util.Log
import dk.youtec.drapi.*
import dk.youtec.drapi.multiplatform.DrMuRepo
import dk.youtec.drchannels.R
import dk.youtec.drchannels.util.serverDateFormat
import io.reactivex.Single
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.util.Date

class DrMuReactiveRepository(private val context: Context) {
    private val api = DrMuRepository(OkHttpClientFactory.getInstance(context))
    private val api2 = DrMuRepo()

    fun getAllActiveDrTvChannels(): Single<List<Channel>> {
        return Single.create<List<Channel>> { subscriber ->
            try {
                val channels = api.getAllActiveDrTvChannels()
                subscriber.onSuccess(channels)
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    /**
     * @param uri Uri from a [PrimaryAsset] from a [ProgramCard]
     */
    fun getManifest(uri: String): Single<Manifest> {
        return Single.create<Manifest> { subscriber ->
            try {
                val manifest: Manifest? = api.getManifest(uri)
                if (manifest != null) {
                    subscriber.onSuccess(manifest)
                } else {
                    subscriber.onError(DrMuException(context.getString(R.string.missingResponse)))
                }
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
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

                val schedule: Schedule? = api.getSchedule(id, dateString)
                if (schedule != null) {
                    subscriber.onSuccess(schedule)
                } else {
                    subscriber.onError(DrMuException(context.getString(R.string.missingResponse)))
                }
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    fun getScheduleNowNext(): Single<List<dk.youtec.drapi.multiplatform.MuNowNext>> {
        return Single.create<List<dk.youtec.drapi.multiplatform.MuNowNext>> { subscriber ->
            try {
                val schedules: List<dk.youtec.drapi.multiplatform.MuNowNext> = runBlocking { api2.getScheduleNowNext() }
                subscriber.onSuccess(schedules)
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    /**
     * @param id Channel id from [Channel.Slug]
     */
    fun getScheduleNowNext(id: String): Single<MuNowNext> {
        return Single.create<MuNowNext> { subscriber ->
            try {
                val schedule: MuNowNext? = api.getScheduleNowNext(id)
                if (schedule != null) {
                    subscriber.onSuccess(schedule)
                } else {
                    subscriber.onError(DrMuException(context.getString(R.string.missingResponse)))
                }
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    fun getMostViewed(): Single<MostViewed> {
        return Single.create<MostViewed> { subscriber ->
            try {
                val mostViewed: MostViewed = api.getMostViewed() ?: MostViewed(emptyList(), MuPaging(), 0)
                subscriber.onSuccess(mostViewed)
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }

    fun search(query: String): Single<SearchResult> {
        return Single.create<SearchResult> { subscriber ->
            try {
                val searchResult: SearchResult = api.search(query)!!
                subscriber.onSuccess(searchResult)
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3).doOnError { Log.e(javaClass.simpleName, it.message, it) }
    }
}

val Channel.streamingUrl: String
    get() {
        val stream = server!!.Qualities.sortedByDescending { it.Kbps }.first()
                .Streams.first().Stream
        return "${server!!.Server}/$stream"
    }