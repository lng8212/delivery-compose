package com.longkd.delivery

import android.app.Application
import com.longkd.utils.DataStoreUtils
import dagger.hilt.android.HiltAndroidApp

/**
 * @Author: longkd
 * @Since: 22:15 - 1/11/24
 */

@HiltAndroidApp
class DeliveryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DataStoreUtils.initialize(applicationContext)
    }
}