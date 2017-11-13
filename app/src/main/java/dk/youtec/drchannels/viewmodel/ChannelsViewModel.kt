package dk.youtec.drchannels.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.MainThread
import android.util.Log
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ChannelsViewModel : ViewModel() {
    private val api = DrMuReactiveRepository()
    //private val handler = Handler()
    //private var updateRunnable = Runnable { updateAsync() }

    val channels: MutableLiveData<List<MuNowNext>> = MutableLiveData()

    @MainThread
    fun updateAsync() {
        api.getPageTvFrontObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { pageTvFront ->
                            channels.value = pageTvFront.Live
                        },
                        onError = { e ->
                            Log.e(javaClass.simpleName, e.message, e)
                        })
    }

    /*
    private fun scheduleNextUpdate(epgResult: EpgResult) {
        //Trigger next updateAsync delayed
        val time = if (epgResult.updateNextInSec > 0) epgResult.updateNextInSec * 1000 else 60000
        handler.removeCallbacks(updateRunnable)
        handler.postDelayed(updateRunnable, time)

        //Log the time
        val localDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val nextTime = localDateFormat.format(Date(System.currentTimeMillis() + time))
        Log.d(javaClass.simpleName, "Next updateAsync at " + nextTime)
    }

    fun cancelNextUpdate() {
        handler.removeCallbacks(updateRunnable)
    }

    override fun onCleared() {
        super.onCleared()

        cancelNextUpdate()
    }
    */
}