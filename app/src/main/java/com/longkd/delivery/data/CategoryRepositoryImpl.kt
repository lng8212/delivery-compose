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
                    image = R.drawable.img_sample,
                    name = context.getString(R.string.text_vegetables),
                    total = 43
                ),
                Category(
                    image = R.drawable.img_sample_1,
                    name = context.getString(R.string.text_fruits),
                    total = 32
                ),
                Category(
                    image = R.drawable.img_sample_2,
                    name = context.getString(R.string.text_bread),
                    total = 22
                ),
                Category(
                    image = R.drawable.img_sample_3,
                    name = context.getString(R.string.text_sweets),
                    total = 56
                ),
                Category(
                    image = R.drawable.img_sample_4,
                    name = context.getString(R.string.text_noodle),
                    total = 30
                ),
                Category(
                    image = R.drawable.img_sample_5,
                    name = context.getString(R.string.text_drinks),
                    total = 50
                ),
            )
        )
    }
}