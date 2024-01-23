package com.exemple.bankapp.data

import androidx.compose.ui.graphics.Brush

data class CardClass(
    val cardType : String,
    val cardNumber : String,
    val cardName : String,
    val balance : Double,
    val color :Brush
)