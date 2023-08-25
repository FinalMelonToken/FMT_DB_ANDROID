package com.bestswlkh0310.dabaeun.presentation.root.navigation

import com.bestswlkh0310.dabaeun.R

sealed class NavGroup(val group: String) {
    sealed class Auth(val id: String, val title: String) : NavGroup("auth") {
        object ON_BOARD: Auth("on_board", "온보딩")
        object LOGIN: Auth("login", "로그인")
    }

    sealed class Main(val id: String, val title: String, val icon: Int) : NavGroup("main") {
        object MAIN: Main("main", "메인", -1)
        object HOME: Main("home", "홈", R.drawable.ic_home)
        object QUIZ: Main("quiz", "퀴즈", R.drawable.ic_quiz)
        object MY: Main("my", "MY", R.drawable.ic_my)
    }

    sealed class Feature(val id: String, val title: String) : NavGroup("feature") {
        object BOARD: Feature("board", "게시글")
    }
}