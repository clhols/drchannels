import dk.youtec.drapi.Channel
import dk.youtec.drapi.DrMuRepository
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DrMuRepoTests {
    private val service = DrMuRepository()

    @Test
    fun testAllActiveDrTvChannels() = runBlocking {
        val channels: List<Channel> = service.getAllActiveDrTvChannels()

        val channelIds = channels.map { it.slug }
        val expectedChannelIds = listOf("dr1", "dr2", "dr3", "dr-k", "dr-ramasjang", "dr-ultra")

        assertTrue(
                channelIds.containsAll(expectedChannelIds),
                "Didn't find all the following channels $expectedChannelIds")
    }

    @Test
    fun testScheduleNowNext() = runBlocking {
        val schedules = service.getScheduleNowNext()

        assertTrue(schedules.isNotEmpty())
    }

    @Test
    fun testScheduleDr1() = runBlocking {
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        val schedule = service.getSchedule("dr1", date)

        assertEquals("dr1", schedule.channelSlug)
    }

    @Test
    fun testSearch() = runBlocking {
        val searchResult = service.search("bonderøven")

        assertEquals(searchResult.items.first().seriesSlug, "bonderoeven-tv")
    }

    @Test
    fun testMostViewed() = runBlocking {
        val searchResult = service.getMostViewed("", "TV", 10)

        assertEquals(searchResult.items.size, 10)
    }
}