package com.example.zoho.repository

import com.example.zoho.models.Post
import com.example.zoho.retrofit.ApiService
import com.example.zoho.room.PostsDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService,
                                        private val postsDataBase: PostsDataBase) {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    private val _filteredPosts = MutableStateFlow<List<Post>>(emptyList())
    val post: StateFlow<List<Post>>
        get() = _posts

    val filteredPosts: StateFlow<List<Post>>
        get() = _filteredPosts
    suspend fun getPosts() {
        val offLineResponse = postsDataBase.postsDao().getAllPosts()

        if (offLineResponse.isNotEmpty()) {
            _posts.emit(offLineResponse)
        } else {
            val response = apiService.getPosts()
            if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                postsDataBase.postsDao().addPosts(response.body()!!)
                _posts.emit(response.body()!!)
            }
        }
    }

    suspend fun searchPostWithKey(key: String) {
        if (key.isEmpty()) {
            _filteredPosts.emit(emptyList())
        } else {
            val filteredResult = postsDataBase.postsDao().getPost(key)
            _filteredPosts.emit(filteredResult)
        }
    }

    suspend fun updateFavourite(postID: Int) {
        withContext(Dispatchers.IO) {
            postsDataBase.postsDao().updateFavourite(postID)
        }
    }

    suspend fun sortInAscendingOrder() {
        withContext(Dispatchers.IO) {
            val offLineResponse = postsDataBase.postsDao().sortByAsc()
            _posts.emit(offLineResponse)
        }
    }

    suspend fun sortInDescendingOrder() {
        withContext(Dispatchers.IO) {
            val offLineResponse = postsDataBase.postsDao().sortByDesc()
            _posts.emit(offLineResponse)
        }
    }
}