package com.bestswlkh0310.dabaeun.root.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


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

        }

        composable(NavGroup.Auth.JOIN) {

        }


    }
}


    fun getStartDestination(enableAutoLogin: Boolean) =
        if (enableAutoLogin) NavGroup.Main.MAIN else NavGroup.Auth.LOGIN
