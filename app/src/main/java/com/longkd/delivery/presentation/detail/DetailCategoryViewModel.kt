package com.longkd.delivery.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.longkd.delivery.domain.DetailCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 10:50 - 9/11/24
 */

@HiltViewModel
class DetailCategoryViewModel @Inject constructor(
    detailCategoryRepository: DetailCategoryRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _searchText = MutableStateFlow("")
    private val itemName = savedStateHandle.toRoute<com.longkd.delivery.DetailCategory>().name
    val uiState: StateFlow<DetailCategoryUIState> = combine(
        _searchText,
        detailCategoryRepository
            .getAllItems(savedStateHandle.toRoute<com.longkd.delivery.DetailCategory>().categoryId)
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
}