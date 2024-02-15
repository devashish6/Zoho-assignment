package com.example.zoho

import androidx.lifecycle.ViewModel
import com.example.zoho.R
import com.example.zoho.bottomnavigation.BottomNavigationScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val feed = BottomNavigationScreens(title = "Feeds", selectedIcon = R.drawable.ic_feed,"feeds")
    private val search = BottomNavigationScreens(title = "Search", selectedIcon = R.drawable.ic_search,"search")
    private val notification = BottomNavigationScreens(title = "Notification", selectedIcon = R.drawable.ic_notification,"notifications")
    private val settings = BottomNavigationScreens(title = "Settings", selectedIcon = R.drawable.ic_settings,"settings")

    val screens = listOf(
            feed,
            search,
            notification,
            settings
        )
}