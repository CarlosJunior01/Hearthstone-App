package com.carlos.hearthstoneapp.network

import com.carlos.hearthstoneapp.BuildConfig
import com.carlos.hearthstoneapp.network.exception.NoNetworkConnectionException
import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor(
    private val checkNetworkConnection: CheckNetworkConnection
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (checkNetworkConnection.isAvailable()) {
            val newUrl = chain.request().url.newBuilder()
                .build()

            return chain.proceed(
                chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", BuildConfig.apiToken)
                    .url(newUrl)
                    .build()
            )
        } else {
            throw NoNetworkConnectionException()
        }
    }
}