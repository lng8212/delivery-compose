package com.longkd.delivery.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.longkd.delivery.R
import com.longkd.delivery.domain.DetailCategory
import com.longkd.delivery.presentation.common.SearchBar
import com.longkd.delivery.presentation.theme.Background
import com.longkd.delivery.presentation.theme.Border
import com.longkd.delivery.presentation.theme.Primary
import com.longkd.delivery.presentation.theme.PrimaryButton
import com.longkd.delivery.presentation.theme.TextSecondary
import com.longkd.delivery.presentation.theme.Typography

/**
 * @Author: longkd
 * @Since: 10:28 - 9/11/24
 */


@Composable
fun DetailCategoryRoute(
    viewModel: DetailCategoryViewModel = hiltViewModel<DetailCategoryViewModel>(),
    onBack: () -> Unit,
    onClickItem: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    DetailCategoryScreen(
        listItem = uiState.listItem,
        name = uiState.headerName,
        onValueSearchChange = {
            viewModel.onSearchTextChange(it)
        },
        onBack = {
            onBack.invoke()
        },
        onClickItem = onClickItem
    )
}

@Composable
fun DetailCategoryScreen(
    listItem: List<DetailCategory>,
    name: String,
    onValueSearchChange: (String) -> Unit,
    onBack: () -> Unit,
    onClickItem: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Image(
            modifier = Modifier.align(Alignment.TopEnd),
            painter = painterResource(id = R.drawable.img_vegetable),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                    })
                }
        ) {
            Icon(
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .clickable { onBack.invoke() },
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp),
                text = name,
                style = Typography.headlineLarge.copy(color = Primary)
            )
            SearchBar(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 28.dp)
                    .border(1.dp, Border, RoundedCornerShape(28.dp))
            ) { searchQuery ->
                onValueSearchChange.invoke(searchQuery)
            }
            ListCategoryDetail(listItem = listItem, onClickItem = onClickItem)
        }
    }
}


@Composable
fun ListCategoryDetail(
    modifier: Modifier = Modifier,
    listItem: List<DetailCategory>,
    onClickItem: (String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(
            top = 42.dp,
            start = 20.dp,
            end = 20.dp,
            bottom = 10.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = listItem, key = { it.id }) { item ->
            CategoryDetailItem(item = item, onClickItem = onClickItem)
        }
    }

}

@Composable
fun CategoryDetailItem(
    modifier: Modifier = Modifier,
    item: DetailCategory,
    onClickItem: (String) -> Unit,
) {
    Row(modifier = modifier
        .padding(vertical = 16.dp)
        .clickable { onClickItem.invoke(item.id) }) {
        Image(
            modifier = Modifier
                .weight(1f)
                .height(128.dp),
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = item.name, style = Typography.displayLarge.copy(color = Primary))
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.price.toString(),
                    style = Typography.headlineSmall.copy(color = Primary)
                )
                Text(
                    text = "€/${item.unit.value}",
                    style = Typography.bodySmall.copy(color = TextSecondary)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                IconButton(modifier = Modifier
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .border(1.dp, Border, RoundedCornerShape(10.dp))
                    .padding(horizontal = 20.dp, vertical = 6.dp),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favourite),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                IconButton(modifier = Modifier
                    .background(PrimaryButton, RoundedCornerShape(10.dp))
                    .padding(horizontal = 20.dp, vertical = 6.dp),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_shopping_cart),
                        contentDescription = null
                    )
                }
            }
        }
    }
}