package dk.youtec.drchannels.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dk.youtec.drapi.Schedule
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.adapter.ProgramAdapter
import dk.youtec.drchannels.util.serverCalendar
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Singles
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_programs.*
import org.jetbrains.anko.displayMetrics
import org.jetbrains.anko.toast
import java.util.Calendar.*

class ProgramsActivity : AppCompatActivity() {
    private val api by lazy { DrMuReactiveRepository(this) }
    private var selectedGenre: String = ""
    private var genres: Set<String> = setOf()
    private lateinit var programAdapter: ProgramAdapter
    private var disposable: Disposable? = null

    companion object {
        const val CATEGORY_GROUP = 1
        const val CATEGORY_ALL = 100

        const val CHANNEL_NAME = "extra_channel_name"
        const val CHANNEL_ID = "extra_channel_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programs)

        //Setup toolbar
        toolbar.title = ""
        toolbarTitle.text = intent.extras?.getString(CHANNEL_NAME) ?: ""
        setSupportActionBar(toolbar)

        //Setup toolbar up navigation
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.requestFocus()

        val id = intent.extras?.getString(CHANNEL_ID) ?: ""

        loadPrograms(id)
    }

    private fun loadPrograms(id: String) {
        progressBar.isVisible = true

        val scheduleSingle: Single<Schedule> =
                Singles.zip(
                        api.getSchedule(id,
                                serverCalendar {
                                    set(SECOND, 0); set(MINUTE, 0); add(DATE,
                                        1)
                                }.time)
                                .subscribeOn(Schedulers.io()),
                        api.getSchedule(id, serverCalendar { set(SECOND, 0); set(MINUTE, 0) }.time)
                                .subscribeOn(Schedulers.io()),
                        api.getSchedule(id,
                                serverCalendar {
                                    set(SECOND, 0); set(MINUTE, 0); add(DATE,
                                        -1)
                                }.time)
                                .subscribeOn(Schedulers.io()),
                        api.getSchedule(id,
                                serverCalendar {
                                    set(SECOND, 0); set(MINUTE, 0); add(DATE,
                                        -2)
                                }.time)
                                .subscribeOn(Schedulers.io())
                ) { tomorrow, today, yesterday, twoDaysAgo ->
                    Schedule(twoDaysAgo.Broadcasts + yesterday.Broadcasts + today.Broadcasts + tomorrow.Broadcasts,
                            today.BroadcastDate,
                            today.ChannelSlug,
                            today.Channel)
                }

        disposable?.dispose()

        disposable = scheduleSingle
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { schedule ->
                            onScheduleLoaded(schedule)
                        },
                        onError = { e ->
                            onScheduleError(e)
                        }
                )
    }

    private fun onScheduleLoaded(schedule: Schedule) {
        progressBar.isVisible = false

        genres = schedule.Broadcasts
                .asSequence()
                .map { it.OnlineGenreText ?: "" }
                .filter { it.isNotBlank() }
                .toSet()
        invalidateOptionsMenu()

        programAdapter = ProgramAdapter(this, schedule, api)
        recyclerView.adapter = programAdapter
        (recyclerView.layoutManager as LinearLayoutManager)
                .scrollToPositionWithOffset(schedule.Broadcasts.indexOfFirst {
                    it.EndTime.time >= System.currentTimeMillis()
                }, displayMetrics.heightPixels / 6)
    }

    private fun onScheduleError(e: Throwable) {
        toast(if (e.message != null && e.message != "Success") e.message!!
        else getString(R.string.cantChangeChannel))
    }

    override fun onBackPressed() {
        super.onBackPressed()

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onDestroy() {
        super.onDestroy()

        disposable?.dispose()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.menu_programs, menu)

        val filterMenu = menu.findItem(R.id.menu_filter)
        val subMenu = filterMenu.subMenu
        val allItem = subMenu.add(CATEGORY_GROUP, CATEGORY_ALL, Menu.NONE, getString(R.string.all))
        if (selectedGenre == "") {
            allItem.isChecked = true
        }

        for (genre in genres) {
            val item = subMenu.add(CATEGORY_GROUP, Menu.NONE, Menu.NONE, genre)
            if (selectedGenre == genre) {
                item.isChecked = true
            }
        }

        subMenu.setGroupCheckable(CATEGORY_GROUP, true, true)

        return genres.isNotEmpty()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.groupId == CATEGORY_GROUP) {
            item.isChecked = true

            when (CATEGORY_ALL) {
                item.itemId -> selectGenre("")
                else -> selectGenre(item.title.toString())
            }

            return true
        }
        return false
    }

    private fun selectGenre(genre: String) {
        selectedGenre = genre
        programAdapter.setGenreFilter(genre)
        val broadcasts = programAdapter.broadcasts
        val index = broadcasts.indexOfFirst {
            it.EndTime.time >= System.currentTimeMillis()
        }
        if (index >= 0) {
            recyclerView.smoothScrollToPosition(index)
        } else {
            recyclerView.smoothScrollToPosition(broadcasts.size - 1)
        }
    }

}