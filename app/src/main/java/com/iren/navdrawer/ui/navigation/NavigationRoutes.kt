package com.iren.navdrawer.ui.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen(route = "home", title = "Menu Utama")
    object Screen1 : Screen(route = "screen_1", title = "Screen 1")
    object Screen2 : Screen(route = "screen_2", title = "Screen 2")
    object Screen3 : Screen(route = "screen_3", title = "Screen 3")
}
