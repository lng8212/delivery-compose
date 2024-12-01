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
import com.longkd.presentation.Card
import com.longkd.presentation.Cart
import com.longkd.presentation.Category
import com.longkd.presentation.DetailCategory
import com.longkd.presentation.Item
import com.longkd.presentation.OnBoarding
import com.longkd.presentation.Profile
import com.longkd.presentation.card.CardRoute
import com.longkd.presentation.cart.CartRoute
import com.longkd.presentation.category.CategoryRoute
import com.longkd.presentation.detail.DetailCategoryRoute
import com.longkd.presentation.item.ItemRoute
import com.longkd.presentation.onboarding.OnBoardingViewModel
import com.longkd.presentation.onboarding.OnboardingScreen

/**
 * @Author: longkd
 * @Since: 23:10 - 30/10/24
 */

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
            CartRoute { cardNumber ->
                navController.navigate(Card(cardNumber))
            }
        }

        composable<Card>(
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
            CardRoute {
                navController.popBackStack()
            }
        }
    }
}
