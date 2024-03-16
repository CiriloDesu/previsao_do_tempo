package com.brabos.previsaodotempo.service

import com.brabos.previsaodotempo.model.Localizacao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface LocalizacaoService {
    @GET("{cidade}")
    fun getLocalizacaoByCity(@Path("cidade") cidade: String): Call<Localizacao>
}

