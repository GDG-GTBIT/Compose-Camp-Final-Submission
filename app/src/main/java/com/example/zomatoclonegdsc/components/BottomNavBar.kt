package com.example.zomatoclonegdsc.components

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.zomatoclonegdsc.ui.theme.zDarkGray
import com.example.zomatoclonegdsc.ui.theme.zRedColor


@Composable
fun BottomNavBar(navController: NavController) {
    BottomNavigation {
        BottomBarNav.values().forEach {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            BottomNavigationItem(
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }

                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = stringResource(it.label)
                    )
                },
                label = { Text(text = stringResource(it.label), color = Color.DarkGray) },
                modifier = Modifier.background(Color.White),
                unselectedContentColor = zDarkGray,
                selectedContentColor = zRedColor
            )
        }
    }
}