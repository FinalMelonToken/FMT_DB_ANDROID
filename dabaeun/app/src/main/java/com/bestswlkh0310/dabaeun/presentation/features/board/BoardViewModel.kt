package com.bestswlkh0310.dabaeun.presentation.features.board

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(

): ViewModel(), ContainerHost<BoardState, BoardSideEffect> {
    override val container = container<BoardState, BoardSideEffect>(BoardState())

}