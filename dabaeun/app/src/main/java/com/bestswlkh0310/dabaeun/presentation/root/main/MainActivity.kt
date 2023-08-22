package com.bestswlkh0310.dabaeun.presentation.root.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.bestswlkh0310.dabaeun.presentation.components.theme.DbTheme
import com.bestswlkh0310.dabaeun.presentation.root.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe
import tech.thdev.compose.extensions.keyboard.state.MutableExKeyboardStateSource
import tech.thdev.compose.extensions.keyboard.state.foundation.removeFocusWhenKeyboardIsHidden
import tech.thdev.compose.extensions.keyboard.state.localowners.LocalMutableExKeyboardStateSourceOwner


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        viewModel.observe(
            lifecycleOwner = this,
            state = { view(it) },
            sideEffect = { updateEffect(it) }
        )
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    private fun view(state: MainState) {
        setContent {
            val navController = rememberNavController()
            DbTheme {
                Box(
                    modifier = Modifier
                        .background(DbTheme.color.Background)
                        .windowInsetsPadding(WindowInsets.systemBars)
                ) {
                    Box(
                        modifier = Modifier
                            .background(DbTheme.color.Background)
                            .windowInsetsPadding(WindowInsets.safeDrawing)
                    )
                    CompositionLocalProvider(
                        LocalMutableExKeyboardStateSourceOwner provides MutableExKeyboardStateSource() // 2
                    ) {
                        Scaffold(
                            modifier = Modifier
                                .removeFocusWhenKeyboardIsHidden()
                        ) {
                            NavigationGraph(navController = navController, enableAutoLogin = state.enableAutoLogin)
                        }
                    }
                }
            }
        }
    }

    private fun updateEffect(sideEffect: MainSideEffect) {
        when (sideEffect) {
            is MainSideEffect.ToastMessage -> {}
        }
    }
}