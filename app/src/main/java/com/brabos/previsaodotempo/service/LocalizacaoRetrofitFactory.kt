import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocalizacaoRetrofitFactory {
    private val URL = "https://dataservice.accuweather.com/"

    private val localizacaoRetrofitFactory: Retrofit = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLocalizacaoService(): LocalizacaoService {
        return localizacaoRetrofitFactory.create(LocalizacaoService::class.java)
    }
}
