package com.leonardomoreira.study.data.source

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.leonardomoreira.study.data.model.MovieEntity

@Dao
interface MovieDAO {
    @Query("SELECT * FROM MovieEntity")
    fun getAllMovies():List<MovieEntity>

    @Query("SELECT * from MovieEntity WHERE id = :id")
    fun getMovieById(id: Int):MovieEntity

    @Query("SELECT * FROM MovieEntity WHERE title LIKE '%' || :title || '%'")
    fun searchMoviesByTitle(title: String):List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovieList(listMovie: List<MovieEntity>?)

    @Query("SELECT * from MovieEntity limit :start,:end")
    fun getMoviesOffsetLimit(start: Int, end: Int):List<MovieEntity>
}

