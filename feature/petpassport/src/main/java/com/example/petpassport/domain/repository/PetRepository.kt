package com.example.petpassport.domain.repository

import com.example.petpassport.domain.model.Pet

interface PetRepository {
    suspend fun savePet(pet: Pet): String
    suspend fun getPet(petId: String): Pet?
    suspend fun uploadImage(imageBytes: ByteArray): String
}