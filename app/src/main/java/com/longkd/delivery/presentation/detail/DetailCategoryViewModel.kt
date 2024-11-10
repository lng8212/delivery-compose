package com.longkd.delivery.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.longkd.delivery.domain.DetailCategory
import com.longkd.delivery.domain.DetailCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
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
    val uiState: StateFlow<List<DetailCategory>> =
        detailCategoryRepository
            .getAllItems(savedStateHandle.toRoute<com.longkd.delivery.DetailCategory>().categoryId)
            .stateIn(
                scope = viewModelScope,
                initialValue = emptyList(),
                started = SharingStarted.WhileSubscribed(5_000)
            )
}