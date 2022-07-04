package com.carlos.hearthstoneapp.data.model

import kotlin.random.Random

object CardResponseDummy {

    fun getListCardResponseDummy() = listOf(getCardResponseDummy())

    private fun getCardResponseDummy() = CardResponse(
        cardId = "",
        dbfId = "",
        name = "",
        cardSet = "",
        type = "",
        faction = "",
        rarity = "",
        cost = Random.nextInt(),
        attack = Random.nextInt(),
        health = Random.nextInt(),
        text = "",
        flavor = "",
        artist = "",
        playerClass = "",
        img = "",
        imgGold = "",
    )
}