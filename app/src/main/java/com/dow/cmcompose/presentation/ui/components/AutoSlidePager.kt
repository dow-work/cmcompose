package com.dow.cmcompose.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.dow.cmcompose.domain.model.MovieDetail
import kotlinx.coroutines.delay
import timber.log.Timber

@Composable
fun AutoSlidePager(items: List<MovieDetail>) {
    val pagerState = rememberPagerState { items.size }
    // Automatically switch pages after a delay
    LaunchedEffect(pagerState) {
        while (true) {
            delay(10000) // n seconds delay
            val nextPage = (pagerState.currentPage + 1) % 4
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height((changeToHeaderSliderHeight()).dp),
        contentAlignment = Alignment.Center
    ) {
        // Pager to show slides
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            val image = items[page]
            Timber.d("thumbnail: ${image.poster_path}")
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(image.poster_path),
                    contentDescription = "Asset Image $page",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}