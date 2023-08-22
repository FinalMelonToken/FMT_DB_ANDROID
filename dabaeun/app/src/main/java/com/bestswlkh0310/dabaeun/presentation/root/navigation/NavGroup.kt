package com.bestswlkh0310.dabaeun.presentation.root.navigation

sealed class NavGroup(val group: String) {
    sealed class Auth(val id: String, val title: String) : NavGroup("auth") {
        object ON_BOARD: Auth("on_board", "온보딩")
        object LOGIN: Auth("login", "로그인")
    }

    sealed class Main(val id: String, val title: String) : NavGroup("main") {
        object MAIN: Main("main", "메인")
        object HOME: Main("home", "홈")
        object QUIZ: Main("quiz", "퀴즈")
        object MY: Main("my", "MY")
    }

    object Feature : NavGroup("feature") {
    }
}