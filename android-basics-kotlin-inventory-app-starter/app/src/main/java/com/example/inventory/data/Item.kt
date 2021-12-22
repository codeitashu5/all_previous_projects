package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Item")
data class Item(
    //it will generate new id each and every time
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    //this is used to give the a different column name to the field in the data base
    @ColumnInfo(name = "name")
    val itemName : String,
    @ColumnInfo(name = "pierce")
    val itemPrice : Double,
    @ColumnInfo(name = "quantity")
    val itemQuantityInStock : Int
)