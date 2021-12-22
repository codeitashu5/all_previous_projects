package com.example.databaseimplimentation.data

import androidx.room.*


@Entity(tableName = "person")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo(name = "name")
    val itemName : String,
    val age : Int,
    val gender : String
)
