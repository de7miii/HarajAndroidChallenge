package com.example.harajtask.ViewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.Data.Repository
import com.example.harajtask.Models.Post

class PostsListViewModel(application: Application): BaseViewModel(application) {
    val posts = MutableLiveData<List<Post>>()

    fun fetchPosts(){
        loading.value = true
        val postsList = Repository.getAllPosts(getApplication())
        posts.value = postsList
        loading.value = false
        if(postsList.isEmpty()) empty.value = true
    }
}