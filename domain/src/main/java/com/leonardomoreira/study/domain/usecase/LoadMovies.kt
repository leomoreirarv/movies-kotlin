package com.leonardomoreira.study.domain.usecase

import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.domain.repository.MovieRepository

class LoadMovies(private val repository: MovieRepository): UseCase<List<MovieDomain>, Int>() {
    override fun run(params: Int): List<MovieDomain> {
        repository.refreshMovieList(params)
        return repository.getMovieList()
    }
}