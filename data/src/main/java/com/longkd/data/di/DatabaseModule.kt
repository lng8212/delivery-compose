package com.longkd.data.di

import android.content.Context
import androidx.room.Room
import com.longkd.data.database.DeliveryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: longkd
 * @Since: 10:26 - 16/11/24
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DeliveryDatabase {
        return Room.databaseBuilder(
            context,
            DeliveryDatabase::class.java,
            "delivery_database"
        ).build()
    }

    @Provides
    fun provideItemDao(database: DeliveryDatabase) = database.itemDao()
}