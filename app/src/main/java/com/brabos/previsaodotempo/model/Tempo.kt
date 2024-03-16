import com.google.gson.annotations.SerializedName

data class Tempo(
    @SerializedName("Key") val key: String,
    val LocalizedName: String,
    val Temperature: Temperature,
    val Day: Day,
    val Night: Night
)


data class Temperature(
    val Minimum: Minimum,
    val Maximum: Maximum
)

data class Minimum(
    val Value: Double,
    val Unit: String
)

data class Maximum(
    val Value: Double,
    val Unit: String
)

data class Day(
    val Icon: Int,
    @SerializedName("IconPhrase") val iconPhrase: String,
    val HasPrecipitation: Boolean
)

data class Night(
    val Icon: Int,
    @SerializedName("IconPhrase") val iconPhrase: String,
    val HasPrecipitation: Boolean
)
