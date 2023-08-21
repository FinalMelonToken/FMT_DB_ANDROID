package com.bestswlkh0310.dabaeun.presentation.components.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme

@Composable
fun LoadInFullScreen(
    modifier: Modifier = Modifier,
    background: Color = DbTheme.color.White,
) {

//    val composition by rememberLottieComposition(
//        spec = LottieCompositionSpec.RawRes(R.raw.anim_loading)
//    )
//    val progress by animateLottieCompositionAsState(
//        composition = composition,
//        iterations = LottieConstants.IterateForever
//    )
//
//    Box(
//        modifier = modifier
//            .background(color = background)
//            .fillMaxSize()
//    ) {
//        LottieAnimation(
//            modifier = Modifier
//                .size(100.dp)
//                .align(Alignment.Center),
//            composition = composition,
//            progress = { progress },
//
//        )
//    }
}


@Preview
@Composable
fun a() {
    LoadInFullScreen()
}