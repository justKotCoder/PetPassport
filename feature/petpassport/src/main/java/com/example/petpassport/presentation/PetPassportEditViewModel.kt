package com.example.petpassport.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petpassport.domain.repository.PetRepository
import com.example.petpassport.domain.usercase.SavePetUseCase
import com.example.petpassport.presentation.intent.PetIntent
import com.example.petpassport.presentation.state.PetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetPassportEditViewModel @Inject constructor(
    private val savePetUseCase: SavePetUseCase,
    private val repository: PetRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PetState())
    val state: StateFlow<PetState> = _state.asStateFlow()

    fun onIntent(intent: PetIntent) {
        when (intent) {
            is PetIntent.SetName -> updateState { it.copy(name = intent.name) }
            is PetIntent.SetAge -> updateState { it.copy(age = intent.age) }
            is PetIntent.SetBreed -> updateState { it.copy(breed = intent.breed) }
            is PetIntent.SetChipNumber -> updateState { it.copy(chipNumber = intent.chipNumber) }
            is PetIntent.SetColor -> updateState { it.copy(color = intent.color) }
            is PetIntent.SetSex -> updateState { it.copy(sex = intent.sex) }
            is PetIntent.SetWeight -> updateState { it.copy(weight = intent.weight) }
            is PetIntent.SetImage -> updateState { it.copy(imageBytes = intent.imageBytes) }
            PetIntent.SavePet -> savePet()
        }
    }

    private fun updateState(update: (PetState) -> PetState) {
        _state.update(update)
    }

    private fun savePet() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            try {
                val currentState = _state.value
                var imageUrl = currentState.imageUrl

                // Загружаем изображение, если есть
                currentState.imageBytes?.let { bytes ->
                    imageUrl = repository.uploadImage(bytes)
                }

                // Сохраняем питомца
                val pet = currentState.toPet().copy(imageUrl = imageUrl)
                val petId = savePetUseCase(pet)

                _state.update {
                    it.copy(
                        isLoading = false,
                        isSaved = true,
                        id = petId,
                        imageUrl = imageUrl
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Unknown error"
                    )
                }
            }
        }
    }
}