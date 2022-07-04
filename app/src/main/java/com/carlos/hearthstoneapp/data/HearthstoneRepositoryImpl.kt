package com.carlos.hearthstoneapp.data

import com.carlos.hearthstoneapp.data.api.HearthstoneAPI
import com.carlos.hearthstoneapp.data.exception.HearthstoneRepositoryException
import com.carlos.hearthstoneapp.data.model.toDomain
import com.carlos.hearthstoneapp.domain.model.CardBO
import javax.inject.Inject

class HearthstoneRepositoryImpl @Inject constructor(
    private val hearthstoneService: HearthstoneAPI
) : HearthstoneRepository {

    override suspend fun getAllCards(className: String): List<CardBO> {
        return try {
            hearthstoneService.getCards(className).map { it.toDomain() }
        } catch (ex: Exception) {
            throw HearthstoneRepositoryException()
        }
    }
}
