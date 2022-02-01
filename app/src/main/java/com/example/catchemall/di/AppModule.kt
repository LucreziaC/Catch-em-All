package com.example.catchemall.di

import com.example.catchemall.repository.PokemonRepository
import com.example.catchemall.repository.PokemonRepositoryImpl
import com.example.catchemall.repository.api.PokemonAPIHelper
import com.example.catchemall.repository.api.PokemonAPIHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindsRemoteDataSource(remoteDataSource: PokemonAPIHelperImpl): PokemonAPIHelper

    @Binds
    @Singleton
    abstract fun bindsRepository(repository: PokemonRepositoryImpl) : PokemonRepository

}

