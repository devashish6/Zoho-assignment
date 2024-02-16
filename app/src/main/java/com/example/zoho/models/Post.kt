package com.example.zoho.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Posts")
data class Post(
    val userId: Int? = 0,
    @PrimaryKey val id: Int? = 0,
    val title: String? = "",
    val body: String? = "",
    val favorite : Boolean = false
)