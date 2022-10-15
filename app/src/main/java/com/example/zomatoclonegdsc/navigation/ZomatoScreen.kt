package com.example.zomatoclonegdsc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zomatoclonegdsc.SplashScreen
import com.example.zomatoclonegdsc.screen.*

@Composable
fun ZomatoApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.RestaurantScreen.route) {
            RestaurantScreen(
                offerPercentageText = 50,
                offerUpToText = 120,
                restaurantName = "Singla's",
                restaurantType = "North Indian, Chinese",
                restaurantLocation = "Tilak Nagar",
                deliveryDistanceInKms = 2,
                deliveryTimeInMins = 40,
                ratingText = 3.9f,
                navController = navController
            )
        }
        composable(route = Screen.DiningScreen.route) {
            DiningScreen(navController = navController)
        }

        composable(route = Screen.WalletScreen.route) {
            WalletScreen(navController = navController)
        }

        composable(route = Screen.ZomalandScreen.route) {
            ZomalandScreen(navController = navController)
        }
    }
}
