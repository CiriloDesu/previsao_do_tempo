package com.brabos.previsaodotempo

import LocalizacaoRetrofitFactory
import LocalizacaoService
import Tempo
import TempoService
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brabos.previsaodotempo.model.Localizacao
import com.brabos.previsaodotempo.service.TempoRetrofitFactory
import com.brabos.previsaodotempo.ui.theme.DarkBlue
import com.brabos.previsaodotempo.ui.theme.PrevisaoDoTempoTheme
import com.brabos.previsaodotempo.ui.theme.VeryLightGray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrevisaoDoTempoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TempoScreen()
                }
            }
        }
    }
}

@Composable
fun TempoScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        ImagemTopo()
        InfoPrincipal()
        InformacoesTabela()
        Pesquisa()
    }
}

@Composable
fun Pesquisa() {
    var pesquisaCidade by remember {
        mutableStateOf("")
    }

    var listLocalizacaoResult by remember {
        mutableStateOf(listOf<Localizacao>())
    }

    var listTemperaturaResult by remember{
        mutableStateOf(listOf<Tempo>())
    }



    Column() {
        OutlinedTextField(
            value = pesquisaCidade,
            onValueChange = {
                pesquisaCidade = it
            },
            label = {
                Text(text = "Pesquise cidade aqui ")
            },
            trailingIcon = {
                IconButton(onClick = {
                    val call = LocalizacaoRetrofitFactory().getLocalizacaoService().getLocalizacaoByCity(
                        apiKey = "5C5F23ps4tRw3fa3TgePBJdsMENKP6Q9",
                        cidade = pesquisaCidade
                    )
                    call.enqueue(object : Callback<List<Localizacao>> {
                        override fun onResponse(
                            call: Call<List<Localizacao>>,
                            response: Response<List<Localizacao>>
                        ) {
                            if (response.isSuccessful) {
                                var listLocalizacao = response.body()
                                if (listLocalizacao != null && listLocalizacao.isNotEmpty()) {
                                    val localizacao = listLocalizacao.first()
                                    val keyResposta = localizacao.key

                                    // Agora você pode usar a key para fazer a próxima chamada
                                    val callTempo = TempoRetrofitFactory().getTempoService().getDailyForecast(
                                        cityKey = keyResposta,
                                        apiKey = "5C5F23ps4tRw3fa3TgePBJdsMENKP6Q9"
                                    )
                                    callTempo.enqueue(object : Callback<List<Tempo>> {
                                        override fun onResponse(
                                            call: Call<List<Tempo>>,
                                            response: Response<List<Tempo>>
                                        ) {
                                            if (response.isSuccessful) {
                                                val listTempos = response.body()
                                                // Faça o que precisa com a lista de Tempos
                                            } else {
                                                Log.i("CIRILO", "onResponse Tempo: ${response.message()}")
                                            }
                                        }

                                        override fun onFailure(call: Call<List<Tempo>>, t: Throwable) {
                                            Log.i("CIRILO", "onFailure Tempo: ${t.message}")
                                        }
                                    })
                                }
                            } else {
                                Log.i("CIRILO", "onResponse Localizacao: ${response.message()}")
                            }
                        }

                        override fun onFailure(call: Call<List<Localizacao>>, t: Throwable) {
                            Log.i("CIRILO", "onFailure Localizacao: ${t.message}")
                        }
                    })
                }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }

            }
        )
    }
}


@Composable
fun ImagemTopo() {
    Image(
        painter = painterResource(id = R.drawable.tempo3), contentDescription = null,
        modifier = Modifier.width(200.dp)
    )
}


@Composable
fun InfoPrincipal() {
    Column(
        modifier = Modifier
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "11º",
            color = Color(R.color.DarkBlue),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Aracaju, SE",
            color = Color(R.color.DarkBlue),
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Chuvoso, parcialmente nublado. \nVento de 10 a 15km/h",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}

@Composable
fun InformacoesTabela() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(
                VeryLightGray
            )
    ) {
        Row(Modifier.padding(16.dp)) {
            InformacoesItem(
                iconRes = R.drawable.ic_humidity,
                title = "Humidade",
                subtitle = "85%",
                modifier = Modifier.weight(1f)
            )
            InformacoesItem(
                iconRes = R.drawable.ic_sun_full,
                title = "Temp Máx",
                subtitle = "TEMP AQUI",
                modifier = Modifier.weight(1f)
            )
        }
        Divider(color = VeryLightGray)
        Row(Modifier.padding(16.dp)) {
            InformacoesItem(
                iconRes = R.drawable.ic_termo,
                title = "Sens Térmica",
                subtitle = "5:30 AM",
                modifier = Modifier.weight(1f)
            )
            InformacoesItem(
                iconRes = R.drawable.ic_sun_half,
                title = "Temp Min",
                subtitle = "TEMP AQUI",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun InformacoesItem(
    @DrawableRes iconRes: Int,
    title: String,
    subtitle: String,
    modifier: Modifier
) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = iconRes), contentDescription = null, modifier = Modifier
                .padding(end = 8.dp)
                .width(40.dp)
        )
        Column {
            Text(title)
            Text(text = subtitle, color = DarkBlue, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun TempoScreenPreview() {
    TempoScreen()
}
