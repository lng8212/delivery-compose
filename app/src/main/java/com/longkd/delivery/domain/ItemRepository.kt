package com.longkd.delivery.domain

import kotlinx.coroutines.flow.Flow

/**
 * @Author: longkd
 * @Since: 10:32 - 16/11/24
 */

interface ItemRepository {
    fun getAllItem(): Flow<List<Item>>
    suspend fun insertItem(item: Item)
    suspend fun deleteItem(item: Item)
    suspend fun addOrUpdateItem(id: Int, item: Item): Long
}