package com.longkd.presentation.cart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.longkd.domain.user.DeliveryOptions
import com.longkd.domain.user.User
import com.longkd.presentation.R
import com.longkd.presentation.theme.CheckedSwitchBackground
import com.longkd.presentation.theme.Primary
import com.longkd.presentation.theme.SelectedViolet
import com.longkd.presentation.theme.TextSecondary
import com.longkd.presentation.theme.Typography
import com.longkd.utils.StringUtils

/**
 * @Author: longkd
 * @Since: 10:07 - 16/11/24
 */

@Composable
fun CartRoute(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = hiltViewModel(),
    onNavigateCard: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    uiState.userData?.let {
        CartScreen(
            user = it,
            selectedOption = uiState.deliveryOptions,
            currentState = uiState.isNonContact,
            onClickItem = { newOption ->
                viewModel.updateDeliveryOptions(newOption)
            },
            onClickSwitch = {
                viewModel.updateContactState()
            },
            onChangeClick = onNavigateCard
        )
    }
}

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    user: User,
    selectedOption: DeliveryOptions,
    currentState: Boolean,
    onClickItem: (DeliveryOptions) -> Unit,
    onClickSwitch: () -> Unit,
    onChangeClick: (id: String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 54.dp),
            text = stringResource(R.string.text_checkout),
            style = Typography.headlineLarge.copy(color = Primary)
        )
        PaymentRow(
            modifier = Modifier.padding(top = 20.dp),
            name = "Payment method",
            onChangeClick = {
                onChangeClick.invoke(user.paymentCard)
            })
        PaymentRowDetail(
            modifier = Modifier.padding(top = 16.dp),
            icon = R.drawable.ic_credit_card,
            text = StringUtils.paymentCardFormat(user.paymentCard)
        )
        PaymentRow(modifier = Modifier.padding(top = 32.dp), name = "Delivery address")
        PaymentRowDetail(
            icon = R.drawable.ic_home,
            text = user.address,
            isCenterAlign = false
        )
        PaymentRow(modifier = Modifier.padding(top = 32.dp), name = "Delivery options")
        PaymentRowDetail(
            modifier = Modifier.padding(top = 16.dp),
            icon = R.drawable.ic_walking,
            text = "I'll pick it up myself",
            isCheck = selectedOption == DeliveryOptions.BY_MYSELF
        ) {
            onClickItem.invoke(DeliveryOptions.BY_MYSELF)
        }
        PaymentRowDetail(
            icon = R.drawable.ic_bike,
            text = "By courier",
            isCheck = selectedOption == DeliveryOptions.BY_COURIER
        ) {
            onClickItem.invoke(DeliveryOptions.BY_COURIER)
        }
        PaymentRowDetail(
            icon = R.drawable.ic_drone,
            text = "By drone",
            isCheck = selectedOption == DeliveryOptions.BY_DRONE
        ) {
            onClickItem.invoke(DeliveryOptions.BY_DRONE)
        }
        PaymentRow(
            currentState = currentState,
            modifier = Modifier.padding(top = 20.dp),
            name = "Non-contact-delivery",
            isSwitch = true,
            onClickSwitch = {
                onClickSwitch.invoke()
            }
        )
    }
}

@Composable
fun PaymentRow(
    modifier: Modifier = Modifier,
    name: String,
    currentState: Boolean? = null,
    isSwitch: Boolean = false,
    onChangeClick: (() -> Unit)? = null,
    onClickSwitch: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = name, style = Typography.headlineLarge.copy(color = Primary, fontSize = 22.sp))
        if (isSwitch) {
            Switch(
                modifier = Modifier
                    .width(74.dp)
                    .height(30.dp),
                checked = currentState ?: true, onCheckedChange = {
                    onClickSwitch?.invoke()
                },
                colors = SwitchDefaults.colors(checkedTrackColor = CheckedSwitchBackground)
            )
        } else Text(
            modifier = Modifier.clickable {
                onChangeClick?.invoke()
            },
            text = "CHANGE",
            style = Typography.bodyMedium.copy(color = SelectedViolet, fontSize = 15.sp)
        )
    }
}

@Composable
fun PaymentRowDetail(
    modifier: Modifier = Modifier,
    icon: Int,
    text: String,
    isCheck: Boolean = false,
    isCenterAlign: Boolean = true,
    onClickItem: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable {
                onClickItem?.invoke()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = if (isCenterAlign) Alignment.CenterVertically else Alignment.Top
    ) {
        Row(modifier = Modifier.weight(1f)) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = if (isCheck) SelectedViolet else TextSecondary
            )
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = text,
                style = if (isCheck) Typography.bodyMedium.copy(
                    color = SelectedViolet, fontSize = 17.sp,
                    lineHeight = 28.sp,
                ) else Typography.labelMedium.copy(
                    color = TextSecondary,
                    fontSize = 17.sp,
                    lineHeight = 28.sp,
                )
            )
        }

        if (isCheck) {
            Icon(painter = painterResource(id = R.drawable.ic_check), contentDescription = null)
        }
    }
}


@Composable
@Preview(backgroundColor = 0XFFF6F5F5, showBackground = true)
fun CartScreenPreview() {
    CartScreen(
        user = User(
            name = "Larry",
            address = "Trump Building, 200 Louis St\nHanoi, Vietnam",
            paymentCard = "1234567812345678",
            deliveryOptions = DeliveryOptions.BY_DRONE
        ),
        currentState = true,
        onClickItem = {},
        onClickSwitch = {},
        selectedOption = DeliveryOptions.BY_DRONE,
        onChangeClick = {}
    )
}