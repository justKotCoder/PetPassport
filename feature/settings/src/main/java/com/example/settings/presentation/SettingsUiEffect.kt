package com.example.settings.presentation

import com.example.mvi.UiEffect

sealed interface SettingsUiEffect: UiEffect {
    data class ShowToast(val message: String) : SettingsUiEffect
}
