package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {
    //if you try to insert an new item and it has an same id -> primary key if that value of id exist in the dataBase ignore this new entry
    //its implementation will be provided by the room it self
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)
    //item having the same id as the item you want to update
    @Update
    suspend fun update(item:Item)
    //here we have to pass the entity that we want to delete you can pass list of entity if you want
    //you have the list rows[0],row[2]...row[k] you want to delete than you can do that
    @Delete
    suspend fun delete(item:Item)
    //for any other query we have to give query our self

    @Query("select * from item order by name ASC")
    suspend fun getItems() : Flow<List<Item>>

}