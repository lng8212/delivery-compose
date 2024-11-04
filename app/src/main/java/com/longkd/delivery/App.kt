package com.longkd.delivery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.longkd.delivery.ui.category.CategoryRoute
import com.longkd.delivery.ui.onboarding.OnBoardingViewModel
import com.longkd.delivery.ui.onboarding.OnboardingScreen
import kotlinx.serialization.Serializable

/**
 * @Author: longkd
 * @Since: 23:10 - 30/10/24
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


@Composable
fun App(modifier: Modifier = Modifier, navController: NavHostController) {
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
            CategoryRoute()
        }
        composable<Profile> {

        }
        composable<Cart> {

        }
    }
}