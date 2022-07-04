package com.carlos.hearthstoneapp.domain.model

data class CardBO(
    val cardId: String?,
    val dbfId: String?,
    val name: String?,
    val cardSet: String?,
    val type: String?,
    val faction: String?,
    val rarity: String?,
    val cost: Int?,
    val attack: Int?,
    val health: Int?,
    val text: String?,
    val flavor: String?,
    val artist: String?,
    val playerClass: String?,
    val img: String?,
    val imgGold: String?
)