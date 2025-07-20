package com.example.settings.presentation

import com.example.mvi.UiState

data class SettingsUiState(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val isLoading: Boolean = false,
    val isEditMode: Boolean = false
): UiState