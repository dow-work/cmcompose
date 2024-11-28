package com.dow.cmcompose.presentation.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dow.cmcompose.R
import com.dow.cmcompose.presentation.navigation.BottomMenus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopAppBar(navController: NavController, listState: LazyListState?) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val context = LocalContext.current

    TopAppBar(
        title = { //center
            Text(
                text = when (currentRoute) {
                    BottomMenus.HOME.name -> ""
                    BottomMenus.HISTORY.name -> BottomMenus.HISTORY.name
                    BottomMenus.FREE.name -> BottomMenus.FREE.name
                    BottomMenus.MY.name -> BottomMenus.MY.name
                    else -> BottomMenus.HOME.name
                }, style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
        },
        Modifier.border(BorderStroke(0.3.dp, Color(0xFFE1E1E1))),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor =  Color.White
        ),
        navigationIcon = { //left item
            when (currentRoute) {
                BottomMenus.HOME.name -> {
                    IconButton(onClick = {
                        Toast.makeText(context, "smile", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            painter = painterResource(id =
                                R.drawable.baseline_sentiment_very_satisfied_black_24
                            ),
                            contentDescription = "Menu"
                        )
                    }
                }
                else -> BottomMenus.HOME.name
            }
        },
        actions = {//right item
            //Todo
        },
    )
}



