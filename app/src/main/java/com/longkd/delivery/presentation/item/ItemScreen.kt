package com.longkd.delivery.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.longkd.delivery.R
import com.longkd.delivery.data.repository.Unit
import com.longkd.delivery.domain.detailcategory.DetailCategory
import com.longkd.delivery.presentation.theme.Border
import com.longkd.delivery.presentation.theme.Primary
import com.longkd.delivery.presentation.theme.PrimaryButton
import com.longkd.delivery.presentation.theme.TextSecondary
import com.longkd.delivery.presentation.theme.Typography
import com.longkd.delivery.presentation.theme.WeightPerUnit

/**
 * @Author: longkd
 * @Since: 20:58 - 13/11/24
 */

@Composable
fun ItemRoute(viewModel: ItemViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    uiState.detailCategory?.let {
        ItemScreen(detailCategory = it, onInsertItem = { item ->
            viewModel.insertItem(item)
        })
    }
}

@Composable
fun ItemScreen(
    modifier: Modifier = Modifier,
    detailCategory: DetailCategory,
    onInsertItem: (DetailCategory) -> kotlin.Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = detailCategory.image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.BottomCenter)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                )
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 36.dp),
                text = detailCategory.name,
                style = Typography.headlineLarge.copy(color = Primary)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = detailCategory.price.toString(),
                    style = Typography.headlineSmall.copy(color = Primary, fontSize = 32.sp)
                )
                Text(
                    text = "€/${detailCategory.unit.value}",
                    style = Typography.bodySmall.copy(color = TextSecondary, fontSize = 24.sp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "~${detailCategory.weightPerUnit} / ${detailCategory.unit.value}",
                style = Typography.labelMedium.copy(fontSize = 17.sp, color = WeightPerUnit)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = detailCategory.from,
                style = Typography.headlineSmall.copy(fontSize = 22.sp, color = Primary)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = detailCategory.description,
                style = Typography.labelMedium.copy(color = TextSecondary, fontSize = 17.sp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 60.dp)
            ) {
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
                    .weight(1f)
                    .background(PrimaryButton, RoundedCornerShape(10.dp))
                    .padding(horizontal = 20.dp, vertical = 6.dp),
                    onClick = { onInsertItem.invoke(detailCategory) }) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_shopping_cart),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "ADD TO CART",
                            style = Typography.bodyMedium.copy(
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun ItemScreenPreview() {
    ItemScreen(
        detailCategory = DetailCategory(
            "4",
            "2",
            "Savoy Cabbage",
            R.drawable.ic_savoy_cabbage,
            1.45f,
            Unit.KILOGRAM,
            "150g",
            "Spain",
            "A type of vegetables"
        ),
        onInsertItem = {

        }
    )
}