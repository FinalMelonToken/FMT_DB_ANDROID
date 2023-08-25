package com.bestswlkh0310.dabaeun.presentation.root.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bestswlkh0310.dabaeun.presentation.features.board.BoardScreen
import com.bestswlkh0310.dabaeun.presentation.features.home.HomeScreen
import com.bestswlkh0310.dabaeun.presentation.features.login.LoginScreen
import com.bestswlkh0310.dabaeun.presentation.features.main.MainScreen
import com.bestswlkh0310.dabaeun.presentation.features.my.MyScreen
import com.bestswlkh0310.dabaeun.presentation.features.onboard.OnBoardScreen
import com.bestswlkh0310.dabaeun.presentation.features.quiz.QuizScreen


@Composable
fun NavigationGraph(
    enableAutoLogin: Boolean,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = getStartDestination(enableAutoLogin)
    ) {
        composable(NavGroup.Auth.LOGIN.title) {
            LoginScreen(navController = navController)
        }

        composable(NavGroup.Auth.ON_BOARD.title) {
            OnBoardScreen(navController = navController)
        }

        composable(NavGroup.Main.MAIN.title) {
            MainScreen(navController = navController)
        }

        composable(NavGroup.Main.HOME.title) {
            HomeScreen(navController = navController)
        }

        composable(NavGroup.Main.QUIZ.title) {
            QuizScreen(navController = navController)
        }

        composable(NavGroup.Main.MY.title) {
            MyScreen(navController = navController)
        }

        composable(NavGroup.Feature.BOARD.title) {
            BoardScreen(navController = navController)
        }
    }
}

private val Start = NavGroup.Main.MAIN.title

fun getStartDestination(enableAutoLogin: Boolean) =
    if (enableAutoLogin) NavGroup.Main.MAIN.title else Start
