package com.bestswlkh0310.dabaeun.presentation.features.home

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbBottomButton
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbBottomNavigation
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label2
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup


@Composable
fun HomeBottomNavigation(
    selectedTab: NavGroup.Main,
    selectedTabCallback: (NavGroup.Main) -> Unit
) {
    val items = listOf(
        NavGroup.Main.HOME,
        NavGroup.Main.QUIZ,
        NavGroup.Main.MY,
    )

    DbBottomNavigation(
        backgroundColor = Color.Transparent,
        contentColor = Color.Transparent,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .padding(bottom = 4.dp)
    ) {
        items.forEach { item ->
            val selected = item == selectedTab
            val transition = updateTransition(targetState = selected, label = "dividerAnimation")
            val animatedOpacity by transition.animateFloat(
                transitionSpec = { tween(durationMillis = 500) },
                label = "opacity"
            ) {
                if (it) 1f else 0f
            }
            DbBottomButton(
                onClick = {
                    selectedTabCallback(item)
                }
            ) {
                Column (
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Label2(
                        text = item.title,
                        modifier = Modifier
                            .height(26.dp)
                    )
                    if (item == selectedTab) {
                        BottomDivider(item = item.title, animatedOpacity = animatedOpacity)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomDivider(item: String, animatedOpacity: Float) {
    Divider(
        color = MaterialTheme.colorScheme.secondary,
        thickness = 2.dp,
        modifier = Modifier
            .width((item.length * 10).dp)
            .padding(top = 2.dp)
            .graphicsLayer(
                alpha = animatedOpacity,
            )
    )
}