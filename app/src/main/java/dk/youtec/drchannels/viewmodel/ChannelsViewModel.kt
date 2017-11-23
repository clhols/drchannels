package dk.youtec.drchannels.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.content.Context
import android.util.Log
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import io.reactivex.Observable

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
                .switchMap { api.getScheduleNowNextObservable() }
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.filter { it.Now != null } }
                .doOnNext { Log.v(javaClass.simpleName, "Got channel data") }
                .subscribe({ value = it })
    }

    /**
     * Disposes the current subscription
     */
    fun dispose() {
        if (subscription?.isDisposed == false) {
            subscription?.dispose()
        }
    }

    override fun onActive() {
        subscribe()
    }

    override fun onInactive() {
        dispose()
    }
}