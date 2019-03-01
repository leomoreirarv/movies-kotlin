package com.leonardomoreira.study.themovies2.framework.network

import com.leonardomoreira.study.themovies2.framework.utils.ApiTestUtils
import com.leonardomoreira.study.themovies2.framework.utils.JsonTestUtils
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.lang.Exception

@RunWith(MockitoJUnitRunner::class)
class MovieDomainServiceTest{
    private lateinit var mockServer: MockWebServer
    private lateinit var networkService: MovieNetworkService

    @Before
    fun setup(){
        mockServer = MockWebServer()
        mockServer.start()
        networkService = MovieNetworkService(ApiTestUtils.getMockApi(mockServer))
    }

    @After
    fun tearDown(){
        mockServer.shutdown()
    }

    @Test
    fun `When get all movies`(){
        val mockResponse = MockResponse()
        mockResponse.setBody(JsonTestUtils.getJson("json/movie_response.json"))
        mockResponse.setResponseCode(200)
        mockServer.enqueue(mockResponse)

        Assert.assertNotNull(networkService.getMovies(1))
    }

    @Test(expected = Exception::class)
    fun `When the movie request fails`(){
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(500)
        mockServer.enqueue(mockResponse)

        networkService.getMovies(1)
    }
}