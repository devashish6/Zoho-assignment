package com.example.zoho.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zoho.models.Post

@Dao
interface RoomDoa {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPosts(posts : List<Post>)

    @Query("SELECT * from Posts")
    suspend fun getAllPosts() : List<Post>

    @Query("SELECT * FROM Posts WHERE title LIKE '%' || :key || '%' OR body LIKE '%' || :key || '%'")
    suspend fun getPost(key: String) : List<Post>

    @Query("UPDATE Posts SET favorite = CASE WHEN favorite = 0 THEN 1 ELSE 0 END WHERE id = :postID")
    fun updateFavourite(postID: Int)
    @Query("SELECT * FROM Posts ORDER BY title ASC")
    fun sortByAsc() : List<Post>
}