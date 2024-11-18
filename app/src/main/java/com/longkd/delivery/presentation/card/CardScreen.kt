package com.longkd.delivery.presentation.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.longkd.delivery.R
import com.longkd.delivery.domain.card.Card
import com.longkd.delivery.domain.card.CardType
import com.longkd.delivery.presentation.theme.Border
import com.longkd.delivery.presentation.theme.Primary
import com.longkd.delivery.presentation.theme.PrimaryButton
import com.longkd.delivery.presentation.theme.TextSecondary
import com.longkd.delivery.presentation.theme.Typography
import com.longkd.delivery.util.StringUtils

/**
 * @Author: longkd
 * @Since: 22:02 - 18/11/24
 */

@Composable
fun CardRoute(
    modifier: Modifier = Modifier,
    viewModel: CardViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    uiState.card?.let {
        CardScreen(
            card = it,
            onChangeName = { newName ->
                viewModel.onChangeName(newName)
            },
            onChangeCardNumber = { newNumber ->
                viewModel.onChangeCardNumber(newNumber)
            },
            onChangeExpireDate = { newDate ->
                viewModel.onChangeExpireDate(newDate)
            },
            onCVC = { newCVC ->
                viewModel.onChangeCVC(newCVC)
            },
            onBack = onBack
        )
    }
}

@Composable
fun CardScreen(
    modifier: Modifier = Modifier,
    card: Card,
    onChangeName: (String) -> Unit,
    onChangeCardNumber: (String) -> Unit,
    onChangeExpireDate: (String) -> Unit,
    onCVC: (String) -> Unit,
    onBack: () -> Unit,
) {
    val focusManager = LocalFocusManager.current
    Column(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        }) {
        Icon(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .clickable {
                    onBack.invoke()
                },
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp),
            text = stringResource(R.string.text_credit_debit_card),
            style = Typography.headlineLarge.copy(color = Primary)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .paint(
                    painter = painterResource(id = R.drawable.img_bg_card),
                    contentScale = ContentScale.FillWidth
                )
        ) {
            Image(
                modifier = Modifier
                    .align(alignment = Alignment.End)
                    .padding(top = 60.dp, end = 60.dp),
                painter = painterResource(id = R.drawable.ic_master_card),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally),
                text = StringUtils.cardStyle(card.number),
                style = Typography.labelMedium.copy(color = Color.White, fontSize = 26.sp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp, top = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = card.name,
                    style = Typography.labelMedium.copy(color = Color.White, fontSize = 20.sp)
                )
                Text(
                    text = card.expireDate,
                    style = Typography.labelMedium.copy(color = Color.White, fontSize = 20.sp)
                )
            }
        }
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_photo),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = 12.dp, start = 34.dp),
            text = stringResource(R.string.text_name_on_card),
            style = Typography.labelMedium.copy(color = TextSecondary, fontSize = 14.sp)
        )
        TextField(
            textStyle = Typography.labelMedium.copy(color = Primary, fontSize = 17.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .border(1.dp, Border, RoundedCornerShape(8.dp)),
            value = card.name,
            onValueChange = {
                onChangeName.invoke(it)
            },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(top = 12.dp, start = 34.dp),
            text = stringResource(R.string.text_card_number),
            style = Typography.labelMedium.copy(color = TextSecondary, fontSize = 14.sp)
        )
        TextField(
            textStyle = Typography.labelMedium.copy(color = Primary, fontSize = 17.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .border(1.dp, Border, RoundedCornerShape(8.dp)),
            value = StringUtils.cardStyle(card.number),
            onValueChange = {
                onChangeCardNumber.invoke(it.replace(" ", ""))
            },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    tint = Color.Unspecified,
                    painter = painterResource(id = R.drawable.ic_small_mastercard),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    modifier = Modifier.padding(start = 14.dp),
                    text = stringResource(R.string.text_expire_date),
                    style = Typography.labelMedium.copy(color = TextSecondary, fontSize = 14.sp)
                )
                TextField(
                    textStyle = Typography.labelMedium.copy(color = Primary, fontSize = 17.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Border, RoundedCornerShape(8.dp)),
                    value = card.expireDate,
                    onValueChange = {
                        onChangeExpireDate.invoke(it)
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            Spacer(modifier = Modifier.width(22.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    modifier = Modifier.padding(start = 14.dp),
                    text = stringResource(R.string.text_cvc),
                    style = Typography.labelMedium.copy(color = TextSecondary, fontSize = 14.sp)
                )
                TextField(
                    textStyle = Typography.labelMedium.copy(color = Primary, fontSize = 17.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Border, RoundedCornerShape(8.dp)),
                    value = card.cvc.toString(),
                    onValueChange = {
                        onCVC.invoke(it)
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.padding(end = 16.dp),
                            tint = Color.Unspecified,
                            painter = painterResource(id = R.drawable.ic_cvc),
                            contentDescription = null
                        )
                    }
                )
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .background(PrimaryButton, shape = RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryButton),
            onClick = {

            }) {
            Text(
                text = stringResource(R.string.text_use_this_card),
                style = Typography.bodyMedium
            )
        }
    }
}

@Composable
@Preview(backgroundColor = 0XFFFFFFFF, showBackground = true)
fun CardScreenPreview() {
    CardScreen(
        card = Card(
            "1234567812345678",
            "Larry Kieu",
            expireDate = "07/21",
            cvc = 474,
            cardType = CardType.MASTER
        ),
        onChangeCardNumber = {}, onChangeName = {}, onCVC = {}, onChangeExpireDate = {}, onBack = {}
    )
}
