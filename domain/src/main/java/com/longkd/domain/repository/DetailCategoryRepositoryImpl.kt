package com.longkd.domain.repository

import com.longkd.domain.R
import com.longkd.domain.detailcategory.DetailCategory
import com.longkd.domain.detailcategory.DetailCategoryRepository
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

    override suspend fun getItemById(itemId: String): DetailCategory? {
        return listData.find { it.id == itemId }
    }
}

val listData = listOf(
    DetailCategory(
        "1",
        "1",
        "Boston Lettuce",
        R.drawable.ic_boston_lettuce,
        1.10f,
        Unit.PIECE,
        "150g",
        "Spain",
        "A type of vegetables"
    ),
    DetailCategory(
        "2",
        "1",
        "Purple Cauliflower",
        R.drawable.ic_purpule_cauliflower,
        1.85f,
        Unit.KILOGRAM,
        "150g",
        "Spain",
        "A type of vegetables"
    ),
    DetailCategory(
        "3",
        "1",
        "Savoy Cabbage",
        R.drawable.ic_savoy_cabbage,
        1.45f,
        Unit.KILOGRAM,
        "150g",
        "Spain",
        "A type of vegetables"
    ),
    DetailCategory(
        "4",
        "2",
        "Savoy Cabbage",
        R.drawable.ic_savoy_cabbage,
        1.45f,
        Unit.KILOGRAM,
        "150g",
        "Spain",
        "A type of vegetables"
    ),
)

enum class Unit(val value: String) {
    PIECE("piece"),
    KILOGRAM("kg"),
    GRAM("gram"),
    PACKAGE("package")
}