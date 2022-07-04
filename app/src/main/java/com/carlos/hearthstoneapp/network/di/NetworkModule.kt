package com.carlos.hearthstoneapp.network.di

import android.content.Context
import com.carlos.hearthstoneapp.network.CheckNetworkConnection
import com.carlos.hearthstoneapp.network.ServiceInterceptor
import com.carlos.hearthstoneapp.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesCheckInternetConnection(
        @ApplicationContext applicationContext: Context
    ) = CheckNetworkConnection(applicationContext)

    @Provides
    fun providesServiceInterceptor(checkNetworkConnection: CheckNetworkConnection) =
        ServiceInterceptor(checkNetworkConnection)

    @Provides
    fun providesServiceProvider(
        serviceInterceptor: ServiceInterceptor
    ) = ServiceProvider(serviceInterceptor)

}
