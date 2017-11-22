package dk.youtec.drchannels.backend

import android.content.Context
import dk.youtec.drapi.*
import io.reactivex.Observable
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class DrMuReactiveRepository(context: Context) {
    private var api = DrMuRepository(OkHttpClientFactory.getInstance(context))

    fun getPageTvFrontObservable(): Observable<PageTvFrontResponse> {
        return Observable.create<PageTvFrontResponse> { subscriber ->
            try {
                val pageTvFrontResponse = api.getPageTvFront()
                if (pageTvFrontResponse != null) {
                    subscriber.onNext(pageTvFrontResponse)
                    subscriber.onComplete()
                } else {
                    subscriber.onError(DrMuException("Missing page tv front response"))
                }
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3)
    }

    fun getAllActiveDrTvChannelsObservable(): Observable<List<Channel>> {
        return Observable.create<List<Channel>> { subscriber ->
            try {
                val channels = api.getAllActiveDrTvChannels()
                subscriber.onNext(channels)
                subscriber.onComplete()
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3)
    }

    fun getManifestObservable(uri: String): Observable<Manifest> {
        return Observable.create<Manifest> { subscriber ->
            try {
                val manifest: Manifest? = api.getManifest(uri)
                if (manifest != null) {
                    subscriber.onNext(manifest)
                    subscriber.onComplete()
                } else {
                    subscriber.onError(DrMuException("Missing response"))
                }
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3)
    }

    fun getScheduleObservable(id: String, date: Date): Observable<Schedule> {
        return Observable.create<Schedule> { subscriber ->
            try {
                val dateString = SimpleDateFormat("yyyy-MM-dd HH:MM:ss", Locale.GERMAN)
                        .format(date)

                val schedule: Schedule? = api.getSchedule(id, dateString)
                if (schedule != null) {
                    subscriber.onNext(schedule)
                    subscriber.onComplete()
                } else {
                    subscriber.onError(DrMuException("Missing response"))
                }
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3)
    }

    fun getScheduleNowNextObservable(): Observable<List<MuNowNext>> {
        return Observable.create<List<MuNowNext>> { subscriber ->
            try {
                val schedules: List<MuNowNext> = api.getScheduleNowNext()
                subscriber.onNext(schedules)
                subscriber.onComplete()
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3)
    }

    fun getScheduleNowNextObservable(id: String): Observable<MuNowNext> {
        return Observable.create<MuNowNext> { subscriber ->
            try {
                val schedule: MuNowNext? = api.getScheduleNowNext(id)
                if (schedule != null) {
                    subscriber.onNext(schedule)
                    subscriber.onComplete()
                } else {
                    subscriber.onError(DrMuException("Missing response"))
                }
            } catch (e: IOException) {
                subscriber.onError(DrMuException(e.message))
            }
        }.retry(3)
    }
}

val Channel.streamingUrl: String
    get() {
        val server = StreamingServers.first { it.LinkType == "HLS" }
        val stream = server.Qualities.sortedByDescending { it.Kbps }.first()
                .Streams.first().Stream
        return "${server.Server}/$stream"
    }