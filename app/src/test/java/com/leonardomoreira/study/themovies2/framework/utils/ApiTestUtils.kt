package com.leonardomoreira.study.themovies2.framework.utils

import com.leonardomoreira.study.themovies2.framework.network.ApiProvider
import com.leonardomoreira.study.themovies2.framework.network.MovieApi
import okhttp3.mockwebserver.MockWebServer

class ApiTestUtils {
    companion object {
        fun getMockApi(mockWebServer: MockWebServer): MovieApi {
            return ApiProvider().getApi(mockWebServer.url(" /").toString())
        }
    }
}