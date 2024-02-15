package com.example.zoho.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zoho.TITLE_FEED
import com.example.zoho.TITLE_NOTIFICATIONS
import com.example.zoho.TITLE_SEARCH
import com.example.zoho.TITLE_SETTINGS
import com.example.zoho.screens.FeedsScreen
import com.example.zoho.screens.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = TITLE_FEED) {
        composable(TITLE_FEED) {
            FeedsScreen()
        }
        composable(TITLE_SEARCH) {
            SearchScreen()
        }
        composable(TITLE_NOTIFICATIONS) {
        }
        composable(TITLE_SETTINGS) {
        }
    }
}