package com.longkd.delivery.domain.user

/**
 * @Author: longkd
 * @Since: 19:46 - 17/11/24
 */
interface UserRepository {
    suspend fun getUser(): User
}