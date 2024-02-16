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
import com.example.zoho.ui.theme.SELECTED_ICON
import com.example.zoho.ui.theme.UNSELECTED_ICON

@Composable
fun BottomNavigation(navController: NavController, items: List<BottomNavigationModel>) {

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
                        contentDescription = item.title,
                        tint = if (currentRoute == item.title) {
                            SELECTED_ICON
                        } else {
                            UNSELECTED_ICON
                        })

                },
                label = {
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontFamily = FONT_MEDIUM,
                            color = if (currentRoute == item.title) {
                                SELECTED_ICON
                            } else {
                                UNSELECTED_ICON
                            }
                        ),
                        fontSize = 12.sp
                    )
                },
                selected = currentRoute == item.title,
                onClick = {
                    if (currentRoute != item.title) {
                        navController.navigate(item.title) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}