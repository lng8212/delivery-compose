package com.longkd.delivery

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

/**
 * @Author: longkd
 * @Since: 23:10 - 30/10/24
 */

@Serializable
object OnBoarding

@Serializable
object Category

@Serializable
object Card


@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = OnBoarding) {
        composable<OnBoarding> {
            OnboardingScreen()
        }
        composable<Category> { }
        composable<Card> { }
    }
}