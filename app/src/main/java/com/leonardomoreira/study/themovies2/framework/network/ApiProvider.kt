package com.leonardomoreira.study.themovies2.framework.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {

    fun getApi(url:String): MovieApi{
        val builder = Retrofit.Builder()
            .baseUrl(url)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(MovieApi::class.java)
    }

    private fun getClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        addStetho(builder)
        return builder.build()
    }

    private fun addStetho(builder: OkHttpClient.Builder) {
        builder.addNetworkInterceptor(StethoInterceptor())
    }
}