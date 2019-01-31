package dk.youtec.drchannels.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.Schedule
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.adapter.ProgramAdapter
import dk.youtec.drchannels.util.serverCalendar
import dk.youtec.drchannels.util.serverDateFormat
import kotlinx.android.synthetic.main.activity_programs.*
import kotlinx.coroutines.*
import org.jetbrains.anko.displayMetrics
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject
import java.lang.Exception
import java.util.Calendar.*
import kotlin.coroutines.CoroutineContext

class ProgramsActivity : AppCompatActivity(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private val api: DrMuRepository by inject()
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

    private fun java.util.Date.format(): String {
        return serverDateFormat("yyyy-MM-dd HH:mm:ss").format(this)
    }

    private fun loadPrograms(id: String) {
        progressBar.isVisible = true

        try {
            launch {
                val tomorrowDeferred = async(Dispatchers.IO) {
                    api.getSchedule(id, serverCalendar {
                        set(SECOND, 0); set(MINUTE, 0); add(DATE, 1)
                    }.time.format())
                }
                val todayDeferred = async(Dispatchers.IO) {
                    api.getSchedule(id, serverCalendar {
                        set(SECOND, 0); set(MINUTE, 0)
                    }.time.format())
                }
                val yesterdayDeferred = async(Dispatchers.IO) {
                    api.getSchedule(id,
                            serverCalendar {
                                set(SECOND, 0); set(MINUTE, 0); add(DATE, -1)
                            }.time.format())
                }
                val twoDaysAgoDeferred = async(Dispatchers.IO) {
                    api.getSchedule(id,
                            serverCalendar {
                                set(SECOND, 0); set(MINUTE, 0); add(DATE, -2)
                            }.time.format())
                }

                onScheduleLoaded(
                        Schedule(
                                (twoDaysAgoDeferred.await().Broadcasts +
                                        yesterdayDeferred.await().Broadcasts +
                                        todayDeferred.await().Broadcasts +
                                        tomorrowDeferred.await().Broadcasts),
                                todayDeferred.await().BroadcastDate,
                                todayDeferred.await().ChannelSlug,
                                todayDeferred.await().Channel
                        ))
            }
        } catch (e: Exception) {
            onScheduleError(e)
        }
    }

    private fun onScheduleLoaded(schedule: Schedule) {
        progressBar.isVisible = false

        genres = schedule.Broadcasts
                .asSequence()
                .map { it.OnlineGenreText ?: "" }
                .filter { it.isNotBlank() }
                .toSet()
        invalidateOptionsMenu()

        programAdapter = ProgramAdapter(this, schedule)
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

        job.cancel()
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