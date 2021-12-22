package com.sumit.userapp.database

import androidx.room.*
import com.sumit.userapp.database.dao.UserDao
import com.sumit.userapp.database.model.User

@Database(
    entities = [User::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}