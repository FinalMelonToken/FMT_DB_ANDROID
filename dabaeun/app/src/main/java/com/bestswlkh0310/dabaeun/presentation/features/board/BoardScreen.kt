package com.bestswlkh0310.dabaeun.presentation.features.board

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbTopBar
import com.bestswlkh0310.dabaeun.presentation.components.basic.Surface
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body1
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label2
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title1
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup

@Composable
fun BoardScreen(
    navController: NavController,
    viewModel: BoardViewModel = hiltViewModel()
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    DbTopBar(
        primaryButtonCallback = {
            navController.popBackStack()
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
                    .padding(top = 10.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        modifier = Modifier
                            .height(12.dp)
                            .width(3.dp),
                        color = DbTheme.color.Android
                    ) {}
                    Label1(text = "안드로이드", modifier = Modifier.padding(start = 8.dp))
                }
                Title1(text = "Android에서 Compose를 써야하는 이유", modifier = Modifier.padding(top = 12.dp))
                Label1(text = "박병춘 - 1992. 6. 12. 10: 12", modifier = Modifier.padding(top = 12.dp))
            }
            Divider(
                color = DbTheme.color.Gray100,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 18.dp)
            )
            Column(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .padding(horizontal = 18.dp)
            ) {
                Body1(text = "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother\n" +
                        "xml has no mother")
            }

        }
    }
}