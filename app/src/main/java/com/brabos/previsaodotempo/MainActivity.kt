package com.brabos.previsaodotempo

import android.os.Bundle
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
import com.brabos.previsaodotempo.ui.theme.DarkBlue
import com.brabos.previsaodotempo.ui.theme.PrevisaoDoTempoTheme
import com.brabos.previsaodotempo.ui.theme.VeryLightGray
import com.brabos.previsaodotempo.ui.theme.fontePoppins

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
    var cidadeState by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        ImagemTopo()
        InfoPrincipal()
        InformacoesTabela()
        Pesquisa()
    }
}

@Composable
fun Pesquisa() {
    Column() {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Pesquise cidade aqui ")
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }
            }
        )
    }
}

@Composable
fun ImagemTopo() {
    Image(painter = painterResource(id = R.drawable.tempo3), contentDescription = null,
        modifier = Modifier.width(200.dp)
    )
}


@Composable
fun InfoPrincipal() {
    Column(modifier = Modifier
        .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "11º",
            color = Color(R.color.DarkBlue),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontePoppins)
        Text(
            text = "Aracaju, SE",
            color = Color(R.color.DarkBlue),
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(text = "Chuvoso, parcialmente nublado. \nVento de 10 a 15km/h",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}

@Composable
fun InformacoesTabela() {
    Column(modifier = Modifier
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
fun InformacoesItem(@DrawableRes iconRes: Int, title: String, subtitle: String, modifier: Modifier) {
    Row(modifier = modifier){
        Image(painter = painterResource(id = iconRes), contentDescription = null, modifier = Modifier
            .padding(end = 8.dp)
            .width(40.dp))
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
