package dk.youtec.drchannels.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drapi.Schedule
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.adapter.ProgramAdapter
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.Calendar.DATE

class ProgramsActivity : AppCompatActivity() {
    private val api by lazy { DrMuReactiveRepository(this) }
    private var selectedGenre: String = ""
    private var genres: Set<String> = setOf()
    private lateinit var programAdapter: ProgramAdapter

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
        toolbarTitle.text = intent.extras.get(CHANNEL_NAME) as String
        setSupportActionBar(toolbar)

        //Setup toolbar up navigation
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.requestFocus()

        loadPrograms()
    }

    private fun loadPrograms() {
        progressBar.isVisible = true

        val id = intent.extras.get(CHANNEL_ID) as String

        val scheduleObservable: Observable<Schedule> =
                Observables.combineLatest(
                        api.getScheduleObservable(id, calendar { add(DATE, 1) }.time),
                        api.getScheduleObservable(id, Date()),
                        api.getScheduleObservable(id, calendar { add(DATE, -1) }.time),
                        api.getScheduleObservable(id, calendar { add(DATE, -2) }.time)
                ) { tomorrow, today, yesterday, twoDaysAgo ->
                    val broadcasts = mutableListOf<MuScheduleBroadcast>().apply {
                        addAll(twoDaysAgo.Broadcasts)
                        addAll(yesterday.Broadcasts)
                        addAll(today.Broadcasts)
                        addAll(tomorrow.Broadcasts)
                    }

                    Schedule(broadcasts, today.BroadcastDate, today.ChannelSlug, today.Channel)
                }

        scheduleObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { schedule ->
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
                .map { it.OnlineGenreText ?: "" }
                .filter { it.isNotBlank() == true }
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
                item.itemId -> {
                    selectGenre("")
                }
                else -> {
                    selectGenre(item.title.toString())
                }
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

inline fun calendar(block: Calendar.() -> Unit = {}): Calendar = Calendar.getInstance().apply(block)