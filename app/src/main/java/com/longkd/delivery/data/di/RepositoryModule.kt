package com.longkd.delivery.data.di

import com.longkd.delivery.data.repository.CardRepositoryImpl
import com.longkd.delivery.data.repository.CategoryRepositoryImpl
import com.longkd.delivery.data.repository.DetailCategoryRepositoryImpl
import com.longkd.delivery.data.repository.ItemRepositoryImpl
import com.longkd.delivery.data.repository.UserRepositoryImpl
import com.longkd.delivery.domain.card.CardRepository
import com.longkd.delivery.domain.category.CategoryRepository
import com.longkd.delivery.domain.detailcategory.DetailCategoryRepository
import com.longkd.delivery.domain.item.ItemRepository
import com.longkd.delivery.domain.user.UserRepository
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

    @Binds
    fun bindUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    fun bindCardRepository(repositoryImpl: CardRepositoryImpl): CardRepository
}