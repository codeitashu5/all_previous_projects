package com.example.sampleprojectstructure.room

import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sampleprojectstructure.dao.UserEntityDao
import com.example.sampleprojectstructure.model.UserEntity


    @Database(entities = [UserEntity :: class] , version = 1)
    abstract class RoomDb : RoomDatabase(){
        abstract fun getUserDao() : UserEntityDao
    }

