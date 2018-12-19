import dk.youtec.drapi.multiplatform.DrMuRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.test.Test
import kotlin.test.assertTrue

open class DrMuApiTests {
    private val service = DrMuRepo()
    @Test
    fun testApi() {
        GlobalScope.launch {
            val channels = service.getAllActiveDrTvChannels()

            assertTrue(channels.isNotEmpty(), "Was empty")
        }
    }
}