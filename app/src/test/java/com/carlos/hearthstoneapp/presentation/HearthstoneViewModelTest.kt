package com.carlos.hearthstoneapp.presentation

import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test

class HearthstoneViewModelTest {

    private lateinit var viewModel: HearthstoneViewModel

    @After
    fun tearDown() {
        HearthstoneViewModelRobot.tearDown()
    }

    @Test
    fun `when start viewModel should execute getCards`() {
        HearthstoneViewModelRobot.apply {
            arrange {
                mockSuccess()
            }

            act {
                initViewModel()
            }

            assert {
                isGetCards()
            }
        }
    }

    @Test(expected = RuntimeException::class)
    fun `should throw an exception when the calling to getAllCards returns exception`() = runBlocking {

            coEvery { viewModel.getAllCards("") } throws Exception()

            val result = viewModel.getAllCards("")
        }
}