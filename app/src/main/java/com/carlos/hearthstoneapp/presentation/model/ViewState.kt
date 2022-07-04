package com.carlos.hearthstoneapp.presentation.model

sealed class StateResponse {
    object StateLoading : StateResponse()
    data class StateSuccess(val cardVO: List<CardViewObject>) : StateResponse()
    object StateError : StateResponse()
}