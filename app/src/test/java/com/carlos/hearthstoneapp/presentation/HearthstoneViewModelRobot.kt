package com.carlos.hearthstoneapp.presentation

import com.carlos.hearthstoneapp.domain.GetAllCardsUseCase
import com.carlos.hearthstoneapp.domain.model.CardDummy
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.flow
import org.junit.Assert

object HearthstoneViewModelRobot {

    private lateinit var viewModel: HearthstoneViewModel
    private val getAllCardsUseCase = mockk<GetAllCardsUseCase>(relaxed = true)

    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    infix fun arrange(func: HearthstoneFragmentArrange.() -> Unit) =
        HearthstoneFragmentArrange().apply(func)

    infix fun act(func: HearthstoneFragmentAct.() -> Unit) =
        HearthstoneFragmentAct().apply(func)

    infix fun assert(func: HearthstoneFragmentAssert.() -> Unit) =
        HearthstoneFragmentAssert().apply(func)


    class HearthstoneFragmentArrange {
        fun mockSuccess() {
            every { getAllCardsUseCase.getCards("") } returns
                    flow { emit(CardDummy.getListCard()) }
        }
    }


    class HearthstoneFragmentAct {
        fun initViewModel() {
            viewModel = HearthstoneViewModel(getAllCardsUseCase)
        }
    }

    class HearthstoneFragmentAssert {

        fun isGetCards() {
            Assert.assertNotNull(viewModel.screenState.value)
        }
    }
}
