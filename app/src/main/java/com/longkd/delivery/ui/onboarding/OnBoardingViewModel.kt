package com.longkd.delivery.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longkd.delivery.data.util.DataStoreUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 22:24 - 1/11/24
 */

@HiltViewModel
class OnBoardingViewModel @Inject constructor() : ViewModel() {
    private val _isFirstInit = MutableStateFlow(DataStoreUtils.isFirstInitResult())
    val isFirstInit = _isFirstInit.asStateFlow()

    fun setFirstInit(value: Boolean) {
        viewModelScope.launch {
            DataStoreUtils.setFirstInit(value)
        }
    }
}