package com.bestswlkh0310.dabaeun.presentation.features.board


data class BoardState(
    val isLoading: Boolean = false,
)

sealed class BoardSideEffect {
    data class ToastMsg(val msg: String): BoardSideEffect()
}