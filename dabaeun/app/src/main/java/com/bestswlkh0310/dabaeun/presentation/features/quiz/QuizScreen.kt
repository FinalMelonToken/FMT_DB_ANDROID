package com.bestswlkh0310.dabaeun.presentation.features.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.entity.Quiz
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.utils.Category
val a = arrayListOf(
    Quiz(
    Category.iOS,
    "asdasd"
),
    Quiz(
    Category.Android,
    "asdasd"
),
    Quiz(
    Category.Server,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),
    Quiz(
    Category.Web,
    "asdasd"
),)
@Composable
fun QuizScreen(
    navController: NavController,
    viewModel: QuizViewModel = hiltViewModel()
) {
    var topHeight by remember { mutableStateOf(0.dp) }
    DbTopBar(
        titleText = "퀴즈",
        color = DbTheme.color.Background,
        enablePrimaryButton = false,
        heightCallBack = {
            topHeight = it
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = topHeight)
                .background(DbTheme.color.Background)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 14.dp)
            ) {
                items(a) {
                    QuizItemView(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        quiz = it.quiz,
                        category = it.category)
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
//    DbTopBar(
//        titleText = NavGroup.Main.HOME.title,
//        enablePrimaryButton = false,
//        yOffset = yOffset,
//        heightCallBack = {
//            topHeight = it
//        }) {
//
//    }
}