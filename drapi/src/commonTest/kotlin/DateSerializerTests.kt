package dk.youtec.drapi

import com.soywiz.klock.DateFormat
import com.soywiz.klock.parse
import kotlin.test.Test
import kotlin.test.assertEquals

class DateSerializerTests {

    @Test
    fun testDate1() {
        val df = DateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = df.parse("2018-11-24T19:01:26.2Z").local
        assertEquals(1543082486002L, date.unixMillisLong, "Unix millis wrong")
    }

    @Test
    fun testDate2() {
        val df = DateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val date2 = df.parse("2018-12-23T22:59:00Z").local
        assertEquals(1545602340000L, date2.unixMillisLong, "Unix millis wrong")
    }
}