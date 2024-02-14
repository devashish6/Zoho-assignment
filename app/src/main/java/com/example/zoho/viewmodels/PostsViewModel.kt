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

    init {
        viewModelScope.launch {
            repository.getPosts()
        }
    }
}