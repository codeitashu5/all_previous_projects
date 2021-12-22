package com.example.usingviewbindinginrecyclerandfragment.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usingviewbindinginrecyclerandfragment.adapters.Location

class LocationModel : ViewModel() {
    val listLocation  = MutableLiveData<MutableList<Location>>()

}