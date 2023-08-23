package com.bestswlkh0310.dabaeun.presentation.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.data.model.BoardList
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body2
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbShape
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label2
import com.bestswlkh0310.dabaeun.presentation.components.theme.Title1

@Composable
fun DbBoardCard(
    modifier: Modifier = Modifier,
    boardList: BoardList
) {
    Column(
        modifier = modifier.clip(DbTheme.shape.medium)
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
        Row {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(id = boardList.authorProfile),
                contentDescription = ""
            )
            Column {
                Body2(text = boardList.title)
                Label2(text = boardList.createdTime.hour.toString())
            }
        }
    }
}