package com.bestswlkh0310.dabaeun.presentation.features.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.bestswlkh0310.dabaeun.presentation.components.button.DbLargeRoundedButton
import com.bestswlkh0310.dabaeun.presentation.components.input.DbInput
import com.bestswlkh0310.dabaeun.presentation.components.input.DbInputArea
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

@Composable
fun PostScreen(
    navController: NavController,
    vm: PostViewModel = hiltViewModel()
) {
    val state = vm.container.stateFlow.collectAsState().value
    var topHeight by remember { mutableStateOf(0.dp) }

    DbTopBar(
        titleText = NavGroup.Feature.POST.title,
        primaryButtonCallback = {
            navController.popBackStack()
        },
        heightCallBack = {
            topHeight = it
        },
        enableSideBar = true,
        sideBar = {
            DbLargeRoundedButton(text = "완료", enable = state.title.isNotBlank() && state.content.isNotBlank()) {
            }
        },
        color = DbTheme.color.Background
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = topHeight)
                .fillMaxSize()
                .background(DbTheme.color.Background)
                .padding(horizontal = 14.dp),
        ) {
            item {
                Spacer(modifier = Modifier.height(14.dp))
                DbInputArea(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.title, hint = "제목을 입력해주세요", onValueChange = vm::updateTitle)
                DbInputArea(
                    modifier = Modifier.fillMaxWidth()
                        .height(600.dp),
                    value = state.content, hint = "내용을 입력해주세요", onValueChange = vm::updateContent)
            }

        }
    }
}
