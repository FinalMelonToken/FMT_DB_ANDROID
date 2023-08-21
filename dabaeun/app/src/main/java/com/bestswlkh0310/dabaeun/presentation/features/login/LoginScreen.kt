package com.bestswlkh0310.dabaeun.presentation.features.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.button.DbLargeRoundedButton
import com.bestswlkh0310.dabaeun.presentation.components.button.DbMaxWidthButton
import com.bestswlkh0310.dabaeun.presentation.components.button.DbMediumRoundedButton
import com.bestswlkh0310.dabaeun.presentation.components.input.DbInput
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbColor
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label2

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val allEnter = state.pw.isNotBlank() && state.email.isNotBlank()

    DbTopBar(
        titleText = "로그인"
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp)
                .background(DbTheme.color.Background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            DbInput(value = state.email, hint = "학교 이메일을 입력하세요", onValueChange = { viewModel.inputEmail(it) })
            Spacer(modifier = Modifier.height(22.dp))
            DbInput(value = "*".repeat(state.pw.length), hint = "비밀번호를 입력하세요", onValueChange = { viewModel.inputPw(it) })
            Spacer(modifier = Modifier.weight(1f))
            DbMaxWidthButton(text = "로그인", enable = allEnter) {
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row{
                Label1(text = "아직 계정이 없으신가요? ")
                Label1(text = "회원가입 ", textColor = DbColor.Blue) {

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}