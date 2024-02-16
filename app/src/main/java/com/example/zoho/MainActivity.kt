package com.example.zoho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.zoho.bottomnavigation.BottomNavigation
import com.example.zoho.bottomnavigation.NavigationGraph
import com.example.zoho.ui.theme.SELECTED_ICON
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
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ },
                        containerColor = SELECTED_ICON,
                        modifier = Modifier.padding(16.dp)
                            .clip(CircleShape)) {
                        Icon(painter = painterResource(id = R.drawable.ic_plus), contentDescription = null, tint = Color.White)
                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                modifier = Modifier.padding(bottom = 24.dp)
            ) { _ ->
                Column {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
