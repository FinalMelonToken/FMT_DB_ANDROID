package com.bestswlkh0310.dabaeun.presentation.features.post

import androidx.lifecycle.ViewModel
import com.bestswlkh0310.dabaeun.presentation.features.board.BoardSideEffect
import com.bestswlkh0310.dabaeun.presentation.features.board.BoardState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(

): ViewModel(), ContainerHost<PostState, PostSideEffect> {
    override val container = container<PostState, PostSideEffect>(PostState())

    fun updateTitle(it: String) = intent {
        reduce {
            state.copy(title = it)
        }
    }

    fun updateContent(it: String) = intent {
        reduce {
            state.copy(content = it)
        }
    }
}