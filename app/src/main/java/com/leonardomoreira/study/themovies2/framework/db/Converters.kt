package com.leonardomoreira.study.themovies2.framework.db

import android.arch.persistence.room.TypeConverter

class Converters {
    @TypeConverter
    fun listToString(list: List<Long>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun stringToList(string: String): List<Long>? {
        return string.split(",").map { it.toLong() }
    }
}