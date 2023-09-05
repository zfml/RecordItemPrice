package com.example.recorditemprice.item_price_feature.presentation.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recorditemprice.R
import com.example.recorditemprice.item_price_feature.presentation.components.ItemComponent
import com.example.recorditemprice.item_price_feature.presentation.navigation.NavigationDestination

object ItemsScreenDestination: NavigationDestination{
    override val rout: String = "ItemsScreen"

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  ItemsScreen(
    viewModel: ItemsViewModel = hiltViewModel(),
    navigateToAddEditScreen: () -> Unit,
    navigateToEditScreen:(Int) -> Unit
) {
    val uiState = viewModel.itemsUiState.collectAsState()

    Scaffold(
        topBar = {
             TopAppBar(
                 title = {Text(text = stringResource(id = R.string.Item_title))}
             )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigateToAddEditScreen()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add ,
                    contentDescription = stringResource(id = R.string.add_item)
                )
            }
        },
        content = { innerPading ->
            Column(
                modifier = Modifier.padding(innerPading)
            ) {
                LazyColumn() {
                    items(uiState.value.itemList, key = {item-> item.id}) { item ->
                        ItemComponent(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                   navigateToEditScreen(item.id)
                                }
                            ,
                            item = item,
                            onDeleteItem = {viewModel.deleteItem(item)}
                        )
                    }
                }
            }
        }
    )
}
