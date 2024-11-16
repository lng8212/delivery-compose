package com.longkd.delivery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.longkd.delivery.data.database.model.ItemDto

/**
 * @Author: longkd
 * @Since: 10:24 - 16/11/24
 */

@Database(entities = [ItemDto::class], version = 1, exportSchema = false)
abstract class DeliveryDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
