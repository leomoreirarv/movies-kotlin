package com.leonardomoreira.study.data.source

import com.leonardomoreira.study.data.model.MovieResponse

interface MovieService {
    fun getMovies(page: Number): MovieResponse
}
