package com.longkd.delivery.data.repository

import com.longkd.delivery.domain.card.Card
import com.longkd.delivery.domain.card.CardRepository
import com.longkd.delivery.domain.card.CardType
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 22:10 - 18/11/24
 */
class CardRepositoryImpl @Inject constructor() : CardRepository {
    override suspend fun getCardInfo(number: String): Card? = listCard.find {
        it.number == number
    }
}


val listCard = listOf(
    Card(
        "1234567812345678",
        "Larry Kieu",
        expireDate = "07/21",
        cvc = 474,
        cardType = CardType.MASTER
    ),
    Card(
        "123456789123",
        "Biden",
        expireDate = "07/25",
        cvc = 336,
        cardType = CardType.VISA
    ),
)