package com.longkd.delivery.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.longkd.delivery.R

// Set of Material typography styles to start with


val font = FontFamily(
    Font(
        resId = R.font.pro_display_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.pro_text_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.pro_text_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.pro_text_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.pro_text_bold
    ),
    Font(
        R.font.pro_display_medium
    )
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        lineHeight = 41.sp,
        letterSpacing = 0.41.sp

    ),
    bodySmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.41.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.41.sp
    ),
    labelMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.41.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)