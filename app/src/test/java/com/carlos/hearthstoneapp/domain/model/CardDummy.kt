package com.carlos.hearthstoneapp.domain.model

import kotlin.random.Random

object CardDummy {

    private fun getCardDummy() = CardBO(
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

    fun getListCard() = listOf(getCardDummy())
}