package com.leonardomoreira.study.themovies2.framework.network

import com.leonardomoreira.study.data.model.MovieResponse
import com.leonardomoreira.study.data.source.MovieService

class MovieNetworkService(private val movieApi: MovieApi) : MovieService {
    override fun getMovies(page: Number): MovieResponse {
        val response = movieApi.discoveryMovies(
            apiKey = "8a4ff6207942164c36bb79c4edd39f39",
            page = page
        ).execute()
        if (response.isSuccessful && response.body() != null)
            return response.body()!!

        throw Exception("No movies")
    }
}