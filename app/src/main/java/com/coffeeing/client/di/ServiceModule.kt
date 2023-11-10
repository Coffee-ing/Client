package com.coffeeing.client.di

import com.coffeeing.client.data.service.DummyService
import com.coffeeing.client.data.service.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Singleton
    @Provides
    fun provideDummyService(retrofit: Retrofit): DummyService =
        retrofit.create(DummyService::class.java)

    @Singleton
    @Provides
    fun provideHomeService(retrofit: Retrofit): MainService =
        retrofit.create(MainService::class.java)
}