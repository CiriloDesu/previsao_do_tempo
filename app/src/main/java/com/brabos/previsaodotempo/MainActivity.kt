package com.brabos.previsaodotempo

import Tempo
import TempoRetrofitFactory
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brabos.previsaodotempo.screens.FormLogin
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
            FormLogin()
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
    // Variável para armazenar o resultado da pesquisa
    var tempo by remember { mutableStateOf<Tempo?>(null) }
    var listTempos by remember { mutableStateOf<List<Tempo>>(emptyList()) }

    // Layout da tela
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImagemTopo()
        tempo?.let { InformacoesTabela(it) }
        Pesquisa()
    }
}



@Composable
fun ImagemTopo() {
    Image(
        painter = painterResource(id = R.drawable.tempo3), contentDescription = null,
        modifier = Modifier.width(200.dp)
    )
}


//@Composable
//fun InfoPrincipal(listTempos: List<Tempo>) {
//    Column(
//        modifier = Modifier
//            .padding(top = 24.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        listTempos.forEach { tempo ->
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.padding(bottom = 24.dp)
//            ) {
//                Text(
//                    text = tempo.atual.temperaturaCelsius.toString(),
//                    color = DarkBlue,
//                    fontSize = 48.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "${tempo.localizacao.nome}, ${tempo.localizacao.regiao}",
//                    color = DarkBlue,
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 20.sp,
//                    modifier = Modifier.padding(top = 16.dp)
//                )
//                Text(
//                    text = tempo.atual.condicao?.texto ?: "",
//                    color = Color.Gray,
//                    fontSize = 16.sp,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.padding(vertical = 24.dp)
//                )
//            }
//        }
//    }
//}



@Composable
fun InformacoesTabela(tempo: Tempo) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(VeryLightGray)
            .padding(16.dp)
    ) {
        Row {
            InformacoesItem(
                iconRes = R.drawable.ic_humidity,
                title = stringResource(id = R.string.umidade),
                subtitle = "${tempo.atual.umidade}%",
                modifier = Modifier.weight(1f)
            )
            InformacoesItem(
                iconRes = R.drawable.ic_sun_full,
                title = stringResource(id = R.string.temp_max),
                subtitle = "${tempo.atual.temperaturaCelsius}°C",
                modifier = Modifier.weight(1f)
            )
        }
        Divider(color = VeryLightGray)
        Row {
            InformacoesItem(
                iconRes = R.drawable.ic_termo,
                title = stringResource(id = R.string.sense_termica),
                subtitle = "${tempo.atual.sensacaoTermicaCelsius}°C",
                modifier = Modifier.weight(1f)
            )
            InformacoesItem(
                iconRes = R.drawable.ic_sun_half,
                title = stringResource(id = R.string.uv),
                subtitle = "${tempo.atual.uv}",
                modifier = Modifier.weight(1f)
            )
        }
    }
    Column(
        modifier = Modifier
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text(
                text = tempo.atual.temperaturaCelsius.toString(),
                color = DarkBlue,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${tempo.localizacao.nome}, ${tempo.localizacao.regiao}",
                color = DarkBlue,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = tempo.atual.condicao?.texto ?: "",
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 24.dp)
            )
        }
    }
}


@Composable
fun Pesquisa() {
    var pesquisaCidade by remember {
        mutableStateOf("")
    }

    var listTempos by remember {
        mutableStateOf<List<Tempo>>(emptyList())
    }



    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = pesquisaCidade,
            onValueChange = {
                pesquisaCidade = it
            },
            label = {
                Text(text = stringResource(id = R.string.pesquisa))
            },
            trailingIcon = {
                IconButton(onClick = {
                    val call = TempoRetrofitFactory.service.getWForecast(apiKey = "d9f83e3087e04513a3362756241703", query = pesquisaCidade)
                    call.enqueue(object : Callback<Tempo> {
                        override fun onResponse(
                            call: Call<Tempo>,
                            response: Response<Tempo>
                        ) {
                            val tempoResponse = response.body()
                            if (tempoResponse != null) {
                                listTempos = listOf(tempoResponse)
                                Log.d("Pesquisa", "listTempos: $listTempos")
                            }
                        }

                        override fun onFailure(call: Call<Tempo>, t: Throwable) {
                            Log.i("ErroA", "onFailure: ${t.message}")
                        }

                    })
                }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }
            }
        )

        // Exibir a lista de tempos
        listTempos.forEach { tempo ->
            InformacoesTabela(tempo)
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