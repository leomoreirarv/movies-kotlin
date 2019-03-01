package com.leonardomoreira.study.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.leonardomoreira.study.domain.model.MovieDomain

@Entity
data class MovieEntity(
    @PrimaryKey
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
){
    fun toMovieDomain(): MovieDomain{
        var movie = MovieDomain()
        movie.id = this.id
        movie.adult = this.adult
        movie.backdrop_path = this.backdrop_path
        movie.genre_ids = this.genre_ids
        movie.original_language = this.original_language
        movie.original_title = this.original_title
        movie.overview = this.overview
        movie.popularity = this.popularity
        movie.poster_path = this.poster_path
        movie.releaseDate = this.releaseDate
        movie.title = this.title
        movie.video = this.video
        movie.vote_average = this.vote_average
        movie.vote_count = this.vote_count

        return movie
    }
}