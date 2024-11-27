package com.longkd.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longkd.domain.user.DeliveryOptions
import com.longkd.domain.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 10:08 - 16/11/24
 */

@HiltViewModel
class CartViewModel @Inject constructor(
    userRepository: UserRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(CartUiState.initial())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                userData = userRepository.getUser()
            )
        }
    }

    fun updateDeliveryOptions(options: DeliveryOptions) {
        _uiState.value = _uiState.value.copy(
            deliveryOptions = options
        )
    }

    fun updateContactState() {
        _uiState.value = _uiState.value.copy(
            isNonContact = !_uiState.value.isNonContact
        )
    }

}