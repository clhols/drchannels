package dk.youtec.drchannels.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.Keep
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import dk.youtec.drapi.multiplatform.MuNowNext
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@Keep
class ChannelsViewModel(application: Application) : AndroidViewModel(application) {
    val channels: ChannelsLiveData = ChannelsLiveData(application)

    override fun onCleared() {
        channels.dispose()
    }
}

class ChannelsLiveData(context: Context) : LiveData<List<MuNowNext>>() {
    private val api = DrMuReactiveRepository(context)
    private var subscription: Disposable? = null

    /**
     * Subscribe to an internal observable that trigger the network request
     */
    fun subscribe() {
        Log.v(javaClass.simpleName, "Subscribing for channel data")

        dispose()

        subscription = Observable.interval(0, 30, TimeUnit.SECONDS, Schedulers.io())
                .switchMap { api.getScheduleNowNext().toObservable() }
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.filter { it.Now != null } }
                .doOnNext { Log.v(javaClass.simpleName, "Got channel data") }
                .doOnError { Log.e(javaClass.simpleName, "Unable to get channel data") }
                .subscribeBy(
                        onNext = { value = it },
                        onError = { value = emptyList() })
    }

    /**
     * Disposes the current subscription
     */
    fun dispose() {
        if (subscription?.isDisposed == false) {
            subscription?.dispose()
        }
    }

    override fun getValue(): List<MuNowNext> {
        return super.getValue().orEmpty()
    }

    override fun onActive() {
        subscribe()
    }

    override fun onInactive() {
        dispose()
    }
}