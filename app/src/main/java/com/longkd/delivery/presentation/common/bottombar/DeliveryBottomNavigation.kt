package com.longkd.delivery.presentation.common.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.longkd.delivery.R
import com.longkd.delivery.Route

/**
 * @Author: longkd
 * @Since: 21:44 - 4/11/24
 */

sealed class BottomBarNavigationScreen(val route: Route, val icon: Int, val iconSelected: Int) {
    data object Category :
        BottomBarNavigationScreen(
            com.longkd.delivery.Category,
            R.drawable.ic_list,
            R.drawable.ic_list_selected
        )

    data object Cart : BottomBarNavigationScreen(
        com.longkd.delivery.Cart,
        R.drawable.ic_cart,
        R.drawable.ic_cart_selected
    )

    data object Profile : BottomBarNavigationScreen(
        com.longkd.delivery.Profile,
        R.drawable.ic_user,
        R.drawable.ic_user_selected
    )
}

@Composable
fun DeliveryBottomNavigation(
    navController: NavHostController,
) {
    val screens = listOf(
        BottomBarNavigationScreen.Category,
        BottomBarNavigationScreen.Cart,
        BottomBarNavigationScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    if (currentRoute in screens.map { it.route::class.qualifiedName })
        NavigationBar(containerColor = Color.White) {
            screens.forEach { screen ->
                NavigationBarItem(
                    label = {
                    },
                    icon = {
                        Icon(
                            tint = Color.Unspecified,
                            painter = painterResource(
                                id = if (currentRoute == screen.route::class.qualifiedName) screen.iconSelected else screen.icon
                            ),
                            contentDescription = null
                        )
                    },
                    selected = currentRoute == screen.route::class.qualifiedName,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },

                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
}