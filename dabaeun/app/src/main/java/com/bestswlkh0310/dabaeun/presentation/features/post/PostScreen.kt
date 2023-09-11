package com.bestswlkh0310.dabaeun.presentation.features.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.features.board.BoardViewModel
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

@Composable
fun PostScreen(
    navController: NavController,
    viewModel: PostViewModel = hiltViewModel()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    var topHeight by remember { mutableStateOf(200.dp) }

    DbTopBar(
        titleText = NavGroup.Feature.POST.title,
        primaryButtonCallback = {
            navController.popBackStack()
        },
        heightCallBack = {
            topHeight = it
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = topHeight)
                .background(DbTheme.color.Background),
        ) {

        }
    }
}