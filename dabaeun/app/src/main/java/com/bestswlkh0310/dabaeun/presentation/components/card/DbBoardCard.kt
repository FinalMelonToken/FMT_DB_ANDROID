package com.bestswlkh0310.dabaeun.presentation.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.entity.BoardList
import com.bestswlkh0310.dabaeun.presentation.components.modifier.dbClickable
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body2
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label2

@Composable
fun DbBoardCard(
    modifier: Modifier = Modifier,
    boardList: BoardList,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .dbClickable(
                rippleEnable = true,
                onClick = onClick)
            .padding(top = 14.dp)
            .padding(horizontal = 14.dp)
    ) {
        val painter = painterResource(id = boardList.thumbnail)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
                .clip(MaterialTheme.shapes.medium),
            painter = painter,
            contentDescription = boardList.title,
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(start = 4.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(41.dp)
                    .clip(CircleShape),
                painter = painterResource(id = boardList.authorProfile),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .padding(start = 14.dp)
            ) {
                Body2(text = boardList.title)
                Spacer(modifier = Modifier.weight(1f))
                Label2(text = boardList.createdTime.hour.toString())
            }
        }
    }
}