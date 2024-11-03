package com.longkd.delivery.domain

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable

/**
 * @Author: longkd
 * @Since: 20:06 - 3/11/24
 */
@Stable
data class Category(@DrawableRes val image: Int, val name: String, val total: Int) {
    fun isMatchWithQuery(queryString: String): Boolean {
        val matchResult = listOf(
            name, total.toString()
        )
        return matchResult.any {
            it.contains(queryString, true)
        }
    }
}
