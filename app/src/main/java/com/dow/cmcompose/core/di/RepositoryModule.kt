package com.dow.cmcompose.core.di

import android.content.Context
import com.dow.cmcompose.data.local.LocalMovieDataSourceImpl
import com.dow.cmcompose.data.repository.FetchMovieRepositoryImpl
import com.dow.cmcompose.domain.local.LocalMovieDataSource
import com.dow.cmcompose.domain.repository.FetchMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLocalDataSourceRepository(
        @ApplicationContext context: Context
    ): LocalMovieDataSource {
        return LocalMovieDataSourceImpl(context)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        localMovieDataSource: LocalMovieDataSource
    ): FetchMovieRepository {
        return FetchMovieRepositoryImpl(localMovieDataSource)
    }
}