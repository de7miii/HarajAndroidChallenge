package com.example.harajtask.Data

import android.content.Context
import com.example.harajtask.Models.Post

interface IData {
    fun getAllPosts(context: Context): List<Post>
}