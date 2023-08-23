package com.bestswlkh0310.dabaeun.presentation.utils

import android.content.res.Resources
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Int.toDp: Dp
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).dp

val Float.toDp: Dp
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).dp