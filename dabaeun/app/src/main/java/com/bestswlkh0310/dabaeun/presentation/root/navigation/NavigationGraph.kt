package com.bestswlkh0310.dabaeun.presentation.root.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
        composable(NavGroup.Auth.LOGIN) {
            LoginScreen(navController = navController)
        }

        composable(NavGroup.Auth.ON_BOARD) {
            OnBoardScreen(navController = navController)
        }

        composable(NavGroup.Main.MAIN) {
            MainScreen(navController = navController)
        }

        composable(NavGroup.Main.HOME) {
            HomeScreen(navController = navController)
        }

        composable(NavGroup.Main.QUIZ) {
            QuizScreen(navController = navController)
        }

        composable(NavGroup.Main.MY) {
            MyScreen(navController = navController)
        }
    }
}

const val Start = NavGroup.Main.MAIN

fun getStartDestination(enableAutoLogin: Boolean) =
    if (enableAutoLogin) NavGroup.Main.MAIN else Start
