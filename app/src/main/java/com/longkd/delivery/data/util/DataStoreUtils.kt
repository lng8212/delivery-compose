package com.longkd.delivery.data.util

import android.content.Context
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @Author: longkd
 * @Since: 22:17 - 1/11/24
 */

object DataStoreUtils {
    private const val TAG = "Play"
    private const val IS_FIRST_INIT = "IS_FIRST_INIT"

    private lateinit var dataStore: DataStoreConfig
    fun initialize(c: Context?) {
        if (c == null) {
            Log.w(TAG, "initialize: context is null")
            return
        }
        dataStore = DataStoreConfig.init(c)

    }


    fun isFirstInit(): Flow<Boolean> {
        return if (::dataStore.isInitialized) {
            dataStore.readBooleanFlow(IS_FIRST_INIT)
        } else {
            flow {
                emit(false)
            }
        }
    }

    fun isFirstInitResult(): Boolean {
        return if (::dataStore.isInitialized) {
            dataStore.readBooleanData(IS_FIRST_INIT, default = true)
        } else {
            false
        }
    }

    suspend fun setFirstInit(isFirstInit: Boolean) {
        dataStore.saveBooleanData(IS_FIRST_INIT, isFirstInit)
    }
}