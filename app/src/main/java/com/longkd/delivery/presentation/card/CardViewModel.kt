package com.longkd.delivery.presentation.card

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.longkd.delivery.Card
import com.longkd.delivery.domain.card.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 22:02 - 18/11/24
 */

@HiltViewModel
class CardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val cardRepository: CardRepository,
) : ViewModel() {

    private val cardId = savedStateHandle.toRoute<Card>().id
    private val _uiState = MutableStateFlow(CardUiState.initial())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                card = cardRepository.getCardInfo(cardId)
            )
        }
    }

    fun onChangeName(newName: String) {
        _uiState.value = _uiState.value.copy(
            card = _uiState.value.card?.copy(
                name = newName
            )
        )
    }

    fun onChangeCardNumber(newNumber: String) {
        _uiState.value = _uiState.value.copy(
            card = _uiState.value.card?.copy(
                number = newNumber
            )
        )
    }

    fun onChangeExpireDate(newExpireDate: String) {
        _uiState.value = _uiState.value.copy(
            card = _uiState.value.card?.copy(
                expireDate = newExpireDate
            )
        )
    }

    fun onChangeCVC(newCVC: String) {
        _uiState.value = _uiState.value.copy(
            card = _uiState.value.card?.copy(
                cvc = newCVC.toInt()
            )
        )
    }

}