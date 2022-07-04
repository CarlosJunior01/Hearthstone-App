package com.carlos.hearthstoneapp.domain

import com.carlos.hearthstoneapp.data.HearthstoneRepository
import com.carlos.hearthstoneapp.domain.model.CardDummy
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class GetAllCardsUseCaseTest {

    private lateinit var getAllCardsUseCase: GetAllCardsUseCase

    private val repository = mockk<HearthstoneRepository>()

    @Before
    fun setup() {
        getAllCardsUseCase = GetAllCardsUseCase(repository)
    }

    @Test
    fun `when getAllCards return success with a card list`() = runBlocking {

        //GIVEN
        coEvery { repository.getAllCards("") } returns
                CardDummy.getListCard()

        //WHEN
        val result = getAllCardsUseCase.getCards("")

        //THEN
        assertNotNull(result.single())
    }

    @Test(expected = Exception::class)
    fun `getAllCards throws generic exception`() = runBlocking {

        //GIVEN
        coEvery { repository.getAllCards("") } throws Exception()

        //WHEN
        val result = repository.getAllCards("")
    }
}