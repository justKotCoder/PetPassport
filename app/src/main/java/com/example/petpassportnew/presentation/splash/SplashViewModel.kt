package com.example.petpassportnew.presentation.splash

import com.example.mvi.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashViewModel : BaseViewModel<SplashContract.Event, SplashContract.State, SplashContract.Effect>() {

    override fun initialState(): SplashContract.State = SplashContract.State(isLoading = true)

    override fun handleEvent(event: SplashContract.Event) {
        when (event) {
            SplashContract.Event.OnDataLoaded -> {
                setState { copy(isLoading = false) }
                setEffect { SplashContract.Effect.NavigateToMain }
            }

            else -> {}
        }
    }

    init {
        viewModelScope.launch {
            // эмуляция "настоящей" загрузки — например:
            // - Room.getPet()
            // - Firebase.init()
            delay(2500)
            setEvent(SplashContract.Event.OnDataLoaded)
        }
    }
}
