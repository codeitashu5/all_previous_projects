package com.sumit.userapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sumit.userapp.database.model.User
import com.sumit.userapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    fun getUserList(): LiveData<List<User>> = userRepository.getAllUsers()
}