package com.example.settings.domain


interface UserRepository {
    suspend fun getCurrentUser(): User
    suspend fun updateUser(user: User)
}