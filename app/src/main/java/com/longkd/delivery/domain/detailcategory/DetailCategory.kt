package com.longkd.delivery.domain.detailcategory

import androidx.annotation.DrawableRes
import com.longkd.delivery.data.repository.Unit

/**
 * @Author: longkd
 * @Since: 11:35 - 10/11/24
 */

data class DetailCategory(
    val id: String,
    val categoryId: String,
    val name: String,
    @DrawableRes val image: Int,
    val price: Float,
    val unit: Unit,
    val weightPerUnit: String,
    val from: String,
    val description: String,
) {
    fun isMatchWithQuery(queryString: String): Boolean {
        val matchResult = listOf(
            name, price.toString()
        )
        return matchResult.any {
            it.contains(queryString, true)
        }
    }
}