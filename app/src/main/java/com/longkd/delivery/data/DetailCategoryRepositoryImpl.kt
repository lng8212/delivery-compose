package com.longkd.delivery.data

import com.longkd.delivery.R
import com.longkd.delivery.domain.DetailCategory
import com.longkd.delivery.domain.DetailCategoryRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 11:40 - 10/11/24
 */

class DetailCategoryRepositoryImpl @Inject constructor() : DetailCategoryRepository {
    override fun getAllItems(categoryId: String) = flow {
        emit(listData.filter {
            it.categoryId == categoryId
        })
    }
}

val listData = listOf(
    DetailCategory(
        "1",
        "1",
        "Boston Lettuce",
        R.drawable.ic_boston_lettuce,
        1.10f, Unit.PIECE
    ),
    DetailCategory(
        "2",
        "1",
        "Purple Cauliflower",
        R.drawable.ic_purpule_cauliflower,
        1.85f,
        Unit.KILOGRAM
    ),
    DetailCategory(
        "3",
        "1",
        "Savoy Cabbage",
        R.drawable.ic_savoy_cabbage,
        1.45f,
        Unit.KILOGRAM
    ),
    DetailCategory(
        "4",
        "2",
        "Savoy Cabbage",
        R.drawable.ic_savoy_cabbage,
        1.45f,
        Unit.KILOGRAM
    ),
)

enum class Unit(name: String) {
    PIECE("piece"),
    KILOGRAM("kg"),
    GRAM("gram"),
    PACKAGE("package")
}