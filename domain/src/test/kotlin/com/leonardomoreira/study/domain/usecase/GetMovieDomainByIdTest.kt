package com.leonardomoreira.study.domain.usecase

import com.leonardomoreira.study.domain.repository.MovieRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMovieDomainByIdTest{

    @Mock
    private lateinit var repository: MovieRepository

    private lateinit var usecase: GetMovieById

    @Before
    fun setup(){
        usecase = GetMovieById(repository)
    }

    @Test
    fun `Load movies by id`(){
        usecase.run(1)
        verify(repository).getMovieById(1)
    }

    @Test(expected = Exception::class)
    fun `Throw exception when the load fails`(){
        doThrow(Exception::class).`when`(repository).getMovieById(any())
        usecase.run(1)
    }
}