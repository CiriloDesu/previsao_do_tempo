package com.brabos.previsaodotempo.model

import com.google.gson.annotations.SerializedName

data class Localizacao(
    @SerializedName("Key") val key: String,
    @SerializedName("LocalizedName") val cidade: String,
    @SerializedName("AdministrativeArea") val administrativeArea: AdministrativeArea
)

data class AdministrativeArea(
    @SerializedName("ID") val siglaEstado: String,
    @SerializedName("LocalizedName") val estado: String
)
