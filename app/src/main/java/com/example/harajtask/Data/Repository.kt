package com.example.harajtask.Data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.Models.Post

object Repository {
    val inMemData = InMemoryData()

    fun getAllPosts(context: Context): List<Post> {
        return inMemData.getAllPosts(context)
    }
}