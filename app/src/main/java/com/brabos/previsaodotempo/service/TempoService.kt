import Tempo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TempoService {
    companion object {
        const val API_KEY = "5C5F23ps4tRw3fa3TgePBJdsMENKP6Q9"
    }

    @GET("forecasts/v1/daily/1day/{key}")
    fun getDailyForecast(
        @Path("key") cityKey: String,
        @Query("apikey") apiKey: String = API_KEY
    ): Call<List<Tempo>>
}