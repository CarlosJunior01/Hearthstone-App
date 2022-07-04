package com.carlos.hearthstoneapp.data

import com.carlos.hearthstoneapp.data.api.HearthstoneAPI
import com.carlos.hearthstoneapp.data.model.CardResponseDummy
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HearthstoneRepositoryImplTest {

    private lateinit var hearthstoneRepositoryImpl: HearthstoneRepositoryImpl

    @MockK
    lateinit var hearthstoneService: HearthstoneAPI

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        hearthstoneRepositoryImpl = HearthstoneRepositoryImpl(hearthstoneService)
    }

    @Test
    fun `getCards return success with a list of cards`() = runBlocking {

        //GIVEN
        coEvery { hearthstoneService.getCards("") } returns
                CardResponseDummy.getListCardResponseDummy()

        //WHEN
        val result = hearthstoneRepositoryImpl.getAllCards("")

        //THEN
        Assert.assertFalse(result.isEmpty())
    }

    @Test(expected = Exception::class)
    fun `getCards throws generic exception`() = runBlocking {

        //GIVEN
        coEvery { hearthstoneService.getCards("") } throws Exception()

        //WHEN
        val result = hearthstoneRepositoryImpl.getAllCards("")

    }
}