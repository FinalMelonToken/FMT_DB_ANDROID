package com.bestswlkh0310.dabaeun.presentation.features.my

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(

): ViewModel(), ContainerHost<MyState, MySideEffect> {
    override val container = container<MyState, MySideEffect>(MyState())

}