package com.bestswlkh0310.dabaeun.presentation.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.components.button.DbMediumRoundedButton
import com.bestswlkh0310.dabaeun.presentation.components.input.DbInput

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DbInput(value = state.email, hint = "학교 이메일을 입력하세요", onValueChange = { viewModel.inputEmail(it) })
        Spacer(modifier = Modifier.height(16.dp))
        DbInput(value = state.pw, hint = "비밀번호를 입력하세요", onValueChange = { viewModel.inputPw(it) })
        Spacer(modifier = Modifier.height(16.dp))
        DbMediumRoundedButton(text = "로그인", enable = false) {

        }
    }
}