package com.dow.cmcompose.data.local

import android.content.Context
import com.dow.cmcompose.core.constants.AppConstants
import com.dow.cmcompose.domain.local.LocalMovieDataSource
import com.dow.cmcompose.domain.model.MovieResponse
import com.dow.cmcompose.domain.model.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalMovieDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : LocalMovieDataSource {

    override suspend fun getMovies(): List<Category> {
        val json = context.assets.open(AppConstants.LOCAL_DATA_JSON).bufferedReader().use { it.readText() }
        val type = object : TypeToken<MovieResponse>() {}.type
        val response = Gson().fromJson<MovieResponse>(json, type) //change json to dto
        return response.result
    }
}