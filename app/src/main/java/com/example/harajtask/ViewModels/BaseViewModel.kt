package com.example.harajtask.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel(application: Application): AndroidViewModel(application) {
    val empty = MutableLiveData<Boolean>().apply { value = false }

    val loading = MutableLiveData<Boolean>().apply { value = false }

    val toastMessage = MutableLiveData<String>()
}