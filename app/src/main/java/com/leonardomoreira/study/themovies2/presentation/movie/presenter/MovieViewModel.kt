package com.leonardomoreira.study.themovies2.presentation.movie.presenter

data class MovieViewModel (
    var id: Long = 0,
    var adult: Boolean = false,
    var backdrop_path: String? = "",
    var genre_ids: List<Long>? = listOf(),
    var original_language: String = "",
    var original_title: String = "",
    var overview: String = "",
    var popularity: Double = 0.0,
    var poster_path: String? = "",
    var releaseDate: String? = "",
    var title: String = "",
    var video: Boolean = true,
    var vote_average: Double = 0.0,
    var vote_count: Long = 0
) {
    fun getImageFullUrl(size: String, imageBaseUrl: String): String{
        return imageBaseUrl + size + this.poster_path
    }
}
