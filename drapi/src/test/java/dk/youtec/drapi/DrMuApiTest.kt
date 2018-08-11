package dk.youtec.drapi

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class DrMuApiTest {
    @Test
    fun testAllActiveDrTvChannels() {
        val channels = runBlocking { service.getAllActiveDrTvChannels().await() }

        val channelIds = channels.map { it.Slug }
        val expectedChannelIds = listOf("dr1", "dr2", "dr3", "dr-k", "dr-ramasjang", "dr-ultra")

        Assert.assertTrue(
                "Didn't find all the following channels $expectedChannelIds"
                , channelIds.containsAll(expectedChannelIds))
    }

    @Test
    fun testScheduleDr1() {
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        val schedule = runBlocking { service.getSchedule("dr1", date).await() }

        Assert.assertEquals("dr1", schedule.ChannelSlug)
    }

    @Test
    fun testSearch() {
        val searchResult = runBlocking { service.search("bonderøven").await() }

        Assert.assertEquals(searchResult.Items.first().SeriesSlug, "bonderoeven-tv")
    }

    @Test
    fun testMostViewed() {
        val mostViewed = runBlocking { service.getMostViewed("", "TV", 6).await() }

        Assert.assertEquals(mostViewed.Items.size, 6)
    }

    private val service
        get(): DrMuApi {
            val converterFactory: Converter.Factory = JacksonConverterFactory.create(
                    ObjectMapper().registerModule(KotlinModule()).apply {
                        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    })
            val callAdapterFactory = CoroutineCallAdapterFactory()

            val retrofit = Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .build()
            return retrofit.create(DrMuApi::class.java)
        }
}