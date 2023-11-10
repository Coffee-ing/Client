package com.coffeeing.client.di

import com.coffeeing.client.data.repository.DummyRepositoryImpl
import com.coffeeing.client.data.repository.HomeRepositoryImpl
import com.coffeeing.client.domain.repository.DummyRepository
import com.coffeeing.client.domain.repository.HomeRepository
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
    fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}