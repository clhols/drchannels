package dk.youtec.drapi

import com.soywiz.klock.PatternDateFormat
import com.soywiz.klock.parse
import kotlin.test.Test
import kotlin.test.assertEquals

class PatternDateFormatTests {

    @Test
    fun testDate1() {
        val df = PatternDateFormat("yyyy-MM-dd'T'HH:mm:ss[.S]'Z'").withOptional()
        val date = df.parse("2018-11-24T19:01:26.2Z").local
        assertEquals(1543086086002L, date.unixMillisLong, "Unix millis wrong")
    }

    @Test
    fun testDate2() {
        val df = PatternDateFormat("yyyy-MM-dd'T'HH:mm:ss[.S]'Z'").withOptional()
        val date = df.parse("2018-11-24T19:01:26Z").local
        assertEquals(1543086086000L, date.unixMillisLong, "Unix millis wrong")
    }

    @Test
    fun testDate3() {
        val df = PatternDateFormat("yyyy-MM-dd'T'HH:mm:ss[.S]'Z'").withOptional()
        val date = df.parse("2018-11-24T19:01:26.555Z").local
        assertEquals(1543086086555L, date.unixMillisLong, "Unix millis wrong")
    }
}