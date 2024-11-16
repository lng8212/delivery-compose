package com.longkd.delivery.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

/**
 * @Author: longkd
 * @Since: 10:45 - 16/11/24
 */

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: DispatcherType)


enum class DispatcherType {
    Main,
    IO,
    Default
}

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @Dispatcher(DispatcherType.Main)
    fun provideMainDispatcher() = Dispatchers.Main

    @Provides
    @Dispatcher(DispatcherType.IO)
    fun provideIODispatcher() = Dispatchers.IO

    @Provides
    @Dispatcher(DispatcherType.Default)
    fun provideDefaultDispatcher() = Dispatchers.Default
}