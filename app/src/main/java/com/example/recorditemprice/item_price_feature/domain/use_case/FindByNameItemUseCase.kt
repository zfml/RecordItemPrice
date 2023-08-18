package com.example.recorditemprice.item_price_feature.domain.use_case

import com.example.recorditemprice.item_price_feature.domain.model.Item
import com.example.recorditemprice.item_price_feature.domain.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class FindByNameItemUseCase(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(search: String): Flow<List<Item>> {
        return withContext(Dispatchers.IO) {
            itemRepository.findItemByName(search)
        }
    }
}