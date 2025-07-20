package com.example.settings.data


import com.example.settings.domain.User
import com.example.settings.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {

    private var currentUser = User(
        name = "Жан",
        email = "zhang@future.com",
        phone = "+7 999 123 4567"
    )

    override suspend fun getCurrentUser(): User {
        return currentUser
    }

    override suspend fun updateUser(user: User) {
        currentUser = user
    }
}
