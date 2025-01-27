package com.example.harajtask.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(application: Application): AndroidViewModel(application) {
    val empty = MutableLiveData<Boolean>().apply { value = false }

    val loading = MutableLiveData<Boolean>().apply { value = false }

    val toastMessage = MutableLiveData<String>()
}