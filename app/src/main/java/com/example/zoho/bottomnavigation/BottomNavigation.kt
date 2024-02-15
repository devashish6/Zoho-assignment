package com.example.zoho.bottomnavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.zoho.ui.theme.FONT_MEDIUM
import com.example.zoho.ui.theme.NAVIGATION_TEXT

@Composable
fun BottomNavigation(navController: NavController, items: List<BottomNavigationScreens>) {

    NavigationBar (
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon =
                {
                    Icon(painterResource(id = item.selectedIcon),
                        contentDescription = item.title)
                },
                label = {
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontFamily = FONT_MEDIUM,
                            color = NAVIGATION_TEXT
                        ),
                        fontSize = 12.sp
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}