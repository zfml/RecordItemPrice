package com.example.recorditemprice.item_price_feature.domain.repository

import com.example.recorditemprice.item_price_feature.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getAllItems(): Flow<List<Item>>

    suspend fun upsertItem(item: Item)

    suspend fun deleteItem(item: Item)

     fun observeByItemById(id: Int): Flow<Item>

    suspend fun findItemByName(search: String): Flow<List<Item>>

}