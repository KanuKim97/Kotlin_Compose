package com.example.jungomarket.dataClass

import androidx.compose.ui.graphics.vector.ImageVector

data class bottomNavItem(
    val name : String,
    val route : String,
    val icon : ImageVector,
    val badgeCount : Int = 0
)
