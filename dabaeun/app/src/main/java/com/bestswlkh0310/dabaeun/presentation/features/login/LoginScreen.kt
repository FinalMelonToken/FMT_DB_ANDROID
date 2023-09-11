package com.bestswlkh0310.dabaeun.presentation.features.login

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.button.DbKeyBoardButton
import com.bestswlkh0310.dabaeun.presentation.components.button.DbMaxWidthButton
import com.bestswlkh0310.dabaeun.presentation.components.input.DbInput
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbColor
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label1
import com.bestswlkh0310.dabaeun.presentation.utils.rememberKeyboardHeight
import com.bestswlkh0310.dabaeun.presentation.utils.rememberKeyboardIsOpen


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    val allEnter = state.pw.isNotBlank() && state.email.isNotBlank()
    val keyboardShow by rememberKeyboardIsOpen()
    val height by rememberKeyboardHeight()
    LaunchedEffect(keyboardShow) {
        Log.d("TAG", "$height - LoginScreen() called")
        Log.d("TAG", "$keyboardShow - LoginScreen() called")
    }
    DbTopBar(
        titleText = "로그인",
        enablePrimaryButton = false,
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                DbInput(
                    value = state.email,
                    hint = "학교 이메일을 입력하세요",
                    onValueChange = { viewModel.inputEmail(it) })
                Spacer(modifier = Modifier.height(22.dp))
                DbInput(
                    value = "*".repeat(state.pw.length),
                    hint = "비밀번호를 입력하세요",
                    onValueChange = { viewModel.inputPw(it) })
                Spacer(modifier = Modifier.weight(1f))
                if (!keyboardShow) {
                    DbMaxWidthButton(text = "로그인", enable = allEnter) {
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row {
                        Label1(text = "아직 계정이 없으신가요? ")
                        Label1(text = "회원가입 ", textColor = DbColor.Blue) {

                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }

            if (keyboardShow)
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    DbKeyBoardButton(text = "로그인", enable = allEnter) {
                    }
                    Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.ime))

                    Log.d("TAG", "${WindowInsets.ime.getBottom(LocalDensity.current)} - LogasdasinScreen() called")
//                    Spacer(modifier = Modifier.height(with(LocalDensity.current) {
//                        height.toDp()
//                    }))
                }
        }
    }
}