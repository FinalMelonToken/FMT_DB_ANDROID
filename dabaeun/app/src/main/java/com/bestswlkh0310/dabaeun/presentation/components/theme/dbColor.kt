package com.bestswlkh0310.dabaeun.presentation.components.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

object DbColor {

    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)

    val Background = Color(0xFFECECEE)

    val Red = Color(0xFFEF2121)
    val Yellow = Color(0xFFE8C408)
    val Blue = Color(0xFF0073C7)

    val Transparent = Color(0x00000000)

    val MainColor = Color(0xFF00365C)

    val MainColor50 = Color(0xFFF8FCFF)
    val MainColor100 = Color(0xFFECECEE)
    val MainColor200 = Color(0xFF95ADBE)
    val MainColor300 = Color(0xFF63859D)
    val MainColor400 = Color(0xFF325E7D)
    val MainColor500 = Color(0xFF00365C)
    val MainColor600 = Color(0xFF002A48)
    val MainColor700 = Color(0xFF001F34)
    val MainColor800 = Color(0xFF001320)
    val MainColor900 = Color(0xFF00070C)

    val Gray50 = Color(0xFFF4F5F9)
    val Gray100 = Color(0xFFDBDCE0)
    val Gray200 = Color(0xFFC2C2C7)
    val Gray300 = Color(0xFFA8A9AD)
    val Gray400 = Color(0xFF8F8F94)
    val Gray500 = Color(0xFF76767B)
    val Gray600 = Color(0xFF5C5C60)
    val Gray700 = Color(0xFF424245)
    val Gray800 = Color(0xFF28282A)
    val Gray900 = Color(0xFF0E0E0F)

    val Android = Color(0xFF15E242)
    val iOS = Color(0xFFF8421A)
    val Server = Color(0xFF3972E1)
    val Web = Color(0xFFE8C408)
    val Game = Color(0xFFF122DC)

    val DisableColor = Color(0xFFF4F5F9)
}

@Composable
fun contentColorFor(backgroundColor: Color) =
    DbColor.contentColorFor(backgroundColor).takeOrElse { LocalContentColor.current }

private fun DbColor.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        MainColor -> White
        Red -> White
        Gray100 -> White
        Background -> Black
        White -> Black
        Transparent -> Blue
        else -> White
    }
}

internal val LocalColor = staticCompositionLocalOf { DbColor }
internal val LocalContentColor = compositionLocalOf { Color.Black }
internal val LocalContentAlpha = compositionLocalOf { 1f }
