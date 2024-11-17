package com.longkd.delivery.presentation.cart

import com.longkd.delivery.domain.user.DeliveryOptions
import com.longkd.delivery.domain.user.User

/**
 * @Author: longkd
 * @Since: 10:08 - 16/11/24
 */
data class CartUiState(
    val userData: User? = null,
    val deliveryOptions: DeliveryOptions,
    val isNonContact: Boolean = true,
) {
    companion object {
        fun initial() = CartUiState(userData = null, deliveryOptions = DeliveryOptions.BY_DRONE)
    }
}
