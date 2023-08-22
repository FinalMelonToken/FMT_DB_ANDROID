package com.bestswlkh0310.dabaeun.presentation.features.home


data class HomeState(
    val isLoading: Boolean = false,
)

sealed class HomeSideEffect {
    data class ToastMsg(val msg: String): HomeSideEffect()
}