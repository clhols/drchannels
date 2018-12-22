package dk.youtec.drapi.multiplatform

import com.soywiz.klock.DateFormat
import com.soywiz.klock.parse
import kotlin.test.Test
import kotlin.test.assertTrue

class DateSerializerTests {

    @Test
    fun testDate() {
        var df = DateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = df.parse("2018-11-24T19:01:26.2Z").local
        assertTrue { date.unixMillisLong == 1543082486002L }

        df = DateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val date2 = df.parse("2018-12-23T22:59:00Z").local
        assertTrue { date2.unixMillisLong == 1545602340000L }
    }
}