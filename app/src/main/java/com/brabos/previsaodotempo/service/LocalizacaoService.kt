import com.brabos.previsaodotempo.model.Localizacao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey=5C5F23ps4tRw3fa3TgePBJdsMENKP6Q9&q=cidade

interface LocalizacaoService {
    companion object {
        const val API_KEY = "5C5F23ps4tRw3fa3TgePBJdsMENKP6Q9"
    }

    @GET("locations/v1/cities/autocomplete")
    fun getLocalizacaoByCity(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("q") cidade: String
    ): Call<List<Localizacao>>
}





