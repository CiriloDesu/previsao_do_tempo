import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TempoService {
    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val API_KEY = "d9f83e3087e04513a3362756241703"
    }

    @GET("forecast.json")
    fun getWForecast(
        @Query("key") apiKey: String = API_KEY,
        @Query("q") query: String,
        @Query("days") days: Int = 1,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): Call<Tempo>
}


//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Path
//import retrofit2.http.Query
//
//interface TempoService {
//    companion object {
//        const val API_KEY = "5C5F23ps4tRw3fa3TgePBJdsMENKP6Q9"
//    }
//    @GET("forecasts/v1/daily/1day/{key}")
//    fun getDailyForecast(
//        @Path("key") cityKey: String,
//        @Query("apikey") apiKey: String = API_KEY
//    ): Call<Tempo>
//}
//
//
//http://api.weatherapi.com/v1/forecast.json?key=d9f83e3087e04513a3362756241703 &q=Aracaju&days=1&aqi=no&alerts=no