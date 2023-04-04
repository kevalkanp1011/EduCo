package dev.kevalkanpariya.featuretesteduco.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R



// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val title2 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,
    fontSize = 22.sp
)

private val PlusJakartaDisplay = FontFamily(
    Font(
        resId = R.font.plusjakartadisplay_bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.plusjakartadisplay_bolditalic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.plusjakartadisplay_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.plusjakartadisplay_light,
        weight = FontWeight.Light,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.plusjakartadisplay_lightitalic,
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.plusjakartadisplay_medium,
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.plusjakartadisplay_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.plusjakartadisplay_regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    )

)

val title1 = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 26.sp
)
val title2new = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 22.sp
)

val title3_normal = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp
)

val title3_normal_medium = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp
)

val text_normal = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)

val text_medium = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp
)

val headline_normal = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp
)
val headline_medium = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 15.sp
)
val subheadline = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
)
val subheadline_medium = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp
)
val caption1 = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp
)
val caption2 = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
val caption3 = TextStyle(
    fontFamily = PlusJakartaDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 11.sp
)