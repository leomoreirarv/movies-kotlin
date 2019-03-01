package com.leonardomoreira.study.domain.usecase

import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.domain.repository.MovieRepository

class GetMovieById(private val repository: MovieRepository): UseCase<MovieDomain, Int>() {
    override fun run(params: Int): MovieDomain {
        return repository.getMovieById(params)
    }
}