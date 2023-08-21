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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.button.ButtonType
import com.bestswlkh0310.dabaeun.presentation.components.button.DbMaxWidthButton
import com.bestswlkh0310.dabaeun.presentation.components.input.DbInput
import com.bestswlkh0310.dabaeun.presentation.components.modifier.dbClickable
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body1
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbColor
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title2
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

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
            .padding(horizontal = 14.dp)
            .background(DbTheme.color.Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            ) {
                Title1(text = "어쩌구 저쩌구")
                Row {
                    Title1(text = "어쩌구 저쩌구")
                }
            }
            HorizontalPager(
                modifier = Modifier
                    .background(DbTheme.color.White)
                    .align(Alignment.CenterHorizontally),
                pageCount = 3,
                state = pagerState
            ) { page ->
                Text(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    text = page.toString()
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        DbMaxWidthButton(text = "로그인") {
            navController.navigate(NavGroup.Auth.LOGIN)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Body1(
            text = "회원가입",
            modifier = Modifier
                .dbClickable {
                    Log.d("TAG", " - OnBoardScreen() called")
                    navController.navigate(NavGroup.Auth.LOGIN)

                },
            textColor = DbTheme.color.Blue
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}