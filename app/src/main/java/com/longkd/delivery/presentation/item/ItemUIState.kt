package com.longkd.delivery.presentation.item

import androidx.compose.runtime.Stable
import com.longkd.delivery.domain.DetailCategory

/**
 * @Author: longkd
 * @Since: 21:04 - 13/11/24
 */

@Stable
data class ItemUIState(
    val detailCategory: DetailCategory? = null,
)