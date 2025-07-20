package com.example.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

abstract class BaseViewModel<E : UiEvent, S : UiState, F : UiEffect> : ViewModel() {

    private val _uiState: MutableStateFlow<S> = MutableStateFlow(initialState())
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    private val _effect = Channel<F>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    protected val state: S get() = _uiState.value

    fun setState(reducer: S.() -> S) {
        _uiState.value = _uiState.value.reducer()
    }

    fun sendEffect(effect: F) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }

    abstract fun onEvent(event: E)
    fun setEvent(event: E) = onEvent(event)

    protected abstract fun initialState(): S
}
