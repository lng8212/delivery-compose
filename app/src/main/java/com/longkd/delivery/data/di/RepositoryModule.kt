package com.longkd.delivery.data.di

import com.longkd.delivery.data.CategoryRepositoryImpl
import com.longkd.delivery.data.DetailCategoryRepositoryImpl
import com.longkd.delivery.data.ItemRepositoryImpl
import com.longkd.delivery.domain.ItemRepository
import com.longkd.delivery.domain.category.CategoryRepository
import com.longkd.delivery.domain.detailcategory.DetailCategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Author: longkd
 * @Since: 20:16 - 3/11/24
 */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCategoryRepository(repositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    fun bindDetailCategoryRepository(repositoryImpl: DetailCategoryRepositoryImpl): DetailCategoryRepository

    @Binds
    fun bindItemRepository(repositoryImpl: ItemRepositoryImpl): ItemRepository
}