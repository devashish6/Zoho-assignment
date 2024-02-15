package com.example.zoho.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zoho.screens.FeedsScreen
import com.example.zoho.screens.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "feeds") {
        composable("feeds") {
            FeedsScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("notifications") {
        }
        composable("settings") {
        }
    }
}