package com.dow.cmcompose.domain.model

data class Category(
    val details: List<MovieDetail> = listOf(),
    val id: Int = 0,
    val title: String = ""
)
