package dk.youtec.drchannels

import androidx.test.ext.junit.runners.AndroidJUnit4
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.Genre
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class DrMuRepositoryTest {
    @Test
    fun testSearch() = runBlocking {
        val title = "Film"
        val searchResult = DrMuRepository().search(title)

        assertTrue(searchResult.Items.isNotEmpty())
    }
    @Test
    fun testGenre() = runBlocking {
        val searchResult = DrMuRepository().getPageTvPrograms(Genre.Sport)

        assertTrue(searchResult.Programs.Items.isNotEmpty())
    }
}