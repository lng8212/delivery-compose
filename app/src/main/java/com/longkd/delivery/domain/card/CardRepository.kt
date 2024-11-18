package com.longkd.delivery.domain.card

/**
 * @Author: longkd
 * @Since: 22:10 - 18/11/24
 */
interface CardRepository {
    suspend fun getCardInfo(number: String): Card?
}