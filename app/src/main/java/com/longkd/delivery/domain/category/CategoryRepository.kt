package com.longkd.delivery.domain.category

import android.content.Context
import kotlinx.coroutines.flow.Flow

/**
 * @Author: longkd
 * @Since: 20:04 - 3/11/24
 */
interface CategoryRepository {
    fun getAllItems(context: Context): Flow<List<Category>>
}