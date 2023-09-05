package com.example.recorditemprice.item_price_feature.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recorditemprice.item_price_feature.domain.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
     fun getAllItems(): Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun observeByItemById(id: Int): Flow<Item>

    @Query("SELECT * From item WHERE name LIKE :search")
    fun findItemByName(search: String): Flow<List<Item>>



}