package com.longkd.delivery.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.longkd.delivery.R
import com.longkd.delivery.ui.common.SearchBar
import com.longkd.delivery.ui.theme.Background
import com.longkd.delivery.ui.theme.Border
import com.longkd.delivery.ui.theme.Typography

/**
 * @Author: longkd
 * @Since: 21:43 - 1/11/24
 */

@Composable
fun CategoryRoute() {
    val viewModel: CategoryViewModel = hiltViewModel()
    CategoryScreen()
}

@Composable
fun CategoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 40.dp),
            text = stringResource(R.string.text_categories),
            style = Typography.headlineLarge
        )
        SearchBar(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 28.dp)
                .border(1.dp, Border, RoundedCornerShape(28.dp))
        ) {

        }
    }
}

@Preview
@Composable
fun CategoryRoutePreview() {
    CategoryRoute()
}