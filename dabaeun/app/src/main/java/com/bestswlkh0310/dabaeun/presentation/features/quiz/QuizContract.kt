package com.bestswlkh0310.dabaeun.presentation.features.quiz


data class QuizState(
    val isLoading: Boolean = false,
)

sealed class QuizSideEffect {
    data class ToastMsg(val msg: String): QuizSideEffect()
}