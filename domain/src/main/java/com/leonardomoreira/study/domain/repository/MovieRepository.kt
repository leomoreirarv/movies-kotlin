package com.leonardomoreira.study.domain.repository

import com.leonardomoreira.study.domain.model.MovieDomain

interface MovieRepository {
    fun getMovieList(): List<MovieDomain>
    fun searchMovieByTitle(title: String): List<MovieDomain>
    fun getMovieById(id: Int): MovieDomain
    fun refreshMovieList(page: Int)
    fun getMovieListByPage(page: Int):List<MovieDomain>
}