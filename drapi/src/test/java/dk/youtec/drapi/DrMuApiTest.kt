package dk.youtec.drapi

import org.junit.Assert
import org.junit.Test
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class DrMuApiTest {
    @Test
    fun testPageTvFront() {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<DrMuApi>(DrMuApi::class.java)

        val response: Response<PageTvFrontResponse> = service.getPageTvFront().execute()
        val liveResponse = response.body()
        val channels = liveResponse?.Live ?: emptyList()

        val channelIds = channels.map { it.ChannelSlug }
        val expectedChannelIds = listOf("dr1", "dr2", "dr3", "dr-k", "dr-ramasjang", "dr-ultra")

        Assert.assertEquals(expectedChannelIds, channelIds)

        println("Primary asset uri ${channels[0].Now?.ProgramCard?.PrimaryAsset?.Uri}")
        println("Date ${SimpleDateFormat("dd-MM-yyyy HH:mm").format(channels[0].Now?.StartTime)}")
    }

    @Test
    fun testAllActiveDrTvChannels() {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<DrMuApi>(DrMuApi::class.java)

        val response: Response<List<Channel>> = service.getAllActiveDrTvChannels().execute()
        val channels = response.body()

        val channelIds = channels?.map { it.Slug } ?: emptyList()
        val expectedChannelIds = listOf("dr1", "dr2", "dr3", "dr-k", "dr-ramasjang", "dr-ultra")

        Assert.assertTrue(
                "Didn't find all the following channels $expectedChannelIds"
                , channelIds.containsAll(expectedChannelIds))
    }

    @Test
    fun testScheduleDr1() {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<DrMuApi>(DrMuApi::class.java)

        val date = SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(Date())
        val response: Response<Schedule> = service.getSchedule(
                "dr1",
                date).execute()
        val schedule = response.body()

        Assert.assertEquals(schedule?.ChannelSlug, "dr1")
    }

    @Test
    fun testSearch() {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<DrMuApi>(DrMuApi::class.java)

        val response: Response<SearchResult> = service.search("bonderøven").execute()
        val searchResult = response.body()

        Assert.assertEquals(searchResult?.Items?.first()?.SeriesSlug, "bonderoeven-tv")
    }
}