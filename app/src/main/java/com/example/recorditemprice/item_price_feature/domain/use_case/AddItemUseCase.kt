package com.example.recorditemprice.item_price_feature.domain.use_case

import com.example.recorditemprice.item_price_feature.domain.model.Item
import com.example.recorditemprice.item_price_feature.domain.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddItemUseCase(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(item: Item) {
        return withContext(Dispatchers.IO) {
            itemRepository.upsertItem(item = item)
        }
    }
}