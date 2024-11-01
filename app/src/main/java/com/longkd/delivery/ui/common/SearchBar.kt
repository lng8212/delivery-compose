package com.longkd.delivery.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.longkd.delivery.R
import com.longkd.delivery.ui.theme.TextSecondary
import com.longkd.delivery.ui.theme.Typography

/**
 * @Author: longkd
 * @Since: 23:28 - 1/11/24
 */

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    initValue: String = "",
    onValueChange: (String) -> Unit,
) {
    var value by rememberSaveable {
        mutableStateOf(initValue)
    }
    TextField(
        textStyle = Typography.bodyMedium,
        value = value,
        onValueChange = {
            value = it
            onValueChange.invoke(it)
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(
                    start = 22.dp,
                    top = 12.dp,
                    bottom = 12.dp,
                    end = 16.dp
                ),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(28.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                stringResource(R.string.text_search),
                style = Typography.bodySmall,
                color = TextSecondary
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    )
}