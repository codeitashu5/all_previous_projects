package com.example.sampleprojectstructure.viewModels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sampleprojectstructure.model.UserData
import com.example.sampleprojectstructure.model.UserEntity
import com.example.sampleprojectstructure.repository.Repo

const val TAG = "model"

class ActivityViewModel() : ViewModel() {
    fun getUserList(application: Application) : LiveData<List<UserEntity>>{
        val list  =  Repo(application).getUser()
        return list
    }
}