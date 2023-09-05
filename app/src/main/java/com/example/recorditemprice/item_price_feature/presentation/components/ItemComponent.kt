package com.example.recorditemprice.item_price_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recorditemprice.item_price_feature.domain.model.Item

@Composable
fun ItemComponent(
    modifier: Modifier = Modifier,
    item: Item,
    onDeleteItem:() -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Row(
           modifier = Modifier
               .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.price,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = {
               onDeleteItem()
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Item"
                )
            }
        }

    }
}

@Composable
@Preview
fun ItemPreview() {
    ItemComponent(
        item = Item(0,"Coffee","$200"),
        onDeleteItem = {}
    )
}