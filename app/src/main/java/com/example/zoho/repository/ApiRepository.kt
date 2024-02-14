package com.example.zoho.repository

import com.example.zoho.models.Post
import com.example.zoho.retrofit.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val post: StateFlow<List<Post>>
        get() = _posts
    suspend fun getPosts() {
        val response = apiService.getPosts()
        if (response.isSuccessful && !response.body().isNullOrEmpty()) {
            _posts.emit(response.body()!!)
        }
    }
}