package com.example.zoho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.zoho.bottomnavigation.BottomNavigation
import com.example.zoho.bottomnavigation.NavigationGraph
import com.example.zoho.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val mainViewModel: MainViewModel = viewModel()
            Scaffold(
                bottomBar = {
                    BottomNavigation(navController = navController, items = mainViewModel.screens)
                },
            ) { _ ->
                Column {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
