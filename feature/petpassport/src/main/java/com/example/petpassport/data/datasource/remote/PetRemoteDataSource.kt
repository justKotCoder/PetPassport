package com.example.petpassport.data.datasource.remote

import com.example.petpassport.data.datasource.remote.model.PetDto
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.UUID
import javax.inject.Inject

interface PetRemoteDataSource {
    suspend fun savePet(pet: PetDto): String
    suspend fun getPet(petId: String): PetDto?
    suspend fun uploadImage(imageBytes: ByteArray): String
}

class PetRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) : PetRemoteDataSource {

    override suspend fun savePet(pet: PetDto): String = withContext(Dispatchers.IO) {
        try {
            val document = if (pet.id.isNotEmpty()) {
                firestore.collection("pets").document(pet.id)
            } else {
                firestore.collection("pets").document()
            }

            val petWithId = pet.copy(id = document.id)
            document.set(petWithId).await()
            document.id
        } catch (e: Exception) {
            throw IOException("Failed to save pet", e)
        }
    }

    override suspend fun getPet(petId: String): PetDto? = withContext(Dispatchers.IO) {
        try {
            val document = firestore.collection("pets").document(petId).get().await()
            document.toObject(PetDto::class.java)
        } catch (e: Exception) {
            throw IOException("Failed to get pet", e)
        }
    }

    override suspend fun uploadImage(imageBytes: ByteArray): String = withContext(Dispatchers.IO) {
        try {
            // Получаем корневую ссылку на Storage и спускаемся в подпапку
            val ref = storage.reference.child("pet_images/${UUID.randomUUID()}.jpg")

            // Загружаем байты и дожидаемся завершения
            ref.putBytes(imageBytes).await()

            // Берём downloadUrl и возвращаем как строку
            ref.downloadUrl.await().toString()
        } catch (e: Exception) {
            throw IOException("Failed to upload image", e)
        }
    }

}