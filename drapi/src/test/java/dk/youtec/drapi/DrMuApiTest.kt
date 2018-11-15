package dk.youtec.drapi

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert
import org.junit.Test
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class DrMuApiTest {

    @Test
    fun testAllActiveDrTvChannels() {
        val response: Response<List<Channel>> = service.getAllActiveDrTvChannels().execute()
        val channels = response.body()

        val channelIds = channels?.map { it.Slug }.orEmpty()
        val expectedChannelIds = listOf("dr1", "dr2", "dr3", "dr-k", "dr-ramasjang", "dr-ultra")

        Assert.assertTrue(
                "Didn't find all the following channels $expectedChannelIds"
                , channelIds.containsAll(expectedChannelIds))
    }

    @Test
    fun testScheduleDr1() {
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        val response: Response<Schedule> = service.getSchedule(
                "dr1",
                date).execute()
        val schedule = response.body()

        Assert.assertEquals("dr1", schedule?.ChannelSlug)
    }

    @Test
    fun testSearch() {
        val response: Response<SearchResult> = service.search("bonderøven").execute()
        val searchResult = response.body()

        Assert.assertEquals(searchResult?.Items?.first()?.SeriesSlug, "bonderoeven-tv")
    }

    @Test
    fun testMostViewed() {
        val response: Response<MostViewed> = service.getMostViewed("", "TV", 10).execute()
        val searchResult = response.body()

        Assert.assertEquals(searchResult?.Items?.size, 10)
    }

    private val service
        get(): DrMuApi {
            val converterFactory: Converter.Factory = JacksonConverterFactory.create(
                    ObjectMapper().registerModule(KotlinModule()).apply {
                        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    })

            val retrofit = Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(converterFactory)
                    .build()
            return retrofit.create(DrMuApi::class.java)
        }
}