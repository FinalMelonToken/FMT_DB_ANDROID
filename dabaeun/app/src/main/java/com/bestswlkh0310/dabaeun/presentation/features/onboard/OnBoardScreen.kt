package com.bestswlkh0310.dabaeun.presentation.features.onboard

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.button.ButtonType
import com.bestswlkh0310.dabaeun.presentation.components.button.DbMaxWidthButton
import com.bestswlkh0310.dabaeun.presentation.components.input.DbInput
import com.bestswlkh0310.dabaeun.presentation.components.modifier.dbClickable
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body1
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbColor
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTypography
import com.bestswlkh0310.dabaeun.presentation.components.theme.Headline1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Headline2
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title2
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

private val titleList = arrayListOf(
    Triple("내 친구는 지금", "어떤 공부", "를 할까요?"),
    Triple("내 친구의", "실시간 공부 소식", "알기"),
    Triple("내 친구의", "실시간 공부 소식", "알기"),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardScreen(
    navController: NavController,
    viewModel: OnBoardViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState()
    val state = viewModel.container.stateFlow.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
        ) {
            val item = titleList[pagerState.currentPage]
            Title1(text = item.first, style = DbTypography.title1.copy(fontWeight = FontWeight.Bold))
            Row {
                Title1(text = item.second, textColor = DbTheme.color.Blue, style = DbTypography.title1.copy(fontWeight = FontWeight.Bold))
                Title1(text = item.third, style = DbTypography.title1.copy(fontWeight = FontWeight.Bold))
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .align(Alignment.CenterHorizontally)) {
            HorizontalPager(
                modifier = Modifier
                    .background(DbTheme.color.White)
                    ,
                pageCount = 3,
                state = pagerState
            ) { page ->
                Box(
                    modifier = Modifier
                        .height(350.dp),
                )
            }
        }
        Spacer(modifier = Modifier.height(36.dp))

        Row( 
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(titleList.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) DbTheme.color.MainColor else DbTheme.color.Gray200
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        DbMaxWidthButton(text = "시작하기") {
            navController.popBackStack()
            navController.navigate(NavGroup.Auth.LOGIN.title) {
                launchSingleTop = true
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}