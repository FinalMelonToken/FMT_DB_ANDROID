package com.bestswlkh0310.dabaeun.presentation.components.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun DbTheme(
    color: DbColor = DbTheme.color,
    typography: DbTypography = DbTheme.typography,
    shape: DbShape = DbTheme.shape,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColor provides color,
        LocalTypography provides typography,
        LocalShape provides shape,
        content = content
    )
}

object DbTheme {
    val color: DbColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current

    val typography: DbTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shape: DbShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current
}