package com.example.petpassport.di

import com.example.petpassport.data.datasource.remote.PetRemoteDataSource
import com.example.petpassport.data.datasource.remote.PetRemoteDataSourceImpl
import com.example.petpassport.data.repository.PetRepositoryImpl
import com.example.petpassport.domain.repository.PetRepository // Путь к интерфейсу репозитория в домене
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = Firebase.storage


    @Provides
    @Singleton
    fun providePetRemoteDataSource(
        firestore: FirebaseFirestore,
        storage: FirebaseStorage
    ): PetRemoteDataSource {
        return PetRemoteDataSourceImpl(firestore, storage) // Имплементация интерфейса PetRemoteDataSource
    }

    @Provides
    @Singleton
    fun providePetRepository(remoteDataSource: PetRemoteDataSource): PetRepository {
        return PetRepositoryImpl(remoteDataSource) // Имплементация репозитория с использованием remoteDataSource
    }
}
