package com.longkd.presentation.detail

import androidx.compose.runtime.Stable
import com.longkd.domain.detailcategory.DetailCategory

/**
 * @Author: longkd
 * @Since: 21:41 - 11/11/24
 */
@Stable
data class DetailCategoryUIState(
    val headerName: String = "",
    val listItem: List<DetailCategory> = emptyList(),
    val searchQuery: String = "",
)