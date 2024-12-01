package com.longkd.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.longkd.domain.detailcategory.DetailCategoryRepository
import com.longkd.domain.di.Dispatcher
import com.longkd.domain.di.DispatcherType
import com.longkd.domain.item.ItemRepository
import com.longkd.domain.mapper.toItem
import com.longkd.presentation.DetailCategory
import com.longkd.utils.SnackbarController
import com.longkd.utils.SnackbarEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 10:50 - 9/11/24
 */

@HiltViewModel
class DetailCategoryViewModel @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher,
    detailCategoryRepository: DetailCategoryRepository,
    private val itemRepository: ItemRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _searchText = MutableStateFlow("")
    private val itemName = savedStateHandle.toRoute<DetailCategory>().name
    val uiState: StateFlow<DetailCategoryUIState> = combine(
        _searchText,
        detailCategoryRepository
            .getAllItems(savedStateHandle.toRoute<DetailCategory>().categoryId)
    ) { searchText, listData ->
        DetailCategoryUIState(
            headerName = itemName,
            listItem = if (searchText.isEmpty()) listData
            else listData.filter { it.isMatchWithQuery(searchText) },
            searchQuery = searchText
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = DetailCategoryUIState(),
        started = SharingStarted.WhileSubscribed(5_000)
    )

    fun onSearchTextChange(newSearchText: String) {
        _searchText.value = newSearchText
    }

    fun insertItem(item: com.longkd.domain.detailcategory.DetailCategory) {
        viewModelScope.launch(ioDispatcher) {
            val result = itemRepository.addOrUpdateItem(item.id.toInt(), item.toItem())
            if (result != -1L) {
                SnackbarController.sendEvent(SnackbarEvent("Insert successfully: ${item.name}"))
            }
        }
    }
}