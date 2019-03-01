package com.leonardomoreira.study.themovies2.framework.network

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApiProviderTest{

    private lateinit var apiProvider: ApiProvider

    @Before
    fun setup(){
        apiProvider = ApiProvider()
    }

    @Test
    fun `Create Api`(){
        Assert.assertNotNull(apiProvider.getApi("http://www.url.com"))
    }
}