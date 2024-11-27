package com.longkd.domain.di

import com.longkd.domain.card.CardRepository
import com.longkd.domain.category.CategoryRepository
import com.longkd.domain.detailcategory.DetailCategoryRepository
import com.longkd.domain.item.ItemRepository
import com.longkd.domain.repository.CardRepositoryImpl
import com.longkd.domain.repository.CategoryRepositoryImpl
import com.longkd.domain.repository.DetailCategoryRepositoryImpl
import com.longkd.domain.repository.ItemRepositoryImpl
import com.longkd.domain.repository.UserRepositoryImpl
import com.longkd.domain.user.UserRepository
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