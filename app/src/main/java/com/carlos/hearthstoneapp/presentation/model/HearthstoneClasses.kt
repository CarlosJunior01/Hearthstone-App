package com.carlos.hearthstoneapp.presentation.model

data class HearthstoneClassVO(
    val name: String
)

fun setListHearthstoneClass() = listOf(
    HearthstoneClassVO(name = "Death Knight"),
    HearthstoneClassVO(name = "Druid"),
    HearthstoneClassVO(name = "Hunter"),
    HearthstoneClassVO(name = "Mage"),
    HearthstoneClassVO(name = "Paladin"),
    HearthstoneClassVO(name = "Priest"),
    HearthstoneClassVO(name = "Rogue"),
    HearthstoneClassVO(name = "Shaman"),
    HearthstoneClassVO(name = "Warlock"),
    HearthstoneClassVO(name = "Warrior"),
    HearthstoneClassVO(name = "Dream"),
    HearthstoneClassVO(name = "Neutral"),
    HearthstoneClassVO(name = "Whizbang"),
    HearthstoneClassVO(name = "Demon Hunter")
)

