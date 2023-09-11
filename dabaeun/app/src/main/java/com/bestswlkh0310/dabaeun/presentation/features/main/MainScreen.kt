package com.bestswlkh0310.dabaeun.presentation.features.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.features.home.HomeScreen
import com.bestswlkh0310.dabaeun.presentation.features.my.MyScreen
import com.bestswlkh0310.dabaeun.presentation.features.quiz.QuizScreen
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state by viewModel.container.stateFlow.collectAsState()
    Scaffold(
        bottomBar = {
            MainBottomNavigation(selectedTab = state.selectedTab, selectedTabCallback = {
                viewModel.updateSelectedTab(it)
            })
        }
    ) {
        Box(Modifier.padding(bottom = it.calculateBottomPadding())) {
            Column {
                when (state.selectedTab) {
                    NavGroup.Main.HOME -> HomeScreen(navController = navController)
                    NavGroup.Main.QUIZ -> QuizScreen(navController = navController)
                    NavGroup.Main.MY -> MyScreen(navController = navController)
                    else -> {}
                }
            }
        }
    }
}