package com.example.networkexample.common.di

import com.example.networkexample.common.network.ApiClient
import com.example.networkexample.common.repository.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(apiClient: ApiClient): MainRepo = MainRepo(apiClient)

}