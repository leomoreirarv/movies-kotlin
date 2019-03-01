package com.leonardomoreira.study.domain.usecase

import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.domain.repository.MovieRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchMovieDomainByTitleTest{

    private lateinit var usecase: SearchMovieByTitle

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setup(){
        usecase = SearchMovieByTitle(repository)
    }

    @Test
    fun `Search movies by title`(){
        doReturn(emptyList<MovieDomain>()).`when`(repository).searchMovieByTitle("xpto")
        usecase.run("xpto")
        Assert.assertEquals(emptyList<MovieDomain>(), usecase.run("xpto"))
    }

    @Test(expected = Exception::class)
    fun `Throw exception when the search fails`(){
        doReturn(Exception::class).`when`(repository).searchMovieByTitle("xpto")
        usecase.run("xpto")
    }
}