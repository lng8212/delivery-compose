package com.longkd.delivery.data

import android.content.Context
import com.longkd.delivery.R
import com.longkd.delivery.domain.Category
import com.longkd.delivery.domain.CategoryRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 20:07 - 3/11/24
 */

class CategoryRepositoryImpl @Inject constructor() : CategoryRepository {
    override fun getAllItems(context: Context) = flow {
        emit(
            listOf(
                Category(
                    id = "1",
                    image = R.drawable.img_sample,
                    name = context.getString(R.string.text_vegetables),
                    total = 43
                ),
                Category(
                    id = "2",
                    image = R.drawable.img_sample_1,
                    name = context.getString(R.string.text_fruits),
                    total = 32
                ),
                Category(
                    id = "3",
                    image = R.drawable.img_sample_2,
                    name = context.getString(R.string.text_bread),
                    total = 22
                ),
                Category(
                    id = "4",
                    image = R.drawable.img_sample_3,
                    name = context.getString(R.string.text_sweets),
                    total = 56
                ),
                Category(
                    id = "5",
                    image = R.drawable.img_sample_4,
                    name = context.getString(R.string.text_noodle),
                    total = 30
                ),
                Category(
                    id = "6",
                    image = R.drawable.img_sample_5,
                    name = context.getString(R.string.text_drinks),
                    total = 50
                ),
            )
        )
    }
}