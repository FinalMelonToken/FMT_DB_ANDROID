package com.bestswlkh0310.dabaeun.components.button

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
import com.bestswlkh0310.dabaeun.components.theme.SgxTheme
import com.bestswlkh0310.dabaeun.components.theme.SgxTheme.shape
import com.bestswlkh0310.dabaeun.components.theme.Title2

@Composable
fun SgxRoundedButton(
    text: String,
    textColor: Color = SgxTheme.color.White,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    shape: Shape = SgxTheme.shape.medium,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
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
            .scale(scale),
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = shape,
        type = if (enable) type else ButtonType.Disable,
        enable = enable,
        interactionSource = interactionSource,
    ) {
        Title2(
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
fun SgxSmallRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    SgxRoundedButton(
        text = text,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = shape.small,
        type = type,
        enable = enable,
        onClick = onClick,

    )
}

@Composable
fun SgxMediumRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    SgxRoundedButton(
        text = text,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = shape.medium,
        type = type,
        enable = enable,
        onClick = onClick,
    )
}

@Composable
fun SgxLargeRoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    SgxRoundedButton(
        text = text,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = shape.large,
        type = type,
        enable = enable,
        onClick = onClick,
    )
}

@Composable
fun SgxMaxWidthButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = SgxTheme.shape.medium,
    type: ButtonType = ButtonType.Primary,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    SgxRoundedButton(
        text = text,
        modifier = modifier,
        shape = shape,
        type = type,
        enable = enable,
        isMaxWidth = true,
        onClick = onClick,
    )
}

@Composable
fun SgxGrayButton(
    text: String,
    modifier: Modifier = Modifier,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    type: ButtonType = ButtonType.PrimaryVariant,
    enable: Boolean = true,
    onClick: () -> Unit,
) {
    SgxRoundedButton(
        text = text,
        textColor = SgxTheme.color.Gray500,
        modifier = modifier,
        iconLeft = iconLeft,
        iconRight = iconRight,
        shape = shape.small,
        type = type,
        enable = enable,
        onClick = onClick,
    )
}
