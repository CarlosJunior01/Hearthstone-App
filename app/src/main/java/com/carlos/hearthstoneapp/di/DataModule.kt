package com.carlos.hearthstoneapp.di

import com.carlos.hearthstoneapp.data.api.HearthstoneAPI
import com.carlos.hearthstoneapp.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun providesDiscoverApi(
        serviceProvider: ServiceProvider
    ): HearthstoneAPI {
        return serviceProvider.createService(HearthstoneAPI::class.java)
    }
}
