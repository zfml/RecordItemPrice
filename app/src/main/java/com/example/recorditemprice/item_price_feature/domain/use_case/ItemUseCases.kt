package com.example.recorditemprice.item_price_feature.domain.use_case

import com.example.recorditemprice.item_price_feature.domain.repository.ItemRepository

class ItemUseCases(
    val getAllItemsUseCase: GetAllItemsUseCase,
    val getItemByIdUseCase: GetItemByIdUseCase,
    val findByNameItemUseCase: FindByNameItemUseCase,
    val deleteItemUseCase: DeleteItemUseCase,
    val addItemUseCase: AddItemUseCase
)