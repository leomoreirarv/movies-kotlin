package com.leonardomoreira.study.themovies2.framework.network

import com.leonardomoreira.study.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("discover/movie")
    fun discoveryMovies(@Query("api_key") apiKey: String,
                        @Query("page") page: Number,
                        @Query("language") language: String = "en-US",
                        @Query("sort_by") sortBy: String = "popularity.desc",
                        @Query("include_adult") includeAdult: Boolean = false,
                        @Query("include_video") includeVideo: Boolean = false): Call<MovieResponse>
}