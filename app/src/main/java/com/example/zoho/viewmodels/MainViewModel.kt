package com.example.zoho.viewmodels

import androidx.lifecycle.ViewModel
import com.example.zoho.R
import com.example.zoho.TITLE_FEED
import com.example.zoho.TITLE_NOTIFICATIONS
import com.example.zoho.TITLE_SEARCH
import com.example.zoho.TITLE_SETTINGS
import com.example.zoho.bottomnavigation.BottomNavigationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val feed = BottomNavigationModel(title = TITLE_FEED, selectedIcon = R.drawable.ic_feed)
    private val search = BottomNavigationModel(title = TITLE_SEARCH, selectedIcon = R.drawable.ic_search)
    private val notification = BottomNavigationModel(title = TITLE_NOTIFICATIONS, selectedIcon = R.drawable.ic_notification)
    private val settings = BottomNavigationModel(title = TITLE_SETTINGS, selectedIcon = R.drawable.ic_settings)

    val screens = listOf(
            feed,
            search,
            notification,
            settings
        )
}