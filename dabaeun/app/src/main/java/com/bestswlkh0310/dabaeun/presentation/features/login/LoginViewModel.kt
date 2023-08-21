package com.bestswlkh0310.dabaeun.presentation.features.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel(), ContainerHost<LoginState, LoginSideEffect> {
    override val container = container<LoginState, LoginSideEffect>(LoginState())


    fun inputEmail(text: String) = intent {
        reduce { state.copy(email = text) }
    }

    fun inputPw(text: String) = intent {
        reduce { state.copy(pw = text) }
    }
}