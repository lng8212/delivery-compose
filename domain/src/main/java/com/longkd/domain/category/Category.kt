package com.longkd.domain.category

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * @Author: longkd
 * @Since: 20:06 - 3/11/24
 */
@Serializable
@Parcelize
data class Category(
    val id: String = UUID.randomUUID().toString(),
    @DrawableRes val image: Int,
    val name: String,
    val total: Int,
) : Parcelable {
    fun isMatchWithQuery(queryString: String): Boolean {
        val matchResult = listOf(
            name, total.toString()
        )
        return matchResult.any {
            it.contains(queryString, true)
        }
    }
}
