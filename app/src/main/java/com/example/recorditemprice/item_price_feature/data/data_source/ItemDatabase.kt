package com.example.recorditemprice.item_price_feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recorditemprice.item_price_feature.domain.model.Item

@Database(
    entities = [Item::class],
    version = 1
)
abstract class ItemDatabase: RoomDatabase(){

    abstract val dao: ItemDao
    companion object{
        const val DATABASE_NAME = "item_db"
    }
}