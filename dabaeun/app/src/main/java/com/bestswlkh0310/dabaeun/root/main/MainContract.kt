package com.bestswlkh0310.dabaeun.root.main

data class MainState(
    val enableAutoLogin: Boolean? = null
)

sealed class MainSideEffect {
    data class ToastMessage(val throwable: Throwable) : MainSideEffect()
}
