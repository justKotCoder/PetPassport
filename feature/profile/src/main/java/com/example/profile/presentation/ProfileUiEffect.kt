package com.example.profile.presentation

import com.example.mvi.UiEffect


sealed interface ProfileUiEffect : UiEffect {
    data class ShowToast(val message: String) : ProfileUiEffect
}
