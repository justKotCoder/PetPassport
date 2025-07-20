package com.example.settings.domain.usecase

import com.example.settings.domain.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = repository.getCurrentUser()
}
