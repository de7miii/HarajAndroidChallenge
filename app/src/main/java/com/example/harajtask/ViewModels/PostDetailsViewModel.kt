package com.example.harajtask.ViewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.Models.Post

class PostDetailsViewModel(application: Application): BaseViewModel(application) {
    val postDetails = MutableLiveData<Post>()
}