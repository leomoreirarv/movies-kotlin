package com.leonardomoreira.study.themovies2.framework.utils

import java.io.File

object JsonTestUtils {
    fun getJson(path: String): String {
        val uri = this.javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}