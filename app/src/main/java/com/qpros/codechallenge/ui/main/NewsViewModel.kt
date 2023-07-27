package com.qpros.codechallenge.ui.main

import android.os.RemoteException
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qpros.codechallenge.data.model.main.RemoteNewsResponse
import com.qpros.codechallenge.data.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
) : ViewModel() {

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> = _loadingState

    private val _responseNewsState = mutableStateListOf<RemoteNewsResponse>()
    val responseNewsState: List<RemoteNewsResponse> = _responseNewsState

    init {
        viewModelScope.launch {
            _loadingState.value = true
            try {
                _responseNewsState.addAll(newsRepository.getNews())

            } catch (remoteException: RemoteException) {

            }
            _loadingState.value = false
        }
    }
}
