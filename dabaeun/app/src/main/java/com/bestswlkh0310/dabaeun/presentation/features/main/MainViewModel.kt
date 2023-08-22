package com.bestswlkh0310.dabaeun.presentation.features.main

import androidx.lifecycle.ViewModel
import com.bestswlkh0310.dabaeun.presentation.features.login.LoginSideEffect
import com.bestswlkh0310.dabaeun.presentation.features.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel(), ContainerHost<MainState, MainSideEffect> {
    override val container = container<MainState, MainSideEffect>(MainState())

    fun updateSelectedTab(it: String) = intent {
        reduce {
            state.copy(selectedTab = it)
        }
    }
}