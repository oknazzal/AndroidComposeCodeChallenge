package com.qpros.codechallenge.data.datasource.main

import com.qpros.codechallenge.data.model.main.RemoteNewsResponse
import com.serjltt.moshi.adapters.Wrapped
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteNewsDataSource {

    @GET("everything")
    @Wrapped(path = ["articles"])
    suspend fun getNews(@Query("q") q:String="Apple"): List<RemoteNewsResponse>

}
