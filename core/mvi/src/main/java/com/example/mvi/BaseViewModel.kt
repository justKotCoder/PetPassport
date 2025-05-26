package com.example.mvi


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

abstract class BaseViewModel<E : UiEvent, S : UiState, F : UiEffect> : ViewModel() {

    protected val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _uiState = MutableStateFlow(initialState())
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<F>()
    val effect: SharedFlow<F> = _effect.asSharedFlow()

    protected abstract fun initialState(): S

    protected val currentState: S
        get() = _uiState.value

    fun setState(reducer: S.() -> S) {
        _uiState.value = currentState.reducer()
    }

    fun setEffect(builder: () -> F) {
        viewModelScope.launch {
            _effect.emit(builder())
        }
    }

    fun setEvent(event: E) {
        handleEvent(event)
    }

    protected abstract fun handleEvent(event: E)
}
