package com.leonardomoreira.study.themovies2.framework.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

import com.leonardomoreira.study.data.model.MovieEntity
import com.leonardomoreira.study.data.source.MovieDAO

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDAO

    companion object {
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase? {
            if( INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MovieDatabase::class.java, "movies.db")
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}