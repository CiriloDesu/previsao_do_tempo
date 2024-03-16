package com.brabos.previsaodotempo.model

import com.google.gson.annotations.SerializedName


data class Localizacao(
    val key: String,
   @SerializedName("localizedName") val cidade: String,
    val administrativeArea: AdministrativeArea
)

data class AdministrativeArea(
   @SerializedName("id") val siglaEstado: String,
   @SerializedName("localizedName") val estado: String
)

