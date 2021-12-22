package com.example.viewmodelpractice.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelpractice.recycler.resource.User

class Model : ViewModel() {
    //the data for the list
    var userMutableList  = MutableLiveData<MutableList<User>>()
}