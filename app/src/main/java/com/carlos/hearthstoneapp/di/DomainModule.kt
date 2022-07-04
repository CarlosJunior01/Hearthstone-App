package com.carlos.hearthstoneapp.di

import com.carlos.hearthstoneapp.data.HearthstoneRepository
import com.carlos.hearthstoneapp.data.HearthstoneRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsDiscoveryRepository(
        discoveryRepositoryImpl: HearthstoneRepositoryImpl
    ): HearthstoneRepository
}