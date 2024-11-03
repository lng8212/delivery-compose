package com.longkd.delivery.ui.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.longkd.delivery.R
import com.longkd.delivery.domain.Category
import com.longkd.delivery.ui.common.SearchBar
import com.longkd.delivery.ui.theme.Background
import com.longkd.delivery.ui.theme.Border
import com.longkd.delivery.ui.theme.Primary
import com.longkd.delivery.ui.theme.TextSecondary
import com.longkd.delivery.ui.theme.Typography

/**
 * @Author: longkd
 * @Since: 21:43 - 1/11/24
 */

@Composable
fun CategoryRoute(viewModel: CategoryViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    CategoryScreen(uiState = uiState) { searchQuery ->
        viewModel.onSearchTextChange(searchQuery)
    }
}

@Composable
internal fun CategoryScreen(uiState: CategoryUiState, onValueSearchChange: (String) -> Unit) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
            .background(Background)
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 40.dp),
            text = stringResource(R.string.text_categories),
            style = Typography.headlineLarge.copy(color = Primary)
        )
        SearchBar(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 28.dp)
                .border(1.dp, Border, RoundedCornerShape(28.dp))
        ) { searchQuery ->
            onValueSearchChange.invoke(searchQuery)
        }
        ListCategory(listCategory = uiState.listData)
    }
}

@Composable
fun ListCategory(modifier: Modifier = Modifier, listCategory: List<Category>) {
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 42.dp, start = 20.dp, end = 20.dp, bottom = 10.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(listCategory, key = { it.name }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Border, RoundedCornerShape(8.dp))
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = it.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = it.name,
                    style = Typography.bodyLarge.copy(color = Primary)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "(${it.total})",
                    style = Typography.labelMedium.copy(color = TextSecondary)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun CategoryRoutePreview() {
    CategoryRoute()
}