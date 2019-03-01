package com.leonardomoreira.study.themovies2.ui.common

import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.themovies2.presentation.movie.presenter.MovieViewModel

fun convertMovieFromDomainToViewModel(movieDomain: MovieDomain): MovieViewModel{
    var movieViewModel = MovieViewModel()
    movieViewModel.id = movieDomain.id
    movieViewModel.adult = movieDomain.adult
    movieViewModel.backdrop_path = movieDomain.backdrop_path
    movieViewModel.genre_ids = movieDomain.genre_ids
    movieViewModel.original_language = movieDomain.original_language
    movieViewModel.original_title = movieDomain.original_title
    movieViewModel.overview = movieDomain.overview
    movieViewModel.popularity = movieDomain.popularity
    movieViewModel.poster_path = movieDomain.poster_path
    movieViewModel.releaseDate = movieDomain.releaseDate
    movieViewModel.title = movieDomain.title
    movieViewModel.video = movieDomain.video
    movieViewModel.vote_average = movieDomain.vote_average
    movieViewModel.vote_count = movieDomain.vote_count

    return movieViewModel
}