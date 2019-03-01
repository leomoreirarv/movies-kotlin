package com.leonardomoreira.study.domain.usecase

import com.leonardomoreira.study.domain.model.MovieDomain
import com.leonardomoreira.study.domain.repository.MovieRepository
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RefreshMovieListTest {

    private lateinit var usecase: RefreshMovieList

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setup(){
        usecase = RefreshMovieList(repository)
    }

    @Test(expected = Exception::class)
    fun `Throw exception when the load fails`(){
        doThrow(Exception::class).`when`(repository).getMovieList()
        usecase.run(UseCase.None())
    }
}