package com.bestswlkh0310.dabaeun.root.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.navigation.compose.rememberNavController
import com.bestswlkh0310.dabaeun.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.root.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.observe(
            lifecycleOwner = this,
            state = { initView(it) },
            sideEffect = { initEffect(it) }
        )
    }
    private fun initView(state: MainState) {
        state.enableAutoLogin?.let {
            setContent {
                val navController = rememberNavController()

                DbTheme {
                    Box {
                        NavigationGraph(navController = navController, enableAutoLogin = it)
                    }
                }
            }
        }
    }

    private fun initEffect(sideEffect: MainSideEffect) {
        when (sideEffect) {
            is MainSideEffect.ToastMessage -> {}
        }
    }
}