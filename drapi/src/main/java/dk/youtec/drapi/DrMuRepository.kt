package dk.youtec.drapi

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.CommonPool
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
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
            addCallAdapterFactory(CoroutineCallAdapterFactory())
            client?.let { client(it) }
            build()
        }

        service = retrofit.create<DrMuApi>(DrMuApi::class.java)
    }

    /**
     * Gets channels
     */
    fun getAllActiveDrTvChannels(): List<Channel> = runBlocking(CommonPool) {
        service.getAllActiveDrTvChannels().await()
    }

    /**
     * @param uri Uri from a [PrimaryAsset] from a [ProgramCard]
     */
    fun getManifest(uri: String): Manifest = runBlocking(CommonPool) {
        service.getManifest(uri.removePrefix(API_URL)).await()
    }

    /**
     * Gets Now and Next information from all active channels.
     */
    fun getScheduleNowNext(): List<MuNowNext> = runBlocking(CommonPool) {
        service.getScheduleNowNext().await()
    }

    /**
     * Gets Now and Next information from a single channel.
     * @param id Channel id from [Channel.Slug]
     */
    fun getScheduleNowNext(id: String): MuNowNext = runBlocking(CommonPool) {
        service.getScheduleNowNext(id).await()
    }

    /**
     * Gets Broadcasts from a single channel on a specific day.
     * @param id Channel id from [Channel.Slug]
     * @param date Day to load schedule from
     */
    fun getSchedule(id: String, date: String): Schedule = runBlocking(CommonPool) {
        service.getSchedule(id, date).await()
    }

    fun search(query: String): SearchResult = runBlocking(CommonPool) {
        service.search(query).await()
    }

    fun getMostViewed(): MostViewed = runBlocking(CommonPool) {
        service.getMostViewed("", "TV", 10).await()
    }
}