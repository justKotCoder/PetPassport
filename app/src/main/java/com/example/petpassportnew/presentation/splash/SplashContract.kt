package com.example.petpassportnew.presentation.splash

import com.example.mvi.UiEffect
import com.example.mvi.UiEvent
import com.example.mvi.UiState
class SplashContract {
    data class State(val isLoading: Boolean = true) : UiState

    sealed class Event : UiEvent {
        object OnDataLoaded : Event()
    }

    sealed class Effect : UiEffect {
        object NavigateToMain : Effect()
    }
}
