package com.dow.cmcompose.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dow.cmcompose.presentation.navigation.BottomMenus
import com.dow.cmcompose.presentation.ui.components.BottomNavigationBar
import com.dow.cmcompose.presentation.ui.components.DynamicTopAppBar
import timber.log.Timber

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val homeListState = rememberLazyListState()

    Scaffold(
        topBar = { DynamicTopAppBar(navController = navController, homeListState) },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Timber.d(">>>>>>>>> $innerPadding")
        NavHost(
            navController = navController,
            startDestination = BottomMenus.HOME.name,
            modifier =
                Modifier.padding(innerPadding).background(Color.White)
            ,
        ) {
            composable(BottomMenus.HOME.name) { HomeScreen(homeListState) }
            composable(BottomMenus.HISTORY.name) { HistoryScreen() }
            composable(BottomMenus.FREE.name) { GiftScreen() }
            composable(BottomMenus.MY.name) { ProfileScreen() }
        }
    }
}
