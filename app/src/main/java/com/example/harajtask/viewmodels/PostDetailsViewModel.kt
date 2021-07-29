package com.example.harajtask.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.harajtask.models.Post

class PostDetailsViewModel(application: Application): BaseViewModel(application) {
    val postDetails = MutableLiveData<Post>()
}