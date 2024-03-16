package com.brabos.previsaodotempo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.brabos.previsaodotempo.R

val fontePoppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fontePoppins
    ),
    bodyMedium = TextStyle(
        fontFamily = fontePoppins
    ),
    bodySmall = TextStyle(
        fontFamily = fontePoppins
    )
)
