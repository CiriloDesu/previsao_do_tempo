import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TempoRetrofitFactory {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(TempoService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: TempoService by lazy {
        retrofit.create(TempoService::class.java)
    }
}


//package com.brabos.previsaodotempo.service
//
//import TempoService
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
////http://dataservice.accuweather.com/forecasts/v1/daily/1day/
//
//class TempoRetrofitFactory {
//    private val URL = "https://dataservice.accuweather.com/"
//
//    private val tempoRetrofitFactory: Retrofit = Retrofit
//        .Builder()
//        .baseUrl(URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    fun getTempoService(): TempoService {
//        return tempoRetrofitFactory.create(TempoService::class.java)
//    }
//
//}