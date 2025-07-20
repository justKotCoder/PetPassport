package com.example.settings.presentation

import androidx.lifecycle.viewModelScope
import com.example.mvi.BaseViewModel
import com.example.settings.domain.User
import com.example.settings.domain.usecase.GetUserUseCase
import com.example.settings.domain.usecase.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase
) : BaseViewModel< SettingsUiEvent,SettingsUiState, SettingsUiEffect>() {

    override fun initialState(): SettingsUiState = SettingsUiState()

    override fun onEvent(event: SettingsUiEvent) {
        when (event) {
            is SettingsUiEvent.OnAppear -> loadUser()
            is SettingsUiEvent.OnToggleEdit -> setState { copy(isEditMode = !isEditMode) }
            is SettingsUiEvent.OnChangeName -> setState { copy(name = event.name) }
            is SettingsUiEvent.OnChangeEmail -> setState { copy(email = event.email) }
            is SettingsUiEvent.OnChangePhone -> setState { copy(phone = event.phone) }
            is SettingsUiEvent.OnSave -> saveUser()
        }
    }

    private fun loadUser() {
        viewModelScope.launch {
            setState { copy(isLoading = true) }
            val user = getUserUseCase()
            setState {
                copy(
                    name = user.name,
                    email = user.email,
                    phone = user.phone,
                    isLoading = false
                )
            }
        }
    }

    private fun saveUser() {
        viewModelScope.launch {
            updateUserUseCase(
                User(name = state.name, email = state.email, phone = state.phone)
            )
            sendEffect(SettingsUiEffect.ShowToast("Данные обновлены"))
            setState { copy(isEditMode = false) }
        }
    }
}
