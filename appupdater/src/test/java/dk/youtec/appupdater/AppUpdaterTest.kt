package dk.youtec.appupdater

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

open class AppUpdaterTest {

    @Test
    fun testParser() {
        val metaString = String(File("src/test/java/dk/youtec/appupdater/meta.json").readBytes())

        val versionCode = extractVersionCode(metaString)

        assertEquals(1811011803, versionCode)
    }
}