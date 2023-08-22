package com.bestswlkh0310.dabaeun.presentation.features.main

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbBottomButton
import com.bestswlkh0310.dabaeun.presentation.components.appbar.DbBottomNavigation
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.components.theme.IcDefault
import com.bestswlkh0310.dabaeun.presentation.components.theme.Label2
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavGroup


@Composable
fun MainBottomNavigation(
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
            .padding(vertical = 4.dp)
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
                        .width(38.dp)
                        .height(44.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    IcDefault(
                        modifier = Modifier
                            .scale(1.1f),
                        icon = item.icon,
                        tint = if (item == selectedTab) DbTheme.color.Gray800 else DbTheme.color.Gray200
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Label2(
                        text = item.title
                    )
                }
            }
        }
    }
}
