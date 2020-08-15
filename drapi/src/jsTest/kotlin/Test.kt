package dk.youtec.drapi

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.test.*
import kotlin.test.Test

class Test {
    private val service = DrMuRepository()

    @Test
    fun bar() {
        GlobalScope.promise {
            val channels = service.getAllActiveDrTvChannels()
            assertTrue(channels.count() > 0)
        }
    }
}