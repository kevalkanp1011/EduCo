package dev.kevalkanpariya.featuretesteduco.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)
val StarColor = Color(0xFFFFC94D)

val ErrorRed = Color(0xFFFF6C60)
val InfoGreen = Color(0xFF00C096)
val LoadingBlue = Color(0xFF1A73E8)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

/*Grey*/
val Grey900 = Color(0xFF0B121F)
val Grey800 = Color(0xFF282F3E)
val Grey700 = Color(0xFF404653)
val Grey600 = Color(0xFF585D69)
val Grey500 = Color(0xFF70747E)
val Grey400 = Color(0xFF888C94)
val Grey300 = Color(0xFF9FA3A9)
val Grey200 = Color(0xFFB7BABF)
val Grey100 = Color(0xFFCFD1D4)
val Grey50 = Color(0xFFEDEEF0)

/*Primary*/
val Primary900 = Color(0xFF180D5F)
val Primary800 = Color(0xFF15158D)
val Primary700 = Color(0xFF1D32BB)
val Primary600 = Color(0xFF265AE8)
val Primary500 = Color(0xFF3F79EB)
val Primary400 = Color(0xFF5894ED)
val Primary300 = Color(0xFF72ADF0)
val Primary200 = Color(0xFF8BC2F3)
val Primary100 = Color(0xFFA4D5F5)
val Primary50 = Color(0xFFE9EFFD)

/*Error*/
val Error900 = Color(0xFF7A271A)
val Error800 = Color(0xFF912018)
val Error700 = Color(0xFFB32318)
val Error600 = Color(0xFFD92D20)
val Error500 = Color(0xFFF04438)
val Error400 = Color(0xFFF97066)
val Error300 = Color(0xFFFDA29B)
val Error200 = Color(0xFFFECDCA)
val Error100 = Color(0xFFFEE4E2)

val SearchBarBG = Color(0xFFFFF1F3)
val TagBG = Color(0XFFFD853A)
val TagBGTeacher = Color(0xFFF97066)
val Colors.splashScreenBackground
    @Composable
    get() = if (isLight) Brush.verticalGradient(
        listOf(
            Purple700,
            Purple500
        )
    ) else Brush.verticalGradient(
        listOf(
            Color.Black,
            Color.Black
        )
    )

val Colors.statusBarColor
    @Composable
    get() = if (isLight) Purple700 else Color.Black

val Colors.welcomeScreenBgColor
    @Composable
    get() = if (isLight) Color.White else Color.Black

val Colors.titleColor
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.descriptionColor
    @Composable
    get() = if (isLight) DarkGray.copy(alpha = 0.5f) else LightGray.copy(alpha = 0.5f)

val Colors.activeIndicatorColor
    @Composable
    get() = if (isLight) Purple500 else Purple700

val Colors.inactiveIndicatorColor
    @Composable
    get() = if (isLight) LightGray else DarkGray

val Colors.buttonBgColor
    @Composable
    get() = if (isLight) Purple500 else Purple700

val Colors.topAppBarContentColor
    @Composable
    get() = if (isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor: Color
    get() = if (isLight) Grey500 else Color.Black

val Colors.topAppBarBgColor
    @Composable
    get() = if (isLight) Purple500 else Color.Black

val Colors.shimmerItemBgColor
    @Composable
    get() = if (isLight) ShimmerLightGray else Color.Black

val Colors.shimmerItemContentColor
    @Composable
    get() = if (isLight) ShimmerMediumGray else ShimmerDarkGray

val Colors.emptyScreenContentColor
    @Composable
    get() = if (isLight) DarkGray else LightGray
