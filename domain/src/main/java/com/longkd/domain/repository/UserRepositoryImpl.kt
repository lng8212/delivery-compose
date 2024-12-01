package com.longkd.domain.repository

import com.longkd.domain.user.DeliveryOptions
import com.longkd.domain.user.User
import com.longkd.domain.user.UserRepository
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 19:47 - 17/11/24
 */
class UserRepositoryImpl @Inject constructor() : UserRepository {
    override suspend fun getUser() = User(
        name = "Larry",
        address = "Trump Building, 200 Louis St\nHanoi, Vietnam",
        paymentCard = "1234567812345678",
        deliveryOptions = DeliveryOptions.BY_DRONE
    )
}