package com.bestswlkh0310.dabaeun.presentation.features.onboard


data class OnBoardState(
    val page: Int = 0,
)

sealed class OnBoardSideEffect {
    data class ToastMsg(val msg: String): OnBoardSideEffect()
}