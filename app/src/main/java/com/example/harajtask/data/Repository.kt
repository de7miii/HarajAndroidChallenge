package com.example.harajtask.data

import android.content.Context
import com.example.harajtask.models.Post

object Repository {
    val inMemData = InMemoryData()

    fun getAllPosts(context: Context): List<Post> {
        return inMemData.getAllPosts(context)
    }
}