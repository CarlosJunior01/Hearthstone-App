package com.carlos.hearthstoneapp.presentation.model

data class HearthstoneClassVO(
    val name: String
)

fun setListHearthstoneClass() = listOf(
    HearthstoneClassVO(name = "Demon Hunter"),
    HearthstoneClassVO(name = "Druid"),
    HearthstoneClassVO(name = "Hunter"),
    HearthstoneClassVO(name = "Mage"),
    HearthstoneClassVO(name = "Paladin"),
    HearthstoneClassVO(name = "Priest"),
    HearthstoneClassVO(name = "Rogue"),
    HearthstoneClassVO(name = "Shaman"),
    HearthstoneClassVO(name = "Warlock"),
    HearthstoneClassVO(name = "Warrior"),
    HearthstoneClassVO(name = "Neutral")
)
