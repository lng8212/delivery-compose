package com.longkd.delivery.domain.card

/**
 * @Author: longkd
 * @Since: 22:08 - 18/11/24
 */
data class Card(
    val number: String,
    val name: String,
    val expireDate: String,
    val cvc: Int,
    val cardType: CardType,
)

enum class CardType {
    VISA,
    MASTER,
    JCB
}