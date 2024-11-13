package com.longkd.delivery.domain

import kotlinx.coroutines.flow.Flow

/**
 * @Author: longkd
 * @Since: 11:39 - 10/11/24
 */

interface DetailCategoryRepository {
    fun getAllItems(categoryId: String): Flow<List<DetailCategory>>
    suspend fun getItemById(itemId: String): DetailCategory?
}