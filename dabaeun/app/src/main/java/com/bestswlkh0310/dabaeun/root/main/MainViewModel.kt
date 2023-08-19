package com.bestswlkh0310.dabaeun.root.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

@HiltViewModel
class MainViewModel: ContainerHost<MainState, MainSideEffect>, ViewModel() {
    override val container: Container<MainState, MainSideEffect> = container(MainState())
    
}