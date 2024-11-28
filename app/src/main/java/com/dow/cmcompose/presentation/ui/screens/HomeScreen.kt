package com.dow.cmcompose.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dow.cmcompose.presentation.ui.components.AutoSlidePager
import com.dow.cmcompose.presentation.ui.components.LoadingOverlay
import com.dow.cmcompose.presentation.ui.components.SectionWithGridView
import com.dow.cmcompose.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(listState: LazyListState) {
    HomePullToRefresh(listState = listState)
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePullToRefresh( listState: LazyListState) {
    val viewModel: HomeViewModel = hiltViewModel()
    val sectionItems by viewModel.sectionItems.collectAsState()
    val slideItems by viewModel.slideItems.collectAsState()

    var isLoading by remember { mutableStateOf(true) }

    var isRefreshing by remember { mutableStateOf(false) }
    val state = rememberPullToRefreshState()
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isLoading = true
        isRefreshing = true
        coroutineScope.launch {
            Timber.d("onRefresh")
            viewModel.refresh()
            delay(1500)
            isRefreshing = false
            isLoading = false
        }
    }

    LoadingOverlay(isLoading = isLoading) {
        PullToRefreshBox(
            state = state,
            isRefreshing = isRefreshing,
            onRefresh = onRefresh,
        ) {
            // content refresh
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    AutoSlidePager(slideItems)
                    sectionItems.forEach { sectionItem ->
                        SectionWithGridView(
                            title = sectionItem.title,
                            items = sectionItem.details.take(9),
                            onItemClick = { clickedItem ->
                                println("Clicked: $clickedItem")
                            }
                        )
                    }
                }
            }
        }
        coroutineScope.launch {
            delay(1500)
            isLoading = false
        }
    }
}

