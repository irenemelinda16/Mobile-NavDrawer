package com.iren.navdrawer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iren.navdrawer.ui.screens.HomeScreen
import com.iren.navdrawer.ui.screens.Screen1
import com.iren.navdrawer.ui.screens.Screen2
import com.iren.navdrawer.ui.screens.Screen3

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onNavigateToScreen = { screen ->
                    navController.navigate(screen.route)
                }
            )
        }
        composable(route = Screen.Screen1.route) {
            Screen1(onBackClick = { navController.popBackStack() })
        }
        composable(route = Screen.Screen2.route) {
            Screen2(onBackClick = { navController.popBackStack() })
        }
        composable(route = Screen.Screen3.route) {
            Screen3(onBackClick = { navController.popBackStack() })
        }
    }
}
