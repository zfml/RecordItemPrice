package com.example.recorditemprice.item_price_feature.presentation.addEditItem

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recorditemprice.item_price_feature.domain.model.Item
import com.example.recorditemprice.item_price_feature.domain.use_case.ItemUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditItemViewModel @Inject constructor(
    private val userCases: ItemUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[AddEditItemScreenDestination.itemId])

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    init {
        viewModelScope.launch {
            itemUiState = userCases.getItemByIdUseCase(itemId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }

    fun updateItemDetail(itemDetail: ItemDetail) {
        itemUiState = ItemUiState(
            itemDetail = itemDetail
        )
    }

    fun saveItem() {
            viewModelScope.launch {
                userCases.addItemUseCase(itemUiState.itemDetail.toItem())

        }

    }

     fun invalidInput(itemDetail: ItemDetail = itemUiState.itemDetail):Boolean {
        return  with(itemDetail) {
            name.isNotBlank() && price.isNotBlank()
        }
    }



}


fun Item.toItemUiState(isValid : Boolean): ItemUiState = ItemUiState(
    itemDetail = ItemDetail(id =id ,name = name , price = price),
    isValid = isValid
)
fun Item.toItemDetail(): ItemDetail = ItemDetail(
    id = id,
    name = name,
    price = price
)

fun ItemDetail.toItem(): Item = Item(
    id = id,
    name = name,
    price = price
)

data class ItemUiState(
    val itemDetail: ItemDetail= ItemDetail(),
    val isValid: Boolean = false
)

data class ItemDetail(
    val id: Int = 0,
    val name: String = "",
    val price: String = ""
)

