package com.longkd.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: longkd
 * @Since: 10:15 - 16/11/24
 */

@Entity(tableName = "item")
data class ItemDto(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "total")
    val total: Float,
    @ColumnInfo(name = "price")
    val price: Float,
    @ColumnInfo(name = "unit")
    val unit: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
)