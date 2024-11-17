package com.longkd.delivery

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.longkd.delivery.presentation.cart.CartRoute
import com.longkd.delivery.presentation.category.CategoryRoute
import com.longkd.delivery.presentation.detail.DetailCategoryRoute
import com.longkd.delivery.presentation.item.ItemRoute
import com.longkd.delivery.presentation.onboarding.OnBoardingViewModel
import com.longkd.delivery.presentation.onboarding.OnboardingScreen
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

@Serializable
data class DetailCategory(val categoryId: String, val name: String) : Route()

@Serializable
data class Item(val itemId: String) : Route()


@Composable
fun App(navController: NavHostController) {
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
            CategoryRoute { categoryId, name ->
                navController.navigate(DetailCategory(categoryId, name)) {
                    popUpTo(Category) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }

        composable<DetailCategory>(
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(600)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(600)
                )
            },
            popEnterTransition = {
                null
            }
        ) {
            DetailCategoryRoute(
                onBack = {
                    navController.popBackStack()
                },
                onClickItem = {
                    navController.navigate(Item(it))
                })
        }

        composable<Item>(
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(600)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(600)
                )
            },
            popEnterTransition = {
                null
            }
        ) {
            ItemRoute()
        }

        composable<Profile> {

        }

        composable<Cart> {
            CartRoute()
        }
    }
}
