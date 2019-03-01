package com.leonardomoreira.study.themovies2.framework.db

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class MovieDomainDatabaseTest {

    private var database: MovieDatabase? = null

    @Test
    fun `Data base instance mustn't be null`(){
        database = MovieDatabase.getInstance(RuntimeEnvironment.application)
        Assert.assertNotNull(database)
    }

}