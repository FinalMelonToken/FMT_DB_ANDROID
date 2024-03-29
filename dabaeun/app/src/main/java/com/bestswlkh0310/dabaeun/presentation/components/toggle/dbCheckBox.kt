package com.bestswlkh0310.dabaeun.presentation.components.toggle

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.presentation.components.modifier.dbClickable
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.IcCheck
import com.bestswlkh0310.dabaeun.presentation.components.theme.contentColorFor

@Composable
fun DbCheckBox(
    modifier: Modifier = Modifier,
    checkColor: Color = DbTheme.color.MainColor400,
    unCheckedColor: Color = DbTheme.color.Gray500,
    boxSize: Dp = 12.dp,
    strokeWidth: Dp = 1.dp,
    isChecked: Boolean = false,
    shape: Shape = RoundedCornerShape(3.dp),
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = false,
    bounded: Boolean = true,
    onCheckedChangeListener: ((isChecked: Boolean) -> Unit)? = null,
) {
    var isCheck by remember { mutableStateOf(isChecked) }
    val backgroundColor by animateColorAsState(
        if (isCheck) checkColor
        else DbTheme.color.Transparent, label = ""
    )

    val strokeColor by animateColorAsState(
        if (isCheck) checkColor
        else unCheckedColor, label = ""
    )

    Box(
        modifier = modifier
            .size(boxSize)
            .background(color = backgroundColor, shape = shape)
            .border(width = strokeWidth, shape = shape, color = strokeColor)
            .dbClickable {
                isCheck = !isCheck
                onCheckedChangeListener?.let {
                    it(isCheck)
                }
            }
    ) {
        AnimatedVisibility(
            visible = isCheck,
        ) {
            IcCheck(
                modifier = Modifier
                    .size(boxSize + 4.dp)
                    .align(Alignment.Center),
                tint = contentColorFor(backgroundColor = backgroundColor),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun DbCheckBoxPreview() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        DbCheckBox()
        Spacer(modifier = Modifier.height(20.dp))
        DbCheckBox(boxSize = 20.dp) { isChecked ->
            Toast.makeText(context, isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
