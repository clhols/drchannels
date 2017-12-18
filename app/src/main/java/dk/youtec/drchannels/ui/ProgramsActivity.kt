package dk.youtec.drchannels.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.adapter.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.*
import java.util.*

class ProgramsActivity : AppCompatActivity() {
    private val api by lazy { DrMuReactiveRepository(this) }
    private val recyclerView by lazy { find<RecyclerView>(R.id.recycler_view) }
    private val toolbarTitle by lazy { find<TextView>(R.id.toolbar_title) }
    private val progressBar by lazy { find<ProgressBar>(R.id.progressBar) }

    companion object {
        val CHANNEL_NAME = "extra_channel_name"
        val CHANNEL_ID = "extra_channel_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programs)

        //Setup toolbar
        val toolbar = find<Toolbar>(R.id.toolbar)
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

    fun loadPrograms() {
        progressBar.visibility = View.VISIBLE
        doAsync {
            val id = intent.extras.get(CHANNEL_ID) as String
            api.getScheduleObservable(id, Date())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onNext = { programs ->
                                progressBar.visibility = View.GONE
                                if (programs != null) {
                                    val currentIndex = programs.Broadcasts.indexOfFirst {
                                        val time = System.currentTimeMillis()
                                        it.StartTime.time <= time && it.EndTime.time >= time
                                    }
                                    recyclerView.adapter = ProgramAdapter(this@ProgramsActivity, id, programs, api)
                                    (recyclerView.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(currentIndex, displayMetrics.heightPixels / 6)
                                }
                            },
                            onError = { e ->
                                toast(
                                    if (e.message != null
                                            && e.message != "Success") e.message!!
                                    else getString(R.string.cantChangeChannel))
                            }
                    )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }
}
