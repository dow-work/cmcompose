package com.dow.cmcompose.presentation.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.dow.cmcompose.R
import com.dow.cmcompose.domain.model.MovieDetail


@Composable
fun SectionWithGridView(
    title: String,
    items: List<MovieDetail>,
    onItemClick: (MovieDetail) -> Unit
) {
    val columns = changeToColumInGrid()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(bottom = 8.dp, start = 8.dp)
                    .align(Alignment.CenterStart)
            )

            Icon(
                painterResource(R.drawable.outline_arrow_forward_24),
                contentDescription = "section index: $title",
                modifier = Modifier
                    .padding(bottom = 8.dp, end = 8.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        Toast.makeText(context, "section index: $title", Toast.LENGTH_SHORT).show()
                    }
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 900.dp)
        ) {
            items(items.size) { index ->
                Box(
                    modifier = Modifier
                        .heightIn(max = 190.dp)
                        .background(Color.White)
                        .clickable { onItemClick(items[index]) },
                    contentAlignment = Alignment.TopStart
                ) {
                    val image = items[index]
                    Column(
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(image.poster_path),
                            contentDescription = "Asset Image ${image.title}",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Text(
                            text = "title:$index",
                            color = Color.Blue,
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(15.dp)
                        )
                    }
                }
            }
        }
    }
}