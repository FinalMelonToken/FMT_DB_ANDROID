package com.bestswlkh0310.dabaeun.presentation.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.R
import com.bestswlkh0310.dabaeun.presentation.components.button.DbIconButton
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title1

@Composable
fun DbTopBar(
    enablePrimaryButton: Boolean = true,
    primaryButtonCallback: () -> Unit = {},
    titleText: String = "",
    body: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            if (enablePrimaryButton) {
                DbIconButton(
                    modifier = Modifier,
                    iconId = R.drawable.ic_back,
                    contentDescription = "to back",
                    onClick = primaryButtonCallback
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Title1(
                text = titleText,
            )
        }
        body()
    }
}