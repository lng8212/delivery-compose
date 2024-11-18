package com.longkd.delivery.presentation.card

import com.longkd.delivery.domain.card.Card

/**
 * @Author: longkd
 * @Since: 22:02 - 18/11/24
 */
data class CardUiState(
    val card: Card?,
) {
    companion object {
        fun initial(): CardUiState = CardUiState(null)
    }
}