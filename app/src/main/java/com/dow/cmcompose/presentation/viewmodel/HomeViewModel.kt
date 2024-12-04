package com.dow.cmcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dow.cmcompose.domain.model.Category
import com.dow.cmcompose.domain.model.MovieDetail
import com.dow.cmcompose.domain.usecase.FetchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchMoviesUseCase: FetchMoviesUseCase
) : ViewModel() {

    private val _sectionItems = MutableStateFlow<List<Category>>(emptyList())
    val sectionItems: StateFlow<List<Category>>  = _sectionItems

    private val _slideItems = MutableStateFlow<List<MovieDetail>>(emptyList())
    val slideItems: StateFlow<List<MovieDetail>> = _slideItems

    init {
        getSectionAndItems()
        getSlideDataItems()
    }

    fun refresh() {
        getSectionAndItems()
        getSlideDataItems()
    }

    fun getSlideDataItems() {
        viewModelScope.launch {
            _slideItems.value = fetchMoviesUseCase.getSlideDataList()
        }
    }

    private fun getSectionAndItems() {
        viewModelScope.launch {
            _sectionItems.value = fetchMoviesUseCase.getSectionAndItems()
        }
    }
}
