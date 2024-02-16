package com.example.zoho.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zoho.models.Post

@Database(entities = [Post::class], version = 3, exportSchema = false)
abstract class PostsDataBase : RoomDatabase() {

    abstract fun postsDao() : RoomDoa

}