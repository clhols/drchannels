package dk.youtec.drapi

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * Implements a Java API for https://www.dr.dk/mu-online/Help/1.4
 */
class DrMuRepository @JvmOverloads constructor(client: OkHttpClient? = null) {
    private val service: DrMuApi

    init {
        val retrofit = with(Retrofit.Builder()) {
            baseUrl(API_URL)
            addConverterFactory(
                    JacksonConverterFactory.create(
                            ObjectMapper().registerModule(KotlinModule()).apply {
                                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                            }))
            client?.let { client(it) }
            build()
        }

        service = retrofit.create<DrMuApi>(DrMuApi::class.java)
    }

    /**
     * Gets channels
     */
    fun getAllActiveDrTvChannels(): List<Channel> {
        val response: Response<List<Channel>> = service.getAllActiveDrTvChannels().execute()
        return response.body().orEmpty()
    }

    /**
     * @param uri Uri from a [PrimaryAsset] from a [ProgramCard]
     */
    fun getManifest(uri: String): Manifest? {
        val response: Response<Manifest> = service.getManifest(uri.removePrefix(API_URL)).execute()
        return response.body()
    }

    /**
     * Gets Now and Next information from all active channels.
     */
    fun getScheduleNowNext(): List<MuNowNext> {
        val response: Response<List<MuNowNext>> = service.getScheduleNowNext().execute()
        return response.body().orEmpty()
    }

    /**
     * Gets Now and Next information from a single channel.
     * @param id Channel id from [Channel.Slug]
     */
    fun getScheduleNowNext(id: String): MuNowNext? {
        val response: Response<MuNowNext> = service.getScheduleNowNext(id).execute()
        return response.body()
    }

    /**
     * Gets Broadcasts from a single channel on a specific day.
     * @param id Channel id from [Channel.Slug]
     * @param date Day to load schedule from
     */
    fun getSchedule(id: String, date: String): Schedule? {
        val response: Response<Schedule> = service.getSchedule(id, date).execute()
        return response.body()
    }

    fun search(query: String): SearchResult? {
        val response: Response<SearchResult> = service.search(query).execute()
        return response.body()
    }

    fun getMostViewed(): MostViewed? {
        val response = service.getMostViewed("", "TV", 10).execute()
        return response.body()
    }
}