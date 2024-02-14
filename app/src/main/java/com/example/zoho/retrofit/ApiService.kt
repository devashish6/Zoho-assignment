package com.example.zoho.retrofit

import com.example.zoho.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts() : Response<List<Post>>
}