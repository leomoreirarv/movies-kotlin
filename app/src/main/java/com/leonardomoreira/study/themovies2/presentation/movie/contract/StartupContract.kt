package com.leonardomoreira.study.themovies2.presentation.movie.contract

import com.leonardomoreira.study.themovies2.presentation.movie.presenter.MovieViewModel

interface StartupContract {
    interface Presenter {
        fun attachView(view: View?)
        fun onPosterCliked(id: Long)
        fun destroy()
        fun showMovieDetails(it: MovieViewModel)
        fun loadMovies()
        fun loadNextPage()
    }

    interface View {
        fun showLoader()
        fun hideLoader()
        fun showMovies(list: List<MovieViewModel>)
        fun showNextPage()
    }
}