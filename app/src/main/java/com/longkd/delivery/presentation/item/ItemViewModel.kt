package com.longkd.delivery.presentation.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.longkd.delivery.Item
import com.longkd.delivery.domain.DetailCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 20:59 - 13/11/24
 */

@HiltViewModel
class ItemViewModel @Inject constructor(
    detailCategoryRepository: DetailCategoryRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ItemUIState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    detailCategory = detailCategoryRepository.getItemById(
                        savedStateHandle.toRoute<Item>().itemId
                    )
                )
            }
        }
    }

}