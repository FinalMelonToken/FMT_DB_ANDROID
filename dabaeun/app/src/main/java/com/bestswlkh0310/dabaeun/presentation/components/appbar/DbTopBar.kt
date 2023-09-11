package com.bestswlkh0310.dabaeun.presentation.components.appbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.R
import com.bestswlkh0310.dabaeun.presentation.components.button.DbIconButton
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title1

@Composable
fun DbTopBar(
    modifier: Modifier = Modifier,
    enablePrimaryButton: Boolean = true,
    enableSideBar: Boolean = false,
    primaryButtonCallback: () -> Unit = {},
    sideBar: @Composable () -> Unit = {},
    @DrawableRes primaryIconId: Int = R.drawable.ic_back,
    titleText: String = "",
    color: Color = DbTheme.color.White,
    yOffset: Dp = 0.dp,
    heightCallBack: (Dp) -> Unit = {},
    body1: @Composable ColumnScope.() -> Unit = {},
    body2: @Composable ColumnScope.() -> Unit,
) {
    val density = LocalDensity.current
    var barHeight by remember {
        mutableStateOf(0.dp)
    }
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
//            Surface(
//                modifier = Modifier
//                    .height(barHeight)
//            ) {
//                Spacer(
//                    modifier = Modifier
//                        .height(barHeight + yOffset)
//                )
//            }
            body2()
        }

        Column(
            modifier = Modifier
                .offset(y = yOffset)
                .onGloballyPositioned { coordinates ->
                    barHeight = with(density) {
                        coordinates.size.height.toDp()
                    }
                    heightCallBack(barHeight)
                }
                .background(color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                if (enablePrimaryButton) {
                    DbIconButton(
                        modifier = Modifier,
                        iconId = primaryIconId,
                        contentDescription = "to back",
                        onClick = primaryButtonCallback
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Title1(
                    text = titleText,
                )
                Spacer(modifier = Modifier.weight(1f))
                if (enableSideBar)
                    sideBar()
                Spacer(modifier = Modifier.width(14.dp))
            }
            body1()
        }
    }
}