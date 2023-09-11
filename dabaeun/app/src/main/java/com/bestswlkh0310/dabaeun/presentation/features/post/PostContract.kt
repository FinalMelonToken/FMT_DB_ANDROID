package com.bestswlkh0310.dabaeun.presentation.features.post


data class PostState(
    val isLoading: Boolean = false,
    val title: String = "",
    val content: String = ""
)

sealed class PostSideEffect {
    data class ToastMsg(val msg: String): PostSideEffect()
}