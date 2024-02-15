package com.example.zoho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zoho.bottomnavigation.BottomNavigation
import com.example.zoho.bottomnavigation.NavigationGraph
import com.example.zoho.ui.theme.FONT_MEDIUM
import com.example.zoho.ui.theme.FONT_REGULAR
import com.example.zoho.ui.theme.Toolbar
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
                }
            ) { _ ->
                Column {
                    TopBar(navController)
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
private fun TopBar(navController: NavHostController) {
    if (navController.currentDestination?.route == TITLE_FEED) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Toolbar)
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        top = 16.dp,
                        end = 24.dp,
                        bottom = 16.dp
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "menu",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(24.dp)
                )
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "Forum",
                            style = TextStyle(
                                fontFamily = FONT_MEDIUM,
                                fontSize = 20.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        Row {
                            Text(
                                text = "All",
                                style = TextStyle(
                                    fontFamily = FONT_REGULAR,
                                    fontSize = 16.sp,
                                    color = Color.White
                                ),
                                modifier = Modifier.padding(start = 24.dp)
                            )
                            Image(painter = painterResource(id = R.drawable.ic_dropdown_arrow), contentDescription = null,
                                colorFilter = ColorFilter.tint(Color.White))
                        }

                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_sort_icon),
                        contentDescription = "sort",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { }
                    )
                }
            }
        }
    }
}
