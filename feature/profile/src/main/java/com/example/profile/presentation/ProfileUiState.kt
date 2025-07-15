package com.example.profile.presentation

import com.example.mvi.UiState


data class ProfileUiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = ""
) : UiState
