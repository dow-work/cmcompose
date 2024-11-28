package com.dow.cmcompose.data.repository

import com.dow.cmcompose.domain.local.LocalMovieDataSource
import com.dow.cmcompose.domain.model.Category
import com.dow.cmcompose.domain.repository.FetchMovieRepository
import javax.inject.Singleton

@Singleton
class FetchMovieRepositoryImpl(
    private val localMovieDataSource: LocalMovieDataSource
) : FetchMovieRepository {

    override suspend fun getFetchMovies(): List<Category> {
        return localMovieDataSource.getMovies()
    }
}