package com.brabos.previsaodotempo.model

import com.google.gson.annotations.SerializedName

data class DailyForecast(
    val date: String,
    val epochDate: Long,
    @SerializedName("temperature") val temperatura: Temperature,
    val day: ForecastDetails,
    val night: ForecastDetails
)

data class Temperature(
    val minimum: TemperatureDetail,
    val maximum: TemperatureDetail
)

data class TemperatureDetail(
    val value: Int,
    val unit: String,
    val unitType: Int
)

data class ForecastDetails(
    val icon: Int,
    val iconPhrase: String,
    val hasPrecipitation: Boolean
)
