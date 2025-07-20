package com.example.settings.domain.usecase

import com.example.settings.domain.User
import com.example.settings.domain.UserRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User) = repository.updateUser(user)
}
