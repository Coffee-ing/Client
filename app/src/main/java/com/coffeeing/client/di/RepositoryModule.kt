package com.coffeeing.client.di

import com.coffeeing.client.data.repository.DummyRepositoryImpl
import com.coffeeing.client.data.repository.MainRepositoryImpl
import com.coffeeing.client.data.repository.MypageRepositoryImpl
import com.coffeeing.client.domain.repository.DummyRepository
import com.coffeeing.client.domain.repository.MainRepository
import com.coffeeing.client.domain.repository.MypageRepository
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

    @Binds
    @Singleton
    fun bindMypageRepository(
        mypageRepositoryImpl: MypageRepositoryImpl,
    ): MypageRepository

    @Singleton
    @Binds
    fun bindMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository
}