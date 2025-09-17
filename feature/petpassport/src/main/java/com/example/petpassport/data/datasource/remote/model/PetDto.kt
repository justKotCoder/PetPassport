package com.example.petpassport.data.datasource.remote.model

import com.example.petpassport.domain.model.Pet

data class PetDto(
    val id: String = "",
    val name: String = "",
    val age: Int = 0,
    val breed: String = "",
    val chipNumber: String = "",
    val color: String = "",
    val sex: String = "",
    val weight: Int = 0,
    val ownerId: String = "",
    val imageUrl: String = ""
) {
    // Конвертация в domain model
    fun toPet(): Pet = Pet(
        id = id,
        name = name,
        age = age,
        breed = breed,
        chipNumber = chipNumber,
        color = color,
        sex = sex,
        weight = weight,
        ownerId = ownerId,
        imageUrl = imageUrl
    )

    // Конвертация из domain model
    companion object {
        fun fromPet(pet: Pet): PetDto = PetDto(
            id = pet.id,
            name = pet.name,
            age = pet.age,
            breed = pet.breed,
            chipNumber = pet.chipNumber,
            color = pet.color,
            sex = pet.sex,
            weight = pet.weight,
            ownerId = pet.ownerId,
            imageUrl = pet.imageUrl
        )
    }
}