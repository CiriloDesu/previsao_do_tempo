package com.brabos.previsaodotempo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brabos.previsaodotempo.R
import com.brabos.previsaodotempo.components.AnimatedBorderCard
import com.brabos.previsaodotempo.components.TextFieldCustom
import com.brabos.previsaodotempo.ui.theme.Blue200
import com.brabos.previsaodotempo.ui.theme.Blue500
import com.brabos.previsaodotempo.ui.theme.Blue900


@Composable
fun FormLogin(){

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var rememberMeCheck by remember{
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.sweepGradient(
                    listOf(
                        Color.Black,
                        Blue900,
                        Color.Black
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 36.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.White,
                        Blue500,
                        Blue200
                    )
                )
            )
        )

        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 48.dp))

        AnimatedBorderCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 23.dp),
            shape = RoundedCornerShape(8.dp),
            gradient = Brush.sweepGradient(listOf(Blue500, Blue200))
        ) {
            Column(
                modifier = Modifier.padding(all = 23.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextFieldCustom(
                    value = username,
                    onValueChange = {
                        username = it
                    },
                    hint = stringResource(id = R.string.hint_username),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp)
                )

                TextFieldCustom(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    hint = stringResource(id = R.string.hint_passworld),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),
                    icon = R.drawable.ic_passworld

                )

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Checkbox(checked = rememberMeCheck ,
                        onCheckedChange = {
                            rememberMeCheck = !rememberMeCheck
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Blue900,
                            uncheckedColor = Blue900,
                            checkmarkColor = Color.White
                        )
                    )

                    Text(
                        text = stringResource(id = R.string.txt_remember_me),
                        fontSize = 14.sp,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.padding(20.dp, 0.dp))

                    Text(
                        text = stringResource(id = R.string.txt_forgot_pass),
                        fontSize = 14.sp,
                        color = Color.White
                    )

                }

                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .width(400.dp)
                        .height(90.dp)
                        .padding(0.dp, 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue900,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                    ) {
                    Text(text = stringResource(id = R.string.txt_btt_login),
                        fontSize = 18.sp
                    )

                }

            }


        }

    }

}

@Composable
@Preview
private fun FormLoginPreview(){

}
