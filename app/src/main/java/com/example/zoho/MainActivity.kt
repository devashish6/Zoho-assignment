package com.example.zoho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.zoho.screens.FeedsScreen
import com.example.zoho.ui.theme.ZohoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZohoTheme {
                FeedsScreen()
            }
        }
    }
}