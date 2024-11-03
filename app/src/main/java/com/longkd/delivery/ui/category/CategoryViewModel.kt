package com.longkd.delivery.ui.category

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longkd.delivery.domain.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 22:46 - 1/11/24
 */

@HiltViewModel
class CategoryViewModel @Inject constructor(
    categoryRepository: CategoryRepository,
    @ApplicationContext context: Context,
) : ViewModel() {
    private val _searchText = MutableStateFlow("")

    val uiState: StateFlow<CategoryUiState> = combine(
        categoryRepository.getAllItems(context),
        _searchText
    ) { listData, searchText ->
        CategoryUiState(
            listData = if (searchText.isEmpty()) listData
            else listData.filter { it.isMatchWithQuery(searchText) }
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = CategoryUiState(emptyList()),
        started = SharingStarted.WhileSubscribed(5_000)
    )

    fun onSearchTextChange(newSearchText: String) {
        _searchText.value = newSearchText
    }
}