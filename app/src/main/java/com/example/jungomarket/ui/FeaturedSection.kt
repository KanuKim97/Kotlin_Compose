package com.example.jungomarket.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class featuredSection(
    val title: String,
    @DrawableRes
    val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
     )