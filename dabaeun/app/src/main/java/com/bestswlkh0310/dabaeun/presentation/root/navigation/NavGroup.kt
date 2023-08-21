package com.bestswlkh0310.dabaeun.presentation.root.navigation

sealed class NavGroup(val group: String) {
    object Auth : NavGroup("auth") {
        const val ON_BOARD = "on_board"
        const val LOGIN = "login"
    }

    object Main : NavGroup("main") {
        const val MAIN = "main"
        const val QUIZ = "quiz"
        const val MY = "my"
    }

    object Feature : NavGroup("feature") {
    }
}