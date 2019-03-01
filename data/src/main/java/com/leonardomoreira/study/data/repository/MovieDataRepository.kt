package com.leonardomoreira.study.data.repository

import com.leonardomoreira.study.data.source.MovieDAO
import com.leonardomoreira.study.data.source.MovieService
import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.domain.repository.MovieRepository

class MovieDataRepository(
    private var dao: MovieDAO,
    private var service: MovieService,
    private var totalByPage: Int = 22
) : MovieRepository {

    override fun getMovieList(): List<MovieDomain> {
        return dao.getAllMovies().map { it.toMovieDomain() }
    }

    override fun searchMovieByTitle(title: String): List<MovieDomain> {
        return dao.searchMoviesByTitle(title).map { it.toMovieDomain() }
    }

    override fun getMovieById(id: Int): MovieDomain {
        return dao.getMovieById(id).let {
            it.toMovieDomain()
        }
    }

    override fun refreshMovieList(page: Int) {
        val movieResponse = service.getMovies(page)
        dao.saveMovieList(movieResponse.results)
    }

    override fun getMovieListByPage(page: Int): List<MovieDomain> {
        return dao.getMoviesOffsetLimit(page - 1, totalByPage * page).map { it.toMovieDomain() }
    }
}