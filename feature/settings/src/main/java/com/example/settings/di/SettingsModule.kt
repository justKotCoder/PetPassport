package com.example.settings.di

import com.example.settings.data.UserRepositoryImpl
import com.example.settings.domain.UserRepository
import com.example.settings.domain.usecase.GetUserUseCase
import com.example.settings.domain.usecase.UpdateUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SettingsModule {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository = UserRepositoryImpl()

    @Provides
    fun provideGetUserUseCase(repository: UserRepository): GetUserUseCase =
        GetUserUseCase(repository)

    @Provides
    fun provideUpdateUserUseCase(repository: UserRepository): UpdateUserUseCase =
        UpdateUserUseCase(repository)
}
