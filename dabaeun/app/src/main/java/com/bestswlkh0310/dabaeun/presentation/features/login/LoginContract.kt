package com.bestswlkh0310.dabaeun.presentation.features.login


data class LoginState(
    val isLoading: Boolean = false,
    val email: String = "",
    val pw: String = "",
    val enableAutoLogin: Boolean = false,
)

sealed class LoginSideEffect {
    data class ToastMsg(val msg: String): LoginSideEffect()
}