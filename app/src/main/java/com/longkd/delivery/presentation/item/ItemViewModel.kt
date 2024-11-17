package com.longkd.delivery.presentation.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.longkd.delivery.Item
import com.longkd.delivery.data.di.Dispatcher
import com.longkd.delivery.data.di.DispatcherType
import com.longkd.delivery.data.mapper.toItem
import com.longkd.delivery.domain.detailcategory.DetailCategory
import com.longkd.delivery.domain.detailcategory.DetailCategoryRepository
import com.longkd.delivery.domain.item.ItemRepository
import com.longkd.delivery.util.SnackbarController
import com.longkd.delivery.util.SnackbarEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
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
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher,
    private val itemRepository: ItemRepository,
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

    fun insertItem(item: DetailCategory) {
        viewModelScope.launch(ioDispatcher) {
            val result = itemRepository.addOrUpdateItem(item.id.toInt(), item.toItem())
            if (result != -1L) {
                SnackbarController.sendEvent(SnackbarEvent("Insert successfully: ${item.name}"))
            }
        }
    }

}