package com.leonardomoreira.study.themovies2.presentation.movie.presenter

import com.leonardomoreira.study.domain.usecase.LoadMovies
import com.leonardomoreira.study.themovies2.presentation.movie.contract.StartupContract
import com.leonardomoreira.study.themovies2.ui.common.convertMovieFromDomainToViewModel

class StartupPresenter(private var loadMovies: LoadMovies) : StartupContract.Presenter{

    var view: StartupContract.View? = null

    private var page: Int = 0

    override fun attachView(view: StartupContract.View?) {
        this.view = view
    }

    override fun onPosterCliked(id: Long) {
    }

    override fun destroy() {
        view = null
    }

    override fun showMovieDetails(movie: MovieViewModel) {
    }

    override fun loadMovies() {
        page = 1
        view?.showLoader()
        loadMovies.execute(page, { moviesList ->
            view?.showMovies(moviesList.map{ movieDomain ->
                convertMovieFromDomainToViewModel(movieDomain)
            })
            view?.hideLoader()
        }, {
            //TODO Implement it
        })
    }

    override fun loadNextPage() {
        page++
        view?.showLoader()
        loadMovies.execute(page, { moviesList ->
            view?.showMovies(moviesList.map{ movieDomain ->
                convertMovieFromDomainToViewModel(movieDomain)
            })
            view?.hideLoader()
        }, {
            //TODO Implement it
        })
    }

}