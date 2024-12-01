package com.longkd.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.longkd.presentation.R
import com.longkd.presentation.theme.Background
import com.longkd.presentation.theme.Onboarding
import com.longkd.presentation.theme.Primary
import com.longkd.presentation.theme.PrimaryButton
import com.longkd.presentation.theme.TextSecondary
import com.longkd.presentation.theme.Typography

/**
 * @Author: longkd
 * @Since: 21:15 - 29/10/24
 */

@Composable
fun OnboardingScreen(
    viewModel: OnBoardingViewModel,
    onNavigateToHome: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Onboarding)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_onboarding_background),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(0.652f)
                .align(alignment = Alignment.BottomCenter)
                .fillMaxWidth()
                .background(
                    color = Background,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(top = 60.dp),
                painter = painterResource(id = R.drawable.ic_app),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 44.dp, end = 44.dp, top = 24.dp),
                text = stringResource(R.string.text_non_contact_deliveries),
                style = Typography.headlineLarge.copy(color = Primary),
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 20.dp, end = 20.dp),
                textAlign = TextAlign.Center,
                style = Typography.bodySmall.copy(color = TextSecondary),
                text = stringResource(R.string.text_detail_onboarding)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 20.dp, end = 20.dp)
                    .background(PrimaryButton, shape = RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryButton),
                onClick = {
                    viewModel.setFirstInit(false)
                    onNavigateToHome.invoke()
                }) {
                Text(
                    text = stringResource(R.string.text_order_now),
                    style = Typography.bodyMedium
                )
            }
        }
    }
}
