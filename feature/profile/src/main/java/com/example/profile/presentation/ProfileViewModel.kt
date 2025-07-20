package com.example.profile.presentation

import androidx.lifecycle.viewModelScope
import com.example.mvi.BaseViewModel
import com.example.profile.domain.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : BaseViewModel<ProfileUiEvent, ProfileUiState, ProfileUiEffect>() {

    override fun initialState() = ProfileUiState()

    override fun onEvent(event: ProfileUiEvent) {
        when (event) {
            ProfileUiEvent.OnAppear -> loadProfile()
        }
    }

    private fun loadProfile() {
        setState { copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val profile = repository.getProfile()
                setState {
                    copy(
                        isLoading = false,
                        name = profile.name,
                        email = profile.email
                    )
                }
            } catch (e: Exception) {
                setState { copy(isLoading = false) }
                sendEffect(ProfileUiEffect.ShowToast("Ошибка загрузки профиля"))
            }
        }
    }
}
