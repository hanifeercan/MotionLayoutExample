package com.hercan.motionlayoutexample.core.data.di

import com.hercan.motionlayoutexample.core.data.repo.Repository
import com.hercan.motionlayoutexample.core.data.repo.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBookRepository(bookRepositoryImpl: RepositoryImpl): Repository
}