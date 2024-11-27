package com.longkd.presentation.item

import androidx.compose.runtime.Stable
import com.longkd.domain.detailcategory.DetailCategory

/**
 * @Author: longkd
 * @Since: 21:04 - 13/11/24
 */

@Stable
data class ItemUIState(
    val detailCategory: DetailCategory? = null,
)