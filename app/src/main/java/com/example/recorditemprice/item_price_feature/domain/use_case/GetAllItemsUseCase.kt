package com.example.recorditemprice.item_price_feature.domain.use_case

import com.example.recorditemprice.item_price_feature.domain.model.Item
import com.example.recorditemprice.item_price_feature.domain.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GetAllItemsUseCase(
    private val itemRepository: ItemRepository
) {
  operator fun invoke(): Flow<List<Item>> {
        return itemRepository.getAllItems()
    }
}