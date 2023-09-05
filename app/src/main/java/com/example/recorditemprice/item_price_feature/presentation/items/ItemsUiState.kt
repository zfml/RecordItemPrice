package com.example.recorditemprice.item_price_feature.presentation.items

import com.example.recorditemprice.item_price_feature.domain.model.Item

data class ItemsUiState (
    val itemList: List<Item> = emptyList()
)