package com.example.databaseimplimentation.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.databaseimplimentation.data.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.selects.select


@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Item)

    @Query("select * from person")
    fun getValue() : LiveData<MutableList<Item>>

    @Delete
    fun delete(item: MutableList<Item>)

    @Query("select * from person where age > 30")
    fun getResult() : LiveData<MutableList<Item>>

}