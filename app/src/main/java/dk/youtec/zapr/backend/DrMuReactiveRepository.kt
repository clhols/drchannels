package dk.youtec.zapr.backend

import dk.youtec.drapi.*
import io.reactivex.Observable
import java.io.IOException

class DrMuReactiveRepository {
    private var api = DrMuRepository()

    fun getPageTvFrontObservable(): Observable<PageTvFrontResponse> {
        return Observable.create<PageTvFrontResponse> { subscriber ->
            val pageTvFrontResponse = api.getPageTvFront()
            if (pageTvFrontResponse != null) {
                subscriber.onNext(pageTvFrontResponse)
                subscriber.onComplete()
            } else {
                subscriber.onError(DrMuException("Missing page tv front response"))
            }
        }
    }

    fun getAllActiveDrTvChannelsObservable(): Observable<List<Channel>> {
        return Observable.create<List<Channel>> { subscriber ->
            val channels = api.getAllActiveDrTvChannels()
            subscriber.onNext(channels)
            subscriber.onComplete()
        }
    }

    fun getManifestObservable(uri: String): Observable<Manifest> {
        return Observable.create<Manifest> { subscriber ->
            val manifest: Manifest? = api.getManifest(uri)
            if (manifest != null) {
                subscriber.onNext(manifest)
                subscriber.onComplete()
            } else {
                subscriber.onError(IOException("Missing response"))
            }
        }
    }
}

val Channel.streamingUrl: String
    get() {
        val server = StreamingServers.first { it.LinkType == "HLS" }
        val stream = server.Qualities.sortedByDescending { it.Kbps }.first().Streams.first().Stream
        return "${server.Server}/$stream"
    }