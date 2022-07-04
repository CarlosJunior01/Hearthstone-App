package com.carlos.hearthstoneapp.domain

import com.carlos.hearthstoneapp.data.HearthstoneRepository
import com.carlos.hearthstoneapp.domain.model.CardBO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCardsUseCase @Inject constructor(
    private val repository: HearthstoneRepository
) {
    fun getCards(className: String): Flow<List<CardBO>> = flow {
        val response = repository.getAllCards(className)
        emit(response)
    }
}