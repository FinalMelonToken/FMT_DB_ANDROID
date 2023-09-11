package com.bestswlkh0310.dabaeun.presentation.features.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.presentation.components.basic.Surface
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Body2
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label1
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label2
import com.bestswlkh0310.dabaeun.presentation.utils.Category

@Composable
fun QuizItemView(
    modifier: Modifier = Modifier,
    category: Category = Category.None,
    quiz: String,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DbTheme.color.Gray50)
        ) {
            Label1(
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        top = 10.dp),
                text = category.name,
                textColor = category.color)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 10.dp)
            ) {
                Surface(modifier = Modifier
                    .padding(start = 17.dp)
                    .width(3.dp)
                    .height(25.dp),
                    color = category.color) {
                }
                Body1(
                    modifier = Modifier
                        .padding(start = 13.dp),
                    text = quiz
                )
            }
            Label2(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        bottom = 10.dp,
                        top = 10.dp
                        ),
                text = "10시간 31분 남음"
            )
        }
    }
}