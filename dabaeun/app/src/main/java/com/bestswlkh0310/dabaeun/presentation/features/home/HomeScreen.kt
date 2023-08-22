package com.bestswlkh0310.dabaeun.presentation.features.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.button.ButtonType
import com.bestswlkh0310.dabaeun.presentation.components.button.DbGraySelectBottom
import com.bestswlkh0310.dabaeun.presentation.components.button.DbSelectButton
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

private val categoryList = arrayListOf(
    HomeCategory.All,
    HomeCategory.Coding,
    HomeCategory.Algorithm,
    HomeCategory.Exercise
)

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    DbTopBar(
        titleText = NavGroup.Main.HOME.title,
        enablePrimaryButton = false
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp)
        ) {
            LazyRow(
            ) {
                items(categoryList) {
                    if (it == state.selectedCategory)
                    DbSelectButton(
                        modifier = Modifier
                            .padding(end = 8.dp),
                        text = it.title,
                        textColor = DbTheme.color.White,
                        type = ButtonType.Black
                    ) {
                        viewModel.updateSelectedCategory(it)
                    }
                    else
                    DbSelectButton(
                        modifier = Modifier
                            .padding(end = 8.dp),
                        text = it.title
                    ) {
                        viewModel.updateSelectedCategory(it)
                    }
                }
            }
        }
    }
}