package com.bestswlkh0310.dabaeun.presentation.features.home

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
class HomeViewModel @Inject constructor(

): ViewModel(), ContainerHost<HomeState, HomeSideEffect> {
    override val container = container<HomeState, HomeSideEffect>(HomeState())

}