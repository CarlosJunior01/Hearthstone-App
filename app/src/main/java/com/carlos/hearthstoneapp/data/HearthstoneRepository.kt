package com.carlos.hearthstoneapp.data

import com.carlos.hearthstoneapp.domain.model.CardBO

interface HearthstoneRepository {
    suspend fun getAllCards(className: String): List<CardBO>
}