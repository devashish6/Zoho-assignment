package com.example.zoho.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zoho.models.Post
import com.example.zoho.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    val posts : StateFlow<List<Post>>
        get() = repository.post

    val filteredPosts : StateFlow<List<Post>>
        get() = repository.filteredPosts

    fun fetchAllPosts() {
        viewModelScope.launch {
            try {
                repository.getPosts()
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

    fun sortInAsc() {
        viewModelScope.launch {
            repository.sortInAscendingOrder()
        }
    }

    fun sortInDesc() {
        viewModelScope.launch {
            repository.sortInDescendingOrder()
        }
    }

    fun searchPosts(key: String) {
        viewModelScope.launch {
            repository.searchPostWithKey(key)
        }
    }

    fun updateFavourite(id: Int) {
        viewModelScope.launch {
            repository.updateFavourite(id)
        }
    }

}