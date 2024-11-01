package com.longkd.delivery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.longkd.delivery.ui.category.CategoryScreen
import com.longkd.delivery.ui.onboarding.OnBoardingViewModel
import com.longkd.delivery.ui.onboarding.OnboardingScreen
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

@Serializable
object Profile


@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
    val isFirstInit by onBoardingViewModel.isFirstInit.collectAsStateWithLifecycle()
    NavHost(
        navController = navController,
        startDestination = if (isFirstInit) OnBoarding else Category
    ) {
        composable<OnBoarding> {
            OnboardingScreen(viewModel = onBoardingViewModel) {
                navController.navigate(Category) {
                    popUpTo(OnBoarding) {
                        inclusive = true
                    }
                }
            }
        }
        composable<Category> {
            CategoryScreen()
        }
        composable<Profile> {

        }
        composable<Card> {

        }
    }
}