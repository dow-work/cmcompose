package com.dow.cmcompose.domain.repository

import com.dow.cmcompose.domain.model.Category

interface FetchMovieRepository {
    suspend fun getFetchMovies(): List<Category>
}