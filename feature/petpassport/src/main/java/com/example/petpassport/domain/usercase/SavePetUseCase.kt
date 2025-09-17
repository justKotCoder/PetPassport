package com.example.petpassport.domain.usercase

import com.example.petpassport.domain.model.Pet
import com.example.petpassport.domain.repository.PetRepository
import jakarta.inject.Inject

class SavePetUseCase @Inject constructor(
    private val repository: PetRepository
) {
    suspend operator fun invoke(pet: Pet): String {
        return repository.savePet(pet)
    }
}