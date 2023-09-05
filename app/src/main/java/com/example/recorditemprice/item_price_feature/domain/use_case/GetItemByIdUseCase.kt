package com.example.recorditemprice.item_price_feature.domain.use_case

import com.example.recorditemprice.item_price_feature.domain.model.Item
import com.example.recorditemprice.item_price_feature.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class GetItemByIdUseCase(
    private val itemRepository: ItemRepository
) {
     operator fun invoke(id: Int): Flow<Item> {
        return itemRepository.observeByItemById(id)
    }
}