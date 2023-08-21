package com.bestswlkh0310.dabaeun.presentation.root.main

data class MainState(
    val enableAutoLogin: Boolean = false
)

sealed class MainSideEffect {
    data class ToastMessage(val throwable: Throwable) : MainSideEffect()
}
