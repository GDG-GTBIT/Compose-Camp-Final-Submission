package com.example.zomatoclonegdsc.navigation

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object MainScreen: Screen("main_screen")
    object RestaurantScreen: Screen("restaurant_screen")
    object DiningScreen: Screen("dining_screen")
    object WalletScreen: Screen("wallet_screen")
    object ZomalandScreen: Screen("zomaland_screen")
}