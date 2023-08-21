package com.bestswlkh0310.dabaeun.presentation.components.toggle

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.bestswlkh0310.dabaeun.presentation.components.utlis.animateAlignmentAsState

@Composable
fun dbSwitch(
    modifier: Modifier = Modifier,
    boxHeight: Dp = 26.dp,
    isActive: Boolean = false,
    shape: Shape = DbTheme.shape.large,
    activeColor: Color = DbTheme.color.MainColor400,
    inactiveColor: Color = DbTheme.color.Gray100,
    dotColor: Color = DbTheme.color.White,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = false,
    bounded: Boolean = true,
    onActiveChangedListener: ((isActive: Boolean) -> Unit)? = null,
) {
    var isActived by remember { mutableStateOf(isActive) }

    val alignment by animateAlignmentAsState(if (isActived) Alignment.CenterEnd else Alignment.CenterStart)

    val backgroundColor by animateColorAsState(
        if (isActived) activeColor
        else inactiveColor, label = ""
    )

    val dotSize by animateDpAsState(
        if (isActived) boxHeight - 4.dp
        else boxHeight - 12.dp, label = ""
    )

    Box(
        modifier = modifier
            .height(boxHeight)
            .aspectRatio(22f / 13f)
            .background(color = backgroundColor, shape = shape)
            .dbClickable {
                isActived = !isActived
                onActiveChangedListener?.let {
                    it(isActived)
                }
            },
        contentAlignment = alignment,
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = (boxHeight - dotSize) / 2)
                .background(color = dotColor, shape = CircleShape)
                .size(dotSize)
        )
    }
}

@Composable
fun dbSelectSwitch(
    modifier: Modifier = Modifier,
    boxHeight: Dp = 26.dp,
    isLeft: Boolean = true,
    shape: Shape = DbTheme.shape.large,
    rightColor: Color = DbTheme.color.MainColor400,
    leftColor: Color = DbTheme.color.MainColor400,
    dotColor: Color = DbTheme.color.White,
    rippleColor: Color = Color.Unspecified,
    rippleEnable: Boolean = false,
    bounded: Boolean = true,
    onSelectChangedListener: ((isLeft: Boolean) -> Unit)? = null,
) {
    var isLeft by remember { mutableStateOf(isLeft) }

    val alignment by animateAlignmentAsState(if (isLeft) Alignment.CenterStart else Alignment.CenterEnd)

    val backgroundColor by animateColorAsState(
        if (isLeft) leftColor
        else rightColor, label = ""
    )

    Box(
        modifier = modifier
            .height(boxHeight)
            .aspectRatio(22f / 13f)
            .background(color = backgroundColor, shape = shape)
            .dbClickable(/*rippleColor, rippleEnable, bounded*/) {
                isLeft = !isLeft
                onSelectChangedListener?.let {
                    it(isLeft)
                }
            },
        contentAlignment = alignment,
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = (boxHeight - (boxHeight - 4.dp)) / 2)
                .background(color = dotColor, shape = CircleShape)
                .size(boxHeight - 4.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewdbSwitch() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {

        dbSwitch { isActive ->
            Toast.makeText(context, isActive.toString(), Toast.LENGTH_SHORT).show()
        }

        Spacer(modifier = Modifier.height(20.dp))

        dbSelectSwitch { isLeft ->
            Toast.makeText(context, isLeft.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
