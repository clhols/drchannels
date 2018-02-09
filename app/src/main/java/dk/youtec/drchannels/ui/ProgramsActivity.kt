package dk.youtec.drchannels.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dk.youtec.drapi.Schedule
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.adapter.ProgramAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_programs.*
import org.jetbrains.anko.displayMetrics
import org.jetbrains.anko.toast
import java.util.*

class ProgramsActivity : AppCompatActivity() {
    private val api by lazy { DrMuReactiveRepository(this) }

    companion object {
        const val CHANNEL_NAME = "extra_channel_name"
        const val CHANNEL_ID = "extra_channel_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programs)

        //Setup toolbar
        toolbar.title = ""
        toolbarTitle.text = intent.extras.get(CHANNEL_NAME) as String
        setSupportActionBar(toolbar)

        //Setup toolbar up navigation
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        loadPrograms()
    }

    private fun loadPrograms() {
        progressBar.visibility = View.VISIBLE

        val id = intent.extras.get(CHANNEL_ID) as String
        api.getScheduleObservable(id, Date())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { programs ->
                            onScheduleLoaded(programs)
                        },
                        onError = { e ->
                            onScheduleError(e)
                        }
                )
    }

    private fun onScheduleLoaded(programs: Schedule) {
        progressBar.visibility = View.GONE
        val currentIndex = programs.Broadcasts.indexOfFirst {
            val time = System.currentTimeMillis()
            it.StartTime.time <= time && it.EndTime.time >= time
        }
        recyclerView.adapter = ProgramAdapter(this, programs, api)
        (recyclerView.layoutManager as LinearLayoutManager)
                .scrollToPositionWithOffset(currentIndex, displayMetrics.heightPixels / 6)
    }

    private fun onScheduleError(e: Throwable) {
        toast(if (e.message != null && e.message != "Success") e.message!!
        else getString(R.string.cantChangeChannel))
    }

    override fun onBackPressed() {
        super.onBackPressed()

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }
}
