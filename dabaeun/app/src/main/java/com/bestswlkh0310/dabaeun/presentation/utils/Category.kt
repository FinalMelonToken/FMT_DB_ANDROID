package com.bestswlkh0310.dabaeun.presentation.utils

import androidx.compose.ui.graphics.Color
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbColor
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme

sealed class Category(val name: String, val color: Color) {
    object iOS: Category(name = "iOS", color = DbColor.iOS)
    object Android: Category(name = "안드로이드", color = DbColor.Android)
    object Server: Category(name = "서버", color = DbColor.Server)
    object Game: Category(name = "게임", color = DbColor.Game)
    object Web: Category(name = "웹", color = DbColor.Web)
    object None: Category(name = "없음", color = DbColor.DisableColor)
}
