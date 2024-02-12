package com.example.labfintehandroid.domain.di

import com.example.labfintehandroid.domain.repository.DetailsRepository
import com.example.labfintehandroid.domain.repository.DetailsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DetailsModule {

    @Binds
    fun detailsRepositoryImpl_to_detailsRepository(
        detailsRepositoryImpl : DetailsRepositoryImpl
    ) : DetailsRepository

}