package com.sumit.userapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sumit.userapp.database.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAllUserList():LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users :List<User>)

    @Update
    fun updateName(user: User)

    @Delete()
    fun deleteName(user: User)
}