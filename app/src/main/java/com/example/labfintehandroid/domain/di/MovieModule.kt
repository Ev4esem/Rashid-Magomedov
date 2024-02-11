package com.example.labfintehandroid.domain.di

import com.example.labfintehandroid.domain.repository.MovieRepository
import com.example.labfintehandroid.domain.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MovieModule {

    @Binds
    fun movieRepositoryImpl_to_movieRepository(
        movieRepository : MovieRepositoryImpl
    ) : MovieRepository

}