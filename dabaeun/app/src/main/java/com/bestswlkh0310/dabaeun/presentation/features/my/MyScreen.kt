package com.bestswlkh0310.dabaeun.presentation.features.my

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MyScreen(
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {
    Column {
        Text(text = "my")
    }

}