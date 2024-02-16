package com.example.zoho.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.zoho.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
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
//Font families
val FONT_BOLD = FontFamily(Font(R.font.bold))
val FONT_MEDIUM = FontFamily(Font(R.font.medium))
val FONT_REGULAR = FontFamily(Font(R.font.regular))

//TextStyles
val BOLD_POST = TextStyle(
    fontFamily = FONT_BOLD,
    color = POST_TITLE,
    fontSize = 18.sp
)

val REGULAR_POST = TextStyle(
    fontFamily = FONT_REGULAR,
    color = POST_BODY,
    fontSize = 16.sp
)

val USER_TIME_STAMP = TextStyle(
    fontFamily = FONT_REGULAR,
    color = GREY,
    fontSize = 16.sp
)

val SEARCH_BAR_TEXT = TextStyle(
    fontFamily = FONT_REGULAR,
    fontSize = 16.sp,
    color = SEARCH_TEXT
)