package com.longkd.delivery.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.longkd.delivery.domain.DetailCategory
import com.longkd.delivery.presentation.theme.Typography

/**
 * @Author: longkd
 * @Since: 10:28 - 9/11/24
 */


@Composable
fun DetailCategoryRoute(viewModel: DetailCategoryViewModel = hiltViewModel<DetailCategoryViewModel>()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    DetailCategoryScreen(uiState)
}

@Composable
fun DetailCategoryScreen(uiState: List<DetailCategory>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = uiState.size.toString(),
            style = Typography.headlineLarge,
            textAlign = TextAlign.Center
        )
    }
}