package com.bestswlkh0310.dabaeun.presentation.features.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.R
import com.bestswlkh0310.dabaeun.entity.BoardList
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbScrollTopBar
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.button.ButtonType
import com.bestswlkh0310.dabaeun.presentation.components.button.DbFloatingButton
import com.bestswlkh0310.dabaeun.presentation.components.button.DbSelectButton
import com.bestswlkh0310.dabaeun.presentation.components.card.DbBoardCard
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("SuspiciousIndentation", "CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(
    navController: NavController,
    vm: HomeViewModel = hiltViewModel()
) {
    val state = vm.container.stateFlow.collectAsState().value
    val scrollState = rememberLazyListState()
    var height by remember { mutableStateOf(0.dp) }
    var topHeight by remember { mutableStateOf(112.7619.dp) }

    var currentYPos by remember { mutableStateOf(0.dp) }
    var lastYPos by remember { mutableStateOf(0.dp) }
    var isDownScroll by remember { mutableStateOf(false) }

    Log.d("TAG", "$topHeight - HomeScreen() called")

    val yOffset by animateDpAsState(
        targetValue = if (isDownScroll && currentYPos >= 200.dp) (-200).dp else 0.dp,
        animationSpec = tween(300), label = ""
    )

    val refreshScope = rememberCoroutineScope()
    fun refresh() = refreshScope.launch {
        vm.updateBoardRefresh(true)
        delay(3000)
        vm.updateBoardRefresh(false)
    }

    val refreshState = rememberPullRefreshState(state.isBoardRefresh, ::refresh)

    LaunchedEffect(scrollState.firstVisibleItemScrollOffset) {
        isDownScroll = lastYPos - currentYPos < 0.dp
        lastYPos = currentYPos
        currentYPos = scrollState.firstVisibleItemScrollOffset.dp + scrollState.firstVisibleItemIndex * height
    }

    DbScrollTopBar(
        titleText = NavGroup.Main.HOME.title,
        enablePrimaryButton = false,
        yOffset = yOffset,
        heightCallBack = {
             topHeight = it
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
                            vm.updateSelectedCategory(it)
                        }
                    else
                        DbSelectButton(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            text = it.title
                        ) {
                            vm.updateSelectedCategory(it)
                        }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(refreshState),
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(DbTheme.color.White),
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
                    ) {
                        navController.navigate(NavGroup.Feature.BOARD.title) {
                            launchSingleTop = true
                        }
                    }
                    Divider(
                        color = DbTheme.color.Gray100
                    )
                }
            }
            PullRefreshIndicator(
                refreshing = state.isBoardRefresh,
                state = refreshState,
                modifier = Modifier
                    .padding(top = topHeight)
                    .align(Alignment.TopCenter),
            )
            Column {
                Spacer(modifier = Modifier.weight(1f))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    DbFloatingButton(
                        modifier = Modifier
                            .padding(end = 16.dp, bottom = 22.dp),
                        iconId = R.drawable.ic_pencil
                    ) {
                        navController.navigate(NavGroup.Feature.POST.title) {
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    }
}