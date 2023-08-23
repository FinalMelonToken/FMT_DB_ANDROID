package com.bestswlkh0310.dabaeun.presentation.utils

import android.graphics.Rect
import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp

@Composable
fun getBottomNavBarHeight(): Dp {
    val view = LocalView.current

    var bottomNavBarHeight by remember { mutableStateOf(0.toDp) }
    val density = LocalDensity.current.density

    val layoutListener = ViewTreeObserver.OnGlobalLayoutListener {
        val rect = Rect()
        view.getWindowVisibleDisplayFrame(rect)
        val screenHeight = view.height
        bottomNavBarHeight = (screenHeight - rect.bottom).toDp
    }

    DisposableEffect(view) {
        view.viewTreeObserver.addOnGlobalLayoutListener(layoutListener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(layoutListener)
        }
    }

    return bottomNavBarHeight
}