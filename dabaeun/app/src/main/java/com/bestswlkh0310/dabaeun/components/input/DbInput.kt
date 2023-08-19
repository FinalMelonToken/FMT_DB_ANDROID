package com.bestswlkh0310.dabaeun.components.input

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bestswlkh0310.dabaeun.components.theme.LocalContentColor
import com.bestswlkh0310.dabaeun.components.theme.Label2
import com.bestswlkh0310.dabaeun.components.theme.DbTheme

sealed interface InputType {
    object Default : InputType
    object UnFocus : InputType
    object Focus : InputType
    object Error {
        object Default : InputType
        object UnFocus : InputType
        object Focus : InputType
    }
}

@Composable
fun DbInput(
    value: String,
    hint: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String = "",
    enabled: Boolean = true,
    textColor: Color = DbTheme.color.Gray500,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    textStyle: TextStyle = DbTheme.typography.title1,
    focusColor: Color = DbTheme.color.MainColor400,
    readOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
) {
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor, fontWeight = FontWeight.Medium))
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    var isFocus by remember { mutableStateOf(false) }
    var currentInputType: InputType by remember { mutableStateOf(if (isError) InputType.Error.UnFocus else InputType.Default) }

    Column {
        currentInputType = focusStateAsInputType(isFocus, value, isError)

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .background(
                    color = DbTheme.color.Transparent,
                    shape = RectangleShape
                )
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocus = it.isFocused
                },
            enabled = enabled,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(focusColor),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            readOnly = readOnly,
            decorationBox = @Composable { innerTextField ->
                InputDecoration(
                    inputType = currentInputType,
                    hint = hint,
                    innerTextField = innerTextField,
                    focusColor = focusColor,
                    trailingIcon = trailingIcon,
                )
            }
        )

        if (
            (currentInputType == InputType.Error.Default) or
            (currentInputType == InputType.Error.UnFocus) or
            (currentInputType == InputType.Error.Focus)
        ) {
            Spacer(modifier = Modifier.height(3.dp))
            Label2(
                text = errorMessage,
                textColor = getInputColor(
                    focusColor = focusColor,
                    inputType = currentInputType
                )
            )
        }
    }
}

@Composable
private fun InputDecoration(
    inputType: InputType,
    hint: String,
    focusColor: Color,
    innerTextField: @Composable () -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    val r = getInputColor(focusColor, inputType)
    val inputColor = if (r == focusColor) focusColor else DbTheme.color.Gray200

    val hintOffsetAnimation: Dp by animateDpAsState(
        if (inputType == InputType.Default || inputType == InputType.Error.Default)
            0.dp
        else
            (-22).dp,
        label = "",
    )

    val hintFontSize by animateFloatAsState(
        if (inputType == InputType.Default || inputType == InputType.Error.Default)
            22f
        else
            14f, label = ""
    )

    val dividerColor = DbTheme.color.Gray50

    Box(
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = if (inputColor == focusColor) focusColor else dividerColor,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 10.dp)
            ) {
                Text(
                    text = hint,
                    color = inputColor,
                    style = DbTheme.typography.title1.copy(
                        fontSize = hintFontSize.sp,
                        lineHeight = (hintFontSize + 10f).sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .offset(y = hintOffsetAnimation)
                )
                innerTextField()
            }

            trailingIcon?.let {
                Spacer(modifier = Modifier.width(7.dp))
                CompositionLocalProvider(
                    LocalContentColor provides inputColor
                ) {
                    trailingIcon()
                }
            }
        }
    }
}

private fun focusStateAsInputType(
    isFocused: Boolean,
    currentValue: String,
    isError: Boolean
): InputType =
    if (isError) {
        if (isFocused) {
            InputType.Error.Focus
        } else if (currentValue.isNotBlank()) {
            InputType.Error.UnFocus
        } else if (currentValue.isBlank()) {
            InputType.Error.Default
        } else {
            InputType.Error.Default
        }
    } else if (isFocused) {
        InputType.Focus
    } else if (currentValue.isNotBlank()) {
        InputType.UnFocus
    } else if (currentValue.isBlank()) {
        InputType.Default
    } else {
        InputType.Default
    }

@Composable
private fun getInputColor(focusColor: Color, inputType: InputType): Color =
    when (inputType) {
        InputType.Default -> DbTheme.color.Gray500
        InputType.UnFocus -> DbTheme.color.Gray500
        InputType.Focus -> focusColor
        InputType.Error.Default -> DbTheme.color.Error
        InputType.Error.Focus -> DbTheme.color.Error
        InputType.Error.UnFocus -> DbTheme.color.Error
    }