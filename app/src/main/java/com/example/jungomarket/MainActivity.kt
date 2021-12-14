package com.example.jungomarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import com.example.jungomarket.ui.HomeScreen
import com.example.jungomarket.ui.theme.JungoMarketTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JungoMarketTheme {
                HomeScreen()

            }
        }
    }
}


