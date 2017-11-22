package dk.youtec.drchannels.backend

import android.content.Context
import dk.youtec.drapi.*
import io.reactivex.Observable

class DrMuReactiveRepository(context: Context) {
    private var api = DrMuRepository(OkHttpClientFactory.getInstance(context))

    fun getPageTvFrontObservable(): Observable<PageTvFrontResponse> {
        return Observable.create<PageTvFrontResponse> { subscriber ->
            val pageTvFrontResponse = api.getPageTvFront()
            if (pageTvFrontResponse != null) {
                subscriber.onNext(pageTvFrontResponse)
                subscriber.onComplete()
            } else {
                subscriber.onError(DrMuException("Missing page tv front response"))
            }
        }.retry(3)
    }

    fun getAllActiveDrTvChannelsObservable(): Observable<List<Channel>> {
        return Observable.create<List<Channel>> { subscriber ->
            val channels = api.getAllActiveDrTvChannels()
            subscriber.onNext(channels)
            subscriber.onComplete()
        }.retry(3)
    }

    fun getManifestObservable(uri: String): Observable<Manifest> {
        return Observable.create<Manifest> { subscriber ->
            val manifest: Manifest? = api.getManifest(uri)
            if (manifest != null) {
                subscriber.onNext(manifest)
                subscriber.onComplete()
            } else {
                subscriber.onError(DrMuException("Missing response"))
            }
        }.retry(3)
    }
}

val Channel.streamingUrl: String
    get() {
        val server = StreamingServers.first { it.LinkType == "HLS" }
        val stream = server.Qualities.sortedByDescending { it.Kbps }.first().Streams.first().Stream
        return "${server.Server}/$stream"
    }