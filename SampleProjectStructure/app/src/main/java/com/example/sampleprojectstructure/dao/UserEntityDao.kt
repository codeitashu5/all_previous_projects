package com.example.sampleprojectstructure.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sampleprojectstructure.model.UserEntity

@Dao
interface UserEntityDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: UserEntity)

    @Query("delete from userTable")
    suspend fun delete()

    @Query("select * from userTable")
     fun getUser() : LiveData<List<UserEntity>>



}