package dk.youtec.drapi

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DrMuRepository {
    private var service: DrMuApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create<DrMuApi>(DrMuApi::class.java)
    }

    fun getPageTvFront(): PageTvFrontResponse? {
        val response: Response<PageTvFrontResponse> = service.getPageTvFront().execute()
        return response.body()
    }

    fun getAllActiveDrTvChannels(): List<Channel> {
        val response: Response<List<Channel>> = service.getAllActiveDrTvChannels().execute()
        return response.body() ?: emptyList()
    }

    fun getManifest(uri: String): Manifest? {
        val response: Response<Manifest> = service.getManifest(uri.removePrefix(API_URL)).execute()
        return response.body()
    }

    fun getSchedule(id: String, date: String): Schedule? {
        val response: Response<Schedule> = service.getSchedule(id, date).execute()
        return response.body()
    }

    fun search(query: String): SearchResult? {
        val response: Response<SearchResult> = service.search(query).execute()
        return response.body()
    }
}