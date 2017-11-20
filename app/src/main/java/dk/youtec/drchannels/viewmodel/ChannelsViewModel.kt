package dk.youtec.drchannels.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.content.Context
import android.support.annotation.MainThread
import android.util.Log
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.TimeUnit

class ChannelsViewModel(application: Application) : AndroidViewModel(application) {
    val channels: ChannelsLiveData = ChannelsLiveData(application)
}

class ChannelsLiveData(context: Context): LiveData<List<MuNowNext>>() {
    private val api = DrMuReactiveRepository(context)
    private var refreshJob: Job? = null

    init {
        load()
    }

    @MainThread
    fun load() {
        api.getPageTvFrontObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { pageTvFront ->
                            value = pageTvFront.Live
                        },
                        onError = { e ->
                            Log.e(javaClass.simpleName, e.message, e)
                        })
    }

    override fun onActive() {
        refreshJob = launch(UI) {
            while (true) {
                delay(30, TimeUnit.SECONDS)
                load()
            }
        }
    }

    override fun onInactive() {
        refreshJob?.cancel()
    }
}