package com.longkd.presentation

import kotlinx.serialization.Serializable

/**
 * @Author: longkd
 * @Since: 21:11 - 27/11/24
 */

sealed class Route

@Serializable
data object OnBoarding : Route()

@Serializable
data object Category : Route()

@Serializable
data object Cart : Route()

@Serializable
data object Profile : Route()

@Serializable
data class DetailCategory(val categoryId: String, val name: String) : Route()

@Serializable
data class Item(val itemId: String) : Route()

@Serializable
data class Card(val id: String) : Route()
