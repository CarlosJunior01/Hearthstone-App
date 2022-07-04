package com.carlos.hearthstoneapp.data.api

import com.carlos.hearthstoneapp.data.model.CardResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HearthstoneAPI {

    @GET("cards/classes/{class}?collectible=1")
    suspend fun getCards(
        @Path("class") className: String,
        @Query("locale") locale: String = "ptBR"
    ): List<CardResponse>
}