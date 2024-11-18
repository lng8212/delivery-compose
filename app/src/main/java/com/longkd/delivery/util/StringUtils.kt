package com.longkd.delivery.util

/**
 * @Author: longkd
 * @Since: 20:19 - 17/11/24
 */

object StringUtils {
    fun paymentCardFormat(cardNumber: String): String {
        if (cardNumber.length <= 4) return cardNumber
        return ("*".repeat(cardNumber.length - 4) + cardNumber.takeLast(4))
            .chunked(4)
            .joinToString(" ")
    }

    fun cardStyle(cardNumber: String): String {
        if (cardNumber.length <= 4) return cardNumber
        return cardNumber.chunked(4).joinToString(" ")
    }
}
