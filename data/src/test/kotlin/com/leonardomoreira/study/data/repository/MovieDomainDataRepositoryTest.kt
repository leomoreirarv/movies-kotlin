package com.leonardomoreira.study.data.repository

import com.leonardomoreira.study.data.model.MovieEntity
import com.leonardomoreira.study.data.source.MovieDAO
import com.leonardomoreira.study.domain.model.MovieDomain
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDomainDataRepositoryTest {

    private lateinit var listMovieEntities:List<MovieEntity>
    private lateinit var listMovieDomainDomain:List<MovieDomain>

    private lateinit var movieDomainDomain:MovieDomain
    private lateinit var movieEntity: MovieEntity

    private lateinit var repository: MovieDataRepository

    @Mock
    private lateinit var dao:MovieDAO

    @Before
    fun setup(){
        listMovieEntities = emptyList<MovieEntity>()
        listMovieDomainDomain = emptyList<MovieDomain>()
        repository = MovieDataRepository(dao)
        movieDomainDomain = getMockMovieDomain()
        movieEntity = getMockMovieEntity()
    }

    @Test
    fun `Get all movies`(){
        doReturn(listMovieEntities).`when`(dao).getAllMovies()
        repository.getMovieList()
        verify(dao).getAllMovies()
        Assert.assertEquals(listMovieDomainDomain, repository.getMovieList())
    }

    @Test
    fun `Get movie by id`(){
        doReturn(movieEntity).`when`(dao).getMovieById(any())
        repository.getMovieById(any())
        verify(dao).getMovieById(any())
        Assert.assertEquals(movieDomainDomain, repository.getMovieById(any()))
    }

    @Test
    fun `Search movie by title`(){
        doReturn(listMovieEntities).`when`(dao).searchMoviesByTitle("xpto")
        repository.searchMovieByTitle("xpto")
        verify(dao).searchMoviesByTitle("xpto")
        Assert.assertEquals(listMovieDomainDomain, repository.searchMovieByTitle("xpto"))
    }

    private fun getMockMovieEntity(): MovieEntity {
        return MovieEntity(
            0,
            false,
            "",
            listOf(),
            "",
            "",
            "",
            0.0,
            "",
            "",
            "",
            true,
            0.0,
            0
        )
    }

    private fun getMockMovieDomain(): MovieDomain {
        return MovieDomain(
            0,
            false,
            "",
            listOf(),
            "",
            "",
            "",
            0.0,
            "",
            "",
            "",
            true,
            0.0,
            0
        )
    }
}