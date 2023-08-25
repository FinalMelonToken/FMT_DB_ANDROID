package com.bestswlkh0310.dabaeun.presentation.features.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.R
import com.bestswlkh0310.dabaeun.data.model.BoardList
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.button.ButtonType
import com.bestswlkh0310.dabaeun.presentation.components.button.DbSelectButton
import com.bestswlkh0310.dabaeun.presentation.components.card.DbBoardCard
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup
import com.bestswlkh0310.dabaeun.presentation.utils.toDp
import java.time.LocalDateTime

private val categoryList = arrayListOf(
    HomeCategory.All,
    HomeCategory.Coding,
    HomeCategory.Algorithm,
    HomeCategory.Exercise
)

private val boardListList = arrayListOf(
    BoardList("파이썬했어요", R.drawable.ic_launcher_background, "나다", LocalDateTime.now(), R.drawable.ic_launcher_background),
    BoardList("파이썬했어요", R.drawable.ic_launcher_background, "나다", LocalDateTime.now(), R.drawable.ic_launcher_background),
    BoardList("파이썬했어요", R.drawable.ic_launcher_background, "나다", LocalDateTime.now(), R.drawable.ic_launcher_background),
    BoardList("파이썬했어요", R.drawable.ic_launcher_background, "나다", LocalDateTime.now(), R.drawable.ic_launcher_background),
    BoardList("파이썬했어요", R.drawable.ic_launcher_background, "나다", LocalDateTime.now(), R.drawable.ic_launcher_background),
    BoardList("파이썬했어요", R.drawable.ic_launcher_background, "나다", LocalDateTime.now(), R.drawable.ic_launcher_background),
    BoardList("파이썬했어요", R.drawable.ic_launcher_background, "나다", LocalDateTime.now(), R.drawable.ic_launcher_background),
)

@SuppressLint("SuspiciousIndentation", "CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val scrollState = rememberLazyListState()
    var height by remember { mutableStateOf(0.dp) }
    var topHeight by remember { mutableStateOf(200.dp) }

    var currentYPos by remember {
        mutableStateOf(0.dp)
    }
    var lastYPos by remember {
        mutableStateOf(0.dp)
    }
    var isDownScroll by remember {
        mutableStateOf(false)

    }

    val yOffset by animateDpAsState(
        targetValue = if (isDownScroll && currentYPos >= 200.dp) (-200).dp else 0.dp,
        animationSpec = tween(300), label = ""
    )

    LaunchedEffect(scrollState.firstVisibleItemScrollOffset) {
        isDownScroll = lastYPos - currentYPos < 0.dp
        lastYPos = currentYPos
        currentYPos = scrollState.firstVisibleItemScrollOffset.dp + scrollState.firstVisibleItemIndex * height
    }

    DbTopBar(
        titleText = NavGroup.Main.HOME.title,
        enablePrimaryButton = false,
        yOffset = yOffset,
        heightCallBack = {
             topHeight = it + 14.dp
        },
        body1 = {
            LazyRow(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 14.dp)
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
    ) {
        LazyColumn(
            modifier = Modifier
                .background(DbTheme.color.Background)
                .padding(horizontal = 14.dp),
            state = scrollState
        ) {
            item {
                Spacer(modifier = Modifier.height(topHeight))
            }
            items(boardListList) {
                DbBoardCard(
                    modifier = Modifier
                        .onGloballyPositioned { coordinates ->
                            if (height == 0.dp) {
                                height = coordinates.size.height.dp
                            }
                        },
                    boardList = it
                )
            }
        }
    }
}