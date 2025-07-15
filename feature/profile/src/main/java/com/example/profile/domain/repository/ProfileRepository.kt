package com.example.profile.domain.repository


import com.example.profile.data.model.Profile

interface ProfileRepository {
    suspend fun getProfile(): Profile
}
