import com.brabos.previsaodotempo.service.LocalizacaoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocalizacaoFactory {
    private val URL = "http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey=5C5F23ps4tRw3fa3TgePBJdsMENKP6Q9&q="

    private val LocalizacaoFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCepService(): LocalizacaoService {
        return LocalizacaoFactory.create(LocalizacaoService::class.java)
    }
}