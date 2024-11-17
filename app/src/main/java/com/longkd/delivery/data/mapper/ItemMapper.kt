package com.longkd.delivery.data.mapper

import com.longkd.delivery.data.database.model.ItemDto
import com.longkd.delivery.domain.detailcategory.DetailCategory
import com.longkd.delivery.domain.item.Item

/**
 * @Author: longkd
 * @Since: 10:37 - 16/11/24
 */


fun Item.toDto(initialValue: Float = 1F) = ItemDto(
    name = name,
    total = total ?: initialValue,
    price = price,
    unit = unit,
    id = id
)

fun ItemDto.toItem() = Item(
    name = name,
    total = total,
    price = price,
    unit = unit,
    id = id
)

fun DetailCategory.toItem() = Item(
    name = name,
    price = price,
    unit = unit.value,
    id = id.toInt()
)