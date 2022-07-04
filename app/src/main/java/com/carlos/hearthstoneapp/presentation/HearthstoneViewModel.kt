package com.carlos.hearthstoneapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlos.hearthstoneapp.domain.GetAllCardsUseCase
import com.carlos.hearthstoneapp.presentation.model.CardViewObject
import com.carlos.hearthstoneapp.presentation.model.StateResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HearthstoneViewModel @Inject constructor(
    private val getAllCardsUseCase: GetAllCardsUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow<StateResponse>(StateResponse.StateLoading)
    val screenState: StateFlow<StateResponse> = _viewState

    fun getAllCards(className: String) {

        viewModelScope.launch {

            getAllCardsUseCase.getCards(className)
                .onStart {
                    _viewState.value = StateResponse.StateLoading
                }
                .catch {
                    _viewState.value = StateResponse.StateError
                }
                .collect {
                    val eventsViewObject = it.map { cards -> CardViewObject(cards) }
                    _viewState.value = StateResponse.StateSuccess(cardVO = eventsViewObject)
                }
        }
    }
}