package com.example.profile.data.model

data class Profile(
    val name: String,
    val email: String,
    val avatarUrl: String? = null
)