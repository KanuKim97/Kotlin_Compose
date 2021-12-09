package com.example.jungomarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jungomarket.dataClass.bottomNavItem
import com.example.jungomarket.ui.theme.JungoMarketTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JungoMarketTheme {
                val navController = rememberNavController()
                Scaffold (
                    bottomBar = {
                        bottom_Navbar(item = listOf(
                            bottomNavItem(
                                name = "home",
                                route = "home",
                                icon = Icons.Default.Home
                            ),
                            bottomNavItem(
                                name = "chat",
                                route = "chat",
                                icon = Icons.Default.Notifications
                            ),
                            bottomNavItem(
                                name = "settings",
                                route = "settings",
                                icon = Icons.Default.Settings
                            ),

                        ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                        ) {
                    btn_navigation(navController = navController)
                }
            }
        }
    }
}


@Composable
fun btn_navigation(navController : NavHostController) {
    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            homeScreen()
        }
        composable("chat") {
            chatScreen()
        }
        composable("settings") {
            settingScreen()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun bottom_Navbar(
    item: List<bottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (bottomNavItem) -> Unit
){

    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        item.forEach { item ->

            val selected = item.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = item.route == navController.currentDestination?.route,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                icon = {
                        Column(horizontalAlignment = CenterHorizontally) {
                            if(item.badgeCount > 0) {
                                BadgeBox(
                                    badgeContent = {
                                        Text(text = item.badgeCount.toString())
                                    }
                                ) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.name
                                    )
                                }
                            } else {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                            if (selected) {
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp
                                )
                            }
                        }
                }
            )
        }
    }
}


@Composable
fun homeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home")
    }
}


@Composable
fun chatScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "chat")
    }
}

@Composable
fun settingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Setting")
    }
}