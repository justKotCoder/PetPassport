package com.example.petpassport.presentation.intent

sealed class PetIntent {
    data class SetName(val name: String) : PetIntent()
    data class SetAge(val age: Int) : PetIntent()
    data class SetBreed(val breed: String) : PetIntent()
    data class SetChipNumber(val chipNumber: String) : PetIntent()
    data class SetColor(val color: String) : PetIntent()
    data class SetSex(val sex: String) : PetIntent()
    data class SetWeight(val weight: Int) : PetIntent()
    data class SetImage(val imageBytes: ByteArray?) : PetIntent()
    object SavePet : PetIntent()
}