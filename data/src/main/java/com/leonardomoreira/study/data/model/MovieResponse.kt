package com.leonardomoreira.study.data.model

data class MovieResponse(var page: Long = 0,
                         var results: List<MovieEntity>? = listOf(),
                         var total_pages: Long = 0,
                         var total_results: Long = 0)