package com.bestswlkh0310.dabaeun.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.components.basic.Surface
import com.bestswlkh0310.dabaeun.components.modifier.dbClickable
import com.bestswlkh0310.dabaeun.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.components.theme.contentColorFor

sealed interface ButtonType {
    object Primary : ButtonType
    object PrimaryVariant : ButtonType
    object Disable : ButtonType
    object None: ButtonType
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    shape: Shape = DbTheme.shape.medium,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        modifier = modifier,
        onClick = if (enable) onClick else null,
        shape = shape,
        color = backgroundColorFor(type),
        interactionSource = interactionSource
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            iconLeft?.let {
                Row(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    iconLeft()
                }
                Spacer(modifier = Modifier.width(8.dp))
            }

            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            ) {
                content()
            }

            iconRight?.let {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    iconRight()
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

private val IconButtonSize = 48.dp

@Composable
fun DbIconButton(
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    val backgroundColor = backgroundColorFor(type)

    val iconColor = contentColorFor(backgroundColor = backgroundColor)

    CompositionLocalProvider(
        com.bestswlkh0310.dabaeun.components.theme.LocalContentColor provides iconColor
    ) {
        Layout(
            modifier = modifier.then(
                Modifier
                    .background(backgroundColor, CircleShape)
                    .clip(CircleShape)
                    .dbClickable(
                        onClick = if (enable) onClick else null,
                    )
            ),
            content = icon
        ) { measurables, constraints ->
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            val boxWidth = IconButtonSize.toPx().toInt()
            val boxHeight = IconButtonSize.toPx().toInt()

            layout(boxWidth, boxWidth) {
                placeables.forEach { placeable ->
                    val x = boxWidth / 2 - placeable.width / 2
                    val y = boxHeight / 2 - placeable.height / 2
                    placeable.placeRelative(x = x, y = y)
                }
            }
        }
    }
}

@Composable
private fun backgroundColorFor(type: ButtonType): Color =
    when (type) {
        ButtonType.Primary -> DbTheme.color.MainColor
        ButtonType.PrimaryVariant -> DbTheme.color.Gray50
        ButtonType.Disable -> DbTheme.color.MainColor200
        ButtonType.None -> DbTheme.color.Error
    }
