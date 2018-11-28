import dk.youtec.drapi.multiplatform.Channel
import dk.youtec.drapi.multiplatform.DrMuRepo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DrMuRepoTests {
    private val service = DrMuRepo()

    @Test
    fun testAllActiveDrTvChannels() = runBlocking {
        val channels: List<Channel> = service.getAllActiveDrTvChannels()

        val channelIds = channels.map { it.Slug }
        val expectedChannelIds = listOf("dr1", "dr2", "dr3", "dr-k", "dr-ramasjang", "dr-ultra")

        assertTrue(
                channelIds.containsAll(expectedChannelIds),
                "Didn't find all the following channels $expectedChannelIds")
    }

    @Test
    fun testScheduleDr1() = runBlocking {
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        val schedule = service.getSchedule("dr1", date)

        assertEquals("dr1", schedule.ChannelSlug)
    }

    @Test
    fun testSearch() = runBlocking {
        val searchResult = service.search("bonderøven")

        assertEquals(searchResult.Items.first().SeriesSlug, "bonderoeven-tv")
    }

    @Test
    fun testMostViewed() = runBlocking {
        val searchResult = service.getMostViewed("", "TV", 10)

        assertEquals(searchResult.Items.size, 10)
    }
}