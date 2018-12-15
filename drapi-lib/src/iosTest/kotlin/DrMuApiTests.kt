import dk.youtec.drapi.multiplatform.Channel
import dk.youtec.drapi.multiplatform.DrMuRepo
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

open class DrMuApiTests {
    private val service = DrMuRepo()
    @Test
    fun testApi() = runBlocking {
        val channels: List<Channel> = service.getAllActiveDrTvChannels()
        val channelIds = channels.map { it.Slug }
        val expectedChannelIds = listOf("dr1", "dr2", "dr3", "dr-k", "dr-ramasjang", "dr-ultra")

        assertTrue(
                channelIds.containsAll(expectedChannelIds),
                "Didn't find all the following channels $expectedChannelIds")
    }
}