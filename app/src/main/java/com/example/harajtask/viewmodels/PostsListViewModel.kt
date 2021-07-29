package com.example.harajtask.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.data.Repository
import com.example.harajtask.models.Post

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