package com.qpros.codechallenge.data.repo

import com.qpros.codechallenge.data.datasource.main.RemoteNewsDataSource
import com.qpros.codechallenge.data.model.main.RemoteNewsResponse
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteNewsDataSource: RemoteNewsDataSource,
) {

    suspend fun getNews(): List<RemoteNewsResponse> {
        return remoteNewsDataSource.getNews()
    }

}
