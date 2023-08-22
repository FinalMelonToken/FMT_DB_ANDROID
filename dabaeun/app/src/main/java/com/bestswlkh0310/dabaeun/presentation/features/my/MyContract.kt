package com.bestswlkh0310.dabaeun.presentation.features.my


data class MyState(
    val isLoading: Boolean = false,
)

sealed class MySideEffect {
    data class ToastMsg(val msg: String): MySideEffect()
}