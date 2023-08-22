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

@Composable
fun DbSelectButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DbTheme.color.Black,
    iconLeft: @Composable (() -> Unit)? = null,
    iconRight: @Composable (() -> Unit)? = null,
    shape: Shape = DbTheme.shape.max,
    type: ButtonType = ButtonType.Gray,
    enable: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
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
            textAlign = TextAlign.Center
        )
    }
}