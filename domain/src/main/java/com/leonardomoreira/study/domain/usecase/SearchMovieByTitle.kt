package com.leonardomoreira.study.domain.usecase

import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.domain.repository.MovieRepository

class SearchMovieByTitle(private val repository: MovieRepository): UseCase<List<MovieDomain>, String>() {
    override fun run(params: String): List<MovieDomain> {
        return repository.searchMovieByTitle(params)
    }
}