package com.example.harajtask.data

import android.content.Context
import com.example.harajtask.models.Post

interface IData {
    fun getAllPosts(context: Context): List<Post>
}