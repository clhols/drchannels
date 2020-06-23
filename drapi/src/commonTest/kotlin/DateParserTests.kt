package dk.youtec.drapi

import kotlin.test.Test
import kotlin.test.assertEquals

class DateParserTests {

    @Test
    fun testDate1() {
        val df = DateParser("YYYY-MM-ddTHH:mm:ss*")
        val date = df.parse("2018-11-24T19:01:26.2Z")
        assertEquals(1543086086000L, date.timestamp, "Unix millis wrong")
    }

    @Test
    fun testDate2() {
        val df = DateParser("YYYY-MM-ddTHH:mm:ss*")
        val date = df.parse("2018-11-24T19:01:26Z")
        assertEquals(1543086086000L, date.timestamp, "Unix millis wrong")
    }

    @Test
    fun testDate3() {
        val df = DateParser("YYYY-MM-ddTHH:mm:ss*")
        val date = df.parse("2018-11-24T19:01:26.555Z")
        assertEquals(1543086086000L, date.timestamp, "Unix millis wrong")
    }
}