package com.bestswlkh0310.dabaeun.presentation.features.main

import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

data class MainState(
    val selectedTab: NavGroup.Main = NavGroup.Main.QUIZ,
    val isLoading: Boolean = false,
)

sealed class MainSideEffect {
    data class ToastMsg(val msg: String): MainSideEffect()
}