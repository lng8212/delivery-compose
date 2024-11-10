package com.longkd.delivery.data.di

import com.longkd.delivery.data.CategoryRepositoryImpl
import com.longkd.delivery.data.DetailCategoryRepositoryImpl
import com.longkd.delivery.domain.CategoryRepository
import com.longkd.delivery.domain.DetailCategoryRepository
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
interface DataModule {

    @Binds
    fun bindCategoryRepository(repositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    fun bindDetailCategoryRepository(repositoryImpl: DetailCategoryRepositoryImpl): DetailCategoryRepository
}