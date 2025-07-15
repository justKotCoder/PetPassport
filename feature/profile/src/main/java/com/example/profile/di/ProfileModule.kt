package com.example.profile.di

import com.example.profile.data.repository.MockProfileRepository
import com.example.profile.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {

    @Provides
    @Singleton
    fun provideProfileRepository(): ProfileRepository {
        return MockProfileRepository()
    }
}
