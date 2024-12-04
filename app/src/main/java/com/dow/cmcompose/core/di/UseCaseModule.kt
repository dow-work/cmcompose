package com.dow.cmcompose.core.di

import com.dow.cmcompose.domain.repository.FetchMovieRepository
import com.dow.cmcompose.domain.usecase.FetchMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideMovieUsecase(
        fetchMovieRepository: FetchMovieRepository
    ): FetchMoviesUseCase {
        return FetchMoviesUseCase(fetchMovieRepository)
    }
}
