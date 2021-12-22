package com.example.sampleprojectstructure.room

import android.app.Application
import androidx.room.Room

class RoomDbCreater()  {
    fun getDb(application: Application) : RoomDb{
        val db = Room.databaseBuilder(application,RoomDb::class.java,"userDb")
          //  .fallbackToDestructiveMigration()
            .build()
        return db
    }
}