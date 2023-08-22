package com.bestswlkh0310.dabaeun.presentation.components.button

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body1
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme.shape
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title2

@Composable
fun DbRoundedButton(
    text: String,
    textColor: Color = DbTheme.color.White,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    shape: Shape = DbTheme.shape.medium,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    isScaleAnim: Boolean = true,
    isMaxWidth: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    val isClicked = interactionSource.collectIsPressedAsState().value
    val textAlpha by animateFloatAsState(
        targetValue = if (isClicked) 0.8f else 1f,
        animationSpec = tween(200), label = ""
    )
    val scale by animateFloatAsState(if (isClicked) 0.98f else 1f, label = "")

    Button(
        onClick = onClick,
        modifier = modifier
            .scale(if (isScaleAnim) scale else 1f),
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = shape,
        type = if (enable) type else ButtonType.Disable,
        enable = enable,
        interactionSource = interactionSource,
    ) {
        Body1(
            text = text,
            textColor = textColor,
            modifier = if (isMaxWidth) Modifier
                .fillMaxWidth()
                .alpha(textAlpha) else Modifier.alpha(textAlpha),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DbSmallRoundedButton(
    text: String,
    textColor: Color = DbTheme.color.White,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    isScaleAnim: Boolean = true,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    DbRoundedButton(
        text = text,
        textColor = textColor,
        modifier = modifier,
        iconLeft = iconLeft,
        isScaleAnim = isScaleAnim,
        iconRight = iconRight,
        shape = shape.small,
        type = type,
        enable = enable,
        onClick = onClick,

    )
}

@Composable
fun DbMediumRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = DbTheme.color.White,
    isScaleAnim: Boolean = true,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    DbRoundedButton(
        text = text,
        modifier = modifier,
        iconLeft = iconLeft,
        textColor = textColor,
        isScaleAnim = isScaleAnim,
        iconRight = iconRight,
        shape = shape.medium,
        type = type,
        enable = enable,
        onClick = onClick,
    )
}

@Composable
fun DbLargeRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = DbTheme.color.White,
    isScaleAnim: Boolean = true,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    DbRoundedButton(
        text = text,
        modifier = modifier,
        textColor = textColor,
        iconLeft = iconLeft,
        isScaleAnim = isScaleAnim,
        iconRight = iconRight,
        shape = shape.large,
        type = type,
        enable = enable,
        onClick = onClick,
    )
}

@Composable
fun DbMaxWidthButton(
    text: String,
    textColor: Color = DbTheme.color.White,
    isScaleAnim: Boolean = false,
    modifier: Modifier = Modifier,
    shape: Shape = DbTheme.shape.medium,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    DbRoundedButton(
        text = text,
        textColor = textColor,
        modifier = modifier,
        shape = shape,
        isScaleAnim = isScaleAnim,
        type = type,
        enable = enable,
        isMaxWidth = true,
        onClick = onClick,
    )
}


@Composable
fun DbKeyBoardButton(
    text: String,
    textColor: Color = DbTheme.color.White,
    isScaleAnim: Boolean = true,
    modifier: Modifier = Modifier,
    shape: Shape = DbTheme.shape.none,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    DbRoundedButton(
        text = text,
        textColor = textColor,
        modifier = modifier,
        shape = shape,
        isScaleAnim = isScaleAnim,
        type = type,
        enable = enable,
        isMaxWidth = true,
        onClick = onClick,
    )
}

@Composable
fun DbGrayButton(
    text: String,
    textColor: Color = DbTheme.color.Gray500,
    modifier: Modifier = Modifier,
    isScaleAnim: Boolean = true,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.PrimaryVariant,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    DbRoundedButton(
        text = text,
        textColor = textColor,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        isScaleAnim = isScaleAnim,
        shape = shape.small,
        type = type,
        enable = enable,
        onClick = onClick,
    )
}
