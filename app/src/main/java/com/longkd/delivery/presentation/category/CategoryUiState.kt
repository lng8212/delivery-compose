package com.longkd.delivery.presentation.category

import androidx.compose.runtime.Stable
import com.longkd.delivery.domain.Category

/**
 * @Author: longkd
 * @Since: 20:22 - 3/11/24
 */
@Stable
data class CategoryUiState(
    val listData: List<Category> = emptyList(),
)
