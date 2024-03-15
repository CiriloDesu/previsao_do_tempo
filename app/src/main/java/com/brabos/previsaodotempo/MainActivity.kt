package com.brabos.previsaodotempo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brabos.previsaodotempo.ui.theme.PrevisaoDoTempoTheme
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
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        ImagemTopo()
        InfoPrincipal()
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
        Text(text = "Chuvo, parcialmente nublado. \nVento de 10 a 15km/h",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 24.dp))
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun TempoScreenPreview() {
    TempoScreen()
}
