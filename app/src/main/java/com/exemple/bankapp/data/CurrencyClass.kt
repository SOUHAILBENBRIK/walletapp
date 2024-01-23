package com.exemple.bankapp.data

import androidx.compose.ui.graphics.vector.ImageVector

data class CurrencyClass(
    val name: String,
    val buy: Float,
    val sell: Float,
    val icon: ImageVector
)
