package com.example.recorditemprice.item_price_feature.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recorditemprice.item_price_feature.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getAllItems(): Flow<List<Item>>

    suspend fun upsertItem(item: Item)

    suspend fun deleteItem(item: Item)

    suspend fun getItemById(id: Int): Item?

    suspend fun findItemByName(search: String): Flow<List<Item>>

}