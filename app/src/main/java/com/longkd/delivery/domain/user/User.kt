package com.longkd.delivery.domain.user

/**
 * @Author: longkd
 * @Since: 19:44 - 17/11/24
 */
data class User(
    val name: String,
    val address: String,
    val paymentCard: String,
    val deliveryOptions: DeliveryOptions,
)


enum class DeliveryOptions {
    BY_MYSELF,
    BY_COURIER,
    BY_DRONE
}
