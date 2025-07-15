package com.example.profile.data.repository


import com.example.profile.data.model.Profile
import com.example.profile.domain.repository.ProfileRepository

class MockProfileRepository : ProfileRepository {
    override suspend fun getProfile(): Profile {
        return Profile(name = "Жан", email = "future.dev@example.com")
    }
}
