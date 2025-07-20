package com.example.petpassportnew.presentation.splash

import androidx.lifecycle.viewModelScope
import com.example.mvi.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashViewModel : BaseViewModel<SplashContract.Event, SplashContract.State, SplashContract.Effect>() {

    override fun initialState(): SplashContract.State = SplashContract.State(isLoading = true)

    override fun onEvent(event: SplashContract.Event)
    {
        when (event) {
            SplashContract.Event.OnDataLoaded -> {
                setState { copy(isLoading = false) }
                sendEffect(SplashContract.Effect.NavigateToMain)
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
