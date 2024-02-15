package com.example.zoho.di

import android.content.Context
import androidx.room.Room
import com.example.zoho.BASE_URL
import com.example.zoho.retrofit.ApiService
import com.example.zoho.room.PostsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun retrofitClient() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun apiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun dataBase(@ApplicationContext context: Context) : PostsDataBase {
        return Room.databaseBuilder(context,
            PostsDataBase::class.java,
            "Posts")
            .build()
    }
}