package com.bestswlkh0310.dabaeun.presentation.features.quiz

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(

): ViewModel(), ContainerHost<QuizState, QuizSideEffect> {
    override val container = container<QuizState, QuizSideEffect>(QuizState())

}