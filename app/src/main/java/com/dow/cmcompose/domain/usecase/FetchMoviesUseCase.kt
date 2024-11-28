package com.dow.cmcompose.domain.usecase

import com.dow.cmcompose.core.constants.AppConstants.CATEGORY_KEY_NEW
import com.dow.cmcompose.domain.model.Category
import com.dow.cmcompose.domain.model.MovieDetail
import com.dow.cmcompose.domain.repository.FetchMovieRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FetchMoviesUseCase @Inject constructor(
    private val fetchMovieRepository: FetchMovieRepository
) {

    private suspend fun getMovie(): List<Category> {
        return fetchMovieRepository.getFetchMovies()
    }

    suspend fun getSlideDataList(): List<MovieDetail> {
        Timber.d("getSlideDataList")
        val movies = getMovie()[CATEGORY_KEY_NEW]
        Timber.d("getSlideDataList : $movies")
        return movies.details.take(10)
    }

    suspend fun getSectionAndItems(): List<Category> {
        Timber.d("getSectionAndItems")
        return getMovie()
    }

}