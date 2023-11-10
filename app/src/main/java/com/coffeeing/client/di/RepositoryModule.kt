package com.coffeeing.client.di

import com.coffeeing.client.data.repository.DummyRepositoryImpl
import com.coffeeing.client.data.repository.MainRepositoryImpl
import com.coffeeing.client.domain.repository.DummyRepository
import com.coffeeing.client.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindDummyRepository(
        userRepositoryImpl: DummyRepositoryImpl
    ): DummyRepository

    @Singleton
    @Binds
    fun bindMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository
}