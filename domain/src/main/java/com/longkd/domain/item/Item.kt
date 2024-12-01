package com.longkd.domain.item

/**
 * @Author: longkd
 * @Since: 10:33 - 16/11/24
 */
data class Item(
    val name: String,
    val total: Float? = 1f,
    val price: Float,
    val unit: String,
    val id: Int,
)

