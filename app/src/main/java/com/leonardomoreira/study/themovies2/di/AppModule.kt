package com.leonardomoreira.study.themovies2.di

import com.leonardomoreira.study.data.repository.MovieDataRepository
import com.leonardomoreira.study.domain.repository.MovieRepository
import com.leonardomoreira.study.themovies2.framework.db.MovieDatabase
import com.leonardomoreira.study.themovies2.framework.network.ApiProvider
import com.leonardomoreira.study.themovies2.framework.network.MovieNetworkService
import com.leonardomoreira.study.data.source.MovieService
import com.leonardomoreira.study.domain.usecase.LoadMovies
import com.leonardomoreira.study.themovies2.presentation.movie.contract.StartupContract
import com.leonardomoreira.study.themovies2.presentation.movie.presenter.StartupPresenter
import com.verizonconnect.fsdapp.R
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

var appModule = module {
    factory<StartupContract.Presenter> { StartupPresenter(get()) }
    factory { LoadMovies(get()) }
    factory<MovieRepository> { MovieDataRepository(get(), get()) }
    factory { MovieDatabase.getInstance(androidApplication())!!.movieDao() }
    factory<MovieService> { MovieNetworkService(get()) }
    factory { ApiProvider().getApi(get("base_url")) }
    factory("base_url") { androidApplication().resources.getString(R.string.base_url) }
}
