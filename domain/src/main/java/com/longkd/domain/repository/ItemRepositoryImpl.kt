package com.longkd.domain.repository

import com.longkd.data.database.ItemDao
import com.longkd.domain.item.Item
import com.longkd.domain.item.ItemRepository
import com.longkd.domain.mapper.toDto
import com.longkd.domain.mapper.toItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 10:40 - 16/11/24
 */
class ItemRepositoryImpl @Inject constructor(private val itemDao: ItemDao) : ItemRepository {
    override fun getAllItem(): Flow<List<Item>> {
        return itemDao.getAllItem().map { listItem ->
            listItem.map { itemDto ->
                itemDto.toItem()
            }
        }
    }

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(item.toDto())
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item.toDto())
    }

    override suspend fun addOrUpdateItem(id: Int, item: Item): Long {
        val itemDto = itemDao.getItemById(id)
        if (itemDto != null) {
            val updatedNumber = itemDto.total + 1F
            return itemDao.updateItemNumber(id, updatedNumber).toLong()
        } else {
            return itemDao.insertItem(item.toDto())
        }
    }
}