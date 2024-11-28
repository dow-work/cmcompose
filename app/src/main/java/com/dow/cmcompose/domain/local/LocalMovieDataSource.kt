package com.dow.cmcompose.domain.local

import com.dow.cmcompose.domain.model.Category

interface LocalMovieDataSource {
    suspend fun getMovies(): List<Category>
}