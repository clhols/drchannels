import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.assertTrue

class DateSerializerTests {

    @Test
    fun testDate() {
        var df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val date = df.parse("2018-11-24T19:01:26.2Z")
        assertTrue { date != null }

        df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        val date2 = df.parse("2018-12-23T22:59:00Z")
        assertTrue { date2 != null }
    }
}