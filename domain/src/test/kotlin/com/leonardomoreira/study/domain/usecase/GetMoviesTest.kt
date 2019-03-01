package com.leonardomoreira.study.domain.usecase

import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.domain.repository.MovieRepository
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMoviesTest {

    private lateinit var usecase: GetMovies

    @Mock
    private lateinit var repository: MovieRepository

    private val listMovie = emptyList<MovieDomain>()

    @Before
    fun setup(){
        usecase = GetMovies(repository)
    }

    @Test
    fun `GetMovies run must return a movie list`(){
        doReturn(listMovie).`when`(repository).getMovieList()
        usecase.run(UseCase.None())
        verify(repository).getMovieList()
    }

    @Test(expected = Exception::class)
    fun `Throw exception when the load fails`(){
        doThrow(Exception::class).`when`(repository).getMovieList()
        usecase.run(UseCase.None())
    }
}