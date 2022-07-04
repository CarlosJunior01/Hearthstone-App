package com.carlos.hearthstoneapp.presentation.model

import android.os.Parcelable
import com.carlos.hearthstoneapp.domain.model.CardBO
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardViewObject(
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
    val img: String?
): Parcelable {

    constructor(card: CardBO) : this(
        name = card.name,
        cardSet = card.cardSet,
        type = card.type,
        faction = card.faction,
        rarity = card.rarity,
        cost = card.cost,
        attack = card.attack,
        health = card.health,
        text = card.text,
        flavor = card.flavor,
        img = card.img
    )
}

