package com.sumit.userapp.repository

import androidx.lifecycle.LiveData
import com.sumit.userapp.database.dao.UserDao
import com.sumit.userapp.database.model.User
import com.sumit.userapp.networking.NetWorkProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val netWorkProvider: NetWorkProvider
) {

    fun getAllUsers(): LiveData<List<User>> {

        CoroutineScope(Dispatchers.IO).launch {

            val userList = netWorkProvider.getUserList()
            userDao.insertUsers(userList)

        }
        return userDao.getAllUserList()

    }


}