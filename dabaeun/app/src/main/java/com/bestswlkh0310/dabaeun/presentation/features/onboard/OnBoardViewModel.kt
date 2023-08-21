package com.bestswlkh0310.dabaeun.presentation.features.onboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(

): ViewModel(), ContainerHost<OnBoardState, OnBoardSideEffect> {
    override val container = container<OnBoardState, OnBoardSideEffect>(OnBoardState())

    fun updatePage(page: Int) = intent {
        reduce {
            state.copy(page = page)
        }
    }
}