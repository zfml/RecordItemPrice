package com.example.recorditemprice.item_price_feature.presentation.addEditItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recorditemprice.R
import com.example.recorditemprice.item_price_feature.presentation.navigation.NavigationDestination


object AddEditItemScreenDestination: NavigationDestination {
    override val rout: String = "AddEditItemScreen"
    const val itemId: String = "ItemId"
    val routeArg = "${rout}/{$itemId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditItemScreen(
    modifier: Modifier = Modifier,
    viewModel: AddEditItemViewModel = hiltViewModel(),
    navigateToItemsScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                    text = ""
                )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navigateToItemsScreen()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back to Home Screen"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.saveItem()
                navigateToItemsScreen()
            }) {
                Icon(
                painter = painterResource(id = R.drawable.baseline_save_24),
                contentDescription = stringResource(id = R.string.save_item)
                )
            }                       
        }
        ,
        content = { innerPadding ->
            AddEditItemContent(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                itemDetail = viewModel.itemUiState.itemDetail,
                onItemValueChange = viewModel::updateItemDetail,
                enabled = viewModel.itemUiState.isValid
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditItemContent(
    modifier: Modifier = Modifier,
    itemDetail: ItemDetail,
    onItemValueChange: (ItemDetail) -> Unit,
    enabled: Boolean = true
) {
    Column(
        modifier = modifier
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = itemDetail.name,
            onValueChange = {onItemValueChange(itemDetail.copy(name = it))},
            singleLine = true,
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = itemDetail.price,
            onValueChange = {onItemValueChange(itemDetail.copy(price = it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )

    }
}