package com.example.petpassport.domain.model


data class Pet(
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
)