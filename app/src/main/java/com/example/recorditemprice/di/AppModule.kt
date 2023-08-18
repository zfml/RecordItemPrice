package com.example.recorditemprice.di

import android.app.Application
import androidx.room.Room
import com.example.recorditemprice.item_price_feature.data.data_source.ItemDatabase
import com.example.recorditemprice.item_price_feature.data.repository.ItemRepositoryImpl
import com.example.recorditemprice.item_price_feature.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideItemDatabase(context: Application): ItemDatabase {
         return Room.databaseBuilder(
             context,
             ItemDatabase::class.java,
             ItemDatabase.DATABASE_NAME
         ).build()
    }

    @Provides
    @Singleton
    fun provideItemRepository(db: ItemDatabase): ItemRepository {
        return ItemRepositoryImpl(db.dao)
    }


}