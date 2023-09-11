package com.bestswlkh0310.dabaeun.presentation.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.presentation.components.basic.Surface
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme

@Composable
fun DbFloatingButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    color: Color = DbTheme.color.MainColor,
    tint: Color = DbTheme.color.White,
    size: Dp = 34.dp,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(50),
        color = color
    ) {
        DbIconButton(
            iconId = iconId,
            color = tint,
            onClick = onClick,
            size = size
        )
    }
}