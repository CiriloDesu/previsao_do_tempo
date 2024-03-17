import com.google.gson.annotations.SerializedName

data class Tempo(
    @SerializedName("location") val localizacao: Localizacao,
    @SerializedName("current") val atual: ClimaAtual,
    @SerializedName("condition") val condicao: Condicao
)

data class Localizacao(
    @SerializedName("name") val nome: String = "Pesquise a Cidade",
    @SerializedName("region") val regiao: String,
    @SerializedName("country") val pais: String,
//    @SerializedName("lat") val latitude: Double,
//    @SerializedName("lon") val longitude: Double,
//    @SerializedName("tz_id") val idFusoHorario: String,
//    @SerializedName("localtime_epoch") val epochHoraLocal: Long,
//    @SerializedName("localtime") val horaLocal: String
)

data class Condicao(
    @SerializedName("text") val texto: String,
)

data class ClimaAtual(
//    @SerializedName("last_updated_epoch") val epochUltimaAtualizacao: Long,
//    @SerializedName("last_updated") val ultimaAtualizacao: String,
    @SerializedName("temp_c") val temperaturaCelsius: Double = 0.0,
    @SerializedName("temp_f") val temperaturaFahrenheit: Double,
//    @SerializedName("is_day") val dia: Int,
    @SerializedName("condition") val condicao: Condicao,
    //@SerializedName("wind_mph") val velocidadeVentoMilhasHora: Double,
   // @SerializedName("wind_kph") val velocidadeVentoKmHora: Double,
  //  @SerializedName("wind_degree") val grauVento: Int,
   // @SerializedName("wind_dir") val direcaoVento: String,
   // @SerializedName("pressure_mb") val pressaoMB: Double,
    //@SerializedName("pressure_in") val pressaoIn: Double,
//    @SerializedName("precip_in") val precipitacaoIn: Double,
    @SerializedName("humidity") val umidade: Int = 0,
   // @SerializedName("cloud") val nuvem: Int,
    @SerializedName("feelslike_c") val sensacaoTermicaCelsius: Double,
    //@SerializedName("feelslike_f") val sensacaoTermicaFahrenheit: Double,
    //@SerializedName("vis_km") val visibilidadeKm: Double,
   // @SerializedName("vis_miles") val visibilidadeMilhas: Double,
    @SerializedName("uv") val uv: Double = 0.0,
   // @SerializedName("gust_mph") val rajadaMilhasHora: Double,
    //@SerializedName("gust_kph") val rajadaKmHora: Double
)








//import com.google.gson.annotations.SerializedName
//import java.util.*
//
//
//data class Tempo(
//    @SerializedName("EffectiveDate") val effectiveDate: Date = Date(),
//    @SerializedName("EffectiveEpochDate") val effectiveEpochDate: Long = 0,
//    @SerializedName("Severity") val severity: Int = 0,
//    @SerializedName("Text") val text: String = "",
//    @SerializedName("Category") val category: String = "",
//    @SerializedName("EndDate") val endDate: Date = Date(),
//    @SerializedName("EndEpochDate") val endEpochDate: Long = 0,
//    @SerializedName("MobileLink") val mobileLink: String = "",
//    @SerializedName("Link") val link: String = "",
//    @SerializedName("RelativeHumidity") val relativeHumidity: RelativeHumidity = RelativeHumidity(5 ,5,5),
//    @SerializedName("Temperature") val temperature: Temperature = Temperature(maximum = 5, minimum = 5),
//    @SerializedName("RealFeelTemperature") val realFeelTemperature: RealFeelTemperature = RealFeelTemperature(5, 5, "asdasdad")
//)
//
//
//data class Moon(
//    @SerializedName("Rise") val rise: Date,
//    @SerializedName("EpochRise") val epochRise: Long,
//    @SerializedName("Set") val set: Date,
//    @SerializedName("EpochSet") val epochSet: Long,
//    @SerializedName("Phase") val phase: String,
//    @SerializedName("Age") val age: Int
//)
//
//data class RelativeHumidity (
//   @SerializedName("RltHumidityMin") val Minimum:Int,
//   @SerializedName("RltHumidityMax")val Maximum: Int,
//   @SerializedName("RltHumidityAve")val Average: Int
//)
//
//data class Minimum(
//    @SerializedName("Value") val value: Int,
//    @SerializedName("Unit") val unit: String,
//    @SerializedName("UnitType") val unitType: Int
//)
//
//data class Maximum(
//    @SerializedName("Value") val value: Int,
//    @SerializedName("Unit") val unit: String,
//    @SerializedName("UnitType") val unitType: Int
//)
//
//data class Temperature(
//    @SerializedName("Minimum") val minimum: Int,
//    @SerializedName("Maximum") val maximum: Int
//)
//
//data class RealFeelTemperature(
//    @SerializedName("Minimum") val minimum: Int,
//    @SerializedName("Maximum") val maximum: Int,
//    @SerializedName("Phrase") val phrase: String
//)
//
//data class RealFeelTemperatureShade(
//    @SerializedName("Minimum") val minimum: Minimum,
//    @SerializedName("Maximum") val maximum: Maximum,
//    @SerializedName("Phrase") val phrase: String
//)
//
//data class DailyForecast(
//    @SerializedName("Date") val date: Date,
//    @SerializedName("EpochDate") val epochDate: Long,
//    @SerializedName("Moon") val moon: Moon,
//    @SerializedName("Temperature") val temperature: Temperature,
//    @SerializedName("RealFeelTemperature") val realFeelTemperature: RealFeelTemperature,
//    @SerializedName("RealFeelTemperatureShade") val realFeelTemperatureShade: RealFeelTemperatureShade,
//    @SerializedName("HoursOfSun") val hoursOfSun: Double,
//)
//
//data class WeatherData(
//    @SerializedName("Headline") val headline: Tempo,
//    @SerializedName("DailyForecasts") val dailyForecasts: List<DailyForecast>
//)
