// feature/settings/presentation/SettingsUiEvent.kt
package com.example.settings.presentation

import com.example.mvi.UiEvent

sealed interface SettingsUiEvent : UiEvent{
    object OnAppear : SettingsUiEvent
    object OnToggleEdit : SettingsUiEvent
    data class OnChangeName(val name: String) : SettingsUiEvent
    data class OnChangeEmail(val email: String) : SettingsUiEvent
    data class OnChangePhone(val phone: String) : SettingsUiEvent
    object OnSave : SettingsUiEvent
}
