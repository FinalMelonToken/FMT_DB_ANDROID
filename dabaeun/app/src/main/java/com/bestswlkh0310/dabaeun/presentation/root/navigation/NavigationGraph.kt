package com.bestswlkh0310.dabaeun.presentation.root.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bestswlkh0310.dabaeun.presentation.features.login.LoginScreen


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

        composable(NavGroup.Auth.JOIN) {

        }


    }
}


    fun getStartDestination(enableAutoLogin: Boolean) =
        if (enableAutoLogin) NavGroup.Main.MAIN else NavGroup.Auth.LOGIN
