package com.example.recorditemprice.item_price_feature.presentation.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recorditemprice.item_price_feature.domain.model.Item
import com.example.recorditemprice.item_price_feature.domain.use_case.ItemUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val useCase: ItemUseCases
): ViewModel(){

    private val _itemsUiState = MutableStateFlow(ItemsUiState())

    val itemsUiState: StateFlow<ItemsUiState> =
        useCase.getAllItemsUseCase()
            .map {
                ItemsUiState(itemList = it)
            }.stateIn(
                viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemsUiState()
            )


    fun deleteItem(item: Item) {
        viewModelScope.launch {
            useCase.deleteItemUseCase(item)
        }
    }

    companion object{
        const val TIMEOUT_MILLIS = 5_000L
    }


}