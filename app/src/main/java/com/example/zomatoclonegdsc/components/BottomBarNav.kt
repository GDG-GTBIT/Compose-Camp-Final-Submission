package com.example.zomatoclonegdsc.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.zomatoclonegdsc.R

enum class BottomBarNav(
    @DrawableRes val icon: Int,
    @StringRes val label: Int,
    val route: String
) {
    Home(R.drawable.bike_scooter_bottom_nav, R.string.delivery_bottom_nav, "main_screen"),
    Dining(R.drawable.local_dining_bottom_nav, R.string.dining_bottom_nav, "dining_screen"),
    Wallet(R.drawable.wallet_bottom_nav, R.string.wallet_bottom_nav, "wallet_screen"),
    Zomaland(R.drawable.sports_cricket_bottom_nav, R.string.zomaland_bottom_nav, "zomaland_screen"),
}
