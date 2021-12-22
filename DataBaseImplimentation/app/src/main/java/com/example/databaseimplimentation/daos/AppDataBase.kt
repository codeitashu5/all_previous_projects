package com.example.databaseimplimentation.daos

import android.provider.DocumentsContract
import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.databaseimplimentation.data.Item

@Database(entities = [Item::class],version = 2)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDaoItem() : ItemDao
}