package com.example.petpassport.data.repository

import com.example.petpassport.data.datasource.remote.PetRemoteDataSource
import com.example.petpassport.data.datasource.remote.model.PetDto
import com.example.petpassport.domain.model.Pet
import com.example.petpassport.domain.repository.PetRepository
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
    private val remoteDataSource: PetRemoteDataSource
) : PetRepository {

    override suspend fun savePet(pet: Pet): String {
        val petDto = PetDto.fromPet(pet)
        return remoteDataSource.savePet(petDto)
    }

    override suspend fun getPet(petId: String): Pet? {
        return remoteDataSource.getPet(petId)?.toPet()
    }

    override suspend fun uploadImage(imageBytes: ByteArray): String {
        return remoteDataSource.uploadImage(imageBytes)
    }
}