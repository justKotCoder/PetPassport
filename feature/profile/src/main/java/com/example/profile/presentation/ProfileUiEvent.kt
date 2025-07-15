package com.example.profile.presentation

import com.example.mvi.UiEvent


sealed interface ProfileUiEvent : UiEvent {
    data object OnAppear : ProfileUiEvent
}
