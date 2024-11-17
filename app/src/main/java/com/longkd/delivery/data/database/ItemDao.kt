package com.longkd.delivery.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.longkd.delivery.data.database.model.ItemDto
import com.longkd.delivery.domain.item.Item
import kotlinx.coroutines.flow.Flow

/**
 * @Author: longkd
 * @Since: 10:21 - 16/11/24
 */
@Dao
interface ItemDao {
    @Query("SELECT * FROM ITEM")
    fun getAllItem(): Flow<List<ItemDto>>

    @Insert
    suspend fun insertItem(item: ItemDto): Long

    @Delete
    suspend fun deleteItem(item: ItemDto)

    @Query("SELECT * FROM ITEM WHERE ID = :id")
    suspend fun getItemById(id: Int): Item?

    @Query("UPDATE item SET total = :newNumber WHERE id = :id")
    suspend fun updateItemNumber(id: Int, newNumber: Float): Int


}