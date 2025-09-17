package com.example.petpassport.presentation.state

import com.example.petpassport.domain.model.Pet

data class PetState(
    val id: String = "",
    val name: String = "",
    val age: Int = 0,
    val breed: String = "",
    val chipNumber: String = "",
    val color: String = "",
    val sex: String = "Мужской",
    val weight: Int = 0,
    val imageBytes: ByteArray? = null,
    val imageUrl: String = "",
    val isLoading: Boolean = false,
    val isSaved: Boolean = false,
    val error: String? = null
) {
    fun toPet(): Pet = Pet(
        id = id,
        name = name,
        age = age,
        breed = breed,
        chipNumber = chipNumber,
        color = color,
        sex = sex,
        weight = weight,
        imageUrl = imageUrl
    )
}