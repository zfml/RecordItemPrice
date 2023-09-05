package com.example.recorditemprice.item_price_feature.data.repository

import com.example.recorditemprice.item_price_feature.data.data_source.ItemDao
import com.example.recorditemprice.item_price_feature.domain.model.Item
import com.example.recorditemprice.item_price_feature.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(
    private  val dao: ItemDao
): ItemRepository {
    override fun getAllItems(): Flow<List<Item>> = dao.getAllItems()

    override suspend fun upsertItem(item: Item) = dao.upsertItem(item)

    override suspend fun deleteItem(item: Item) = dao.deleteItem(item)

    override  fun observeByItemById(id: Int): Flow<Item> = dao.observeByItemById(id)

    override suspend fun findItemByName(search: String): Flow<List<Item>> = dao.findItemByName(search)
}