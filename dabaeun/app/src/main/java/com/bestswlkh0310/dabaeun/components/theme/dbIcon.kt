package com.bestswlkh0310.dabaeun.components.theme

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.bestswlkh0310.dabaeun.R

@Composable
fun IcDefault(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    icon: Int
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun IcBackArrow(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    IcDefault(
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint,
        icon = R.drawable.ic_back
    )
}

@Composable
fun IcCheck(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    IcDefault(
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint,
        icon = R.drawable.ic_check
    )

}
