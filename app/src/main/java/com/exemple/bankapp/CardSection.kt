package com.exemple.bankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedapps.bankningappui.ui.theme.*

import com.exemple.bankapp.data.CardClass

val itemsCard:List<CardClass> = listOf(
    CardClass(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 56.45,
        color = getGrad(PurpleStart, PurpleEnd)


    ),
    CardClass(
        cardType = "MASTER CARD",
        cardNumber = "2364 7865 3786 3976",
        cardName = "Savings",
        balance = 780.45,
        color = getGrad(BlueStart, BlueEnd)


    ),
            CardClass(
            cardType = "VISA",
    cardNumber = "3874 7865 3786 3976",
    cardName = "School",
    balance = 120.20,
    color = getGrad(OrangeStart, OrangeEnd)


),
                    CardClass(
                    cardType = "Master Card",
    cardNumber = "3567 7865 3786 3976",
    cardName = "Trips",
    balance = 1.20,
    color = getGrad(GreenStart, GreenEnd)


),
)
fun getGrad(startColor:Color,endColor:Color):Brush{
    return Brush.horizontalGradient(
        colors = listOf(
            startColor,
            endColor
        ),
    )

}
@Preview
@Composable
fun CardSection() {
    LazyRow(

    ){
        items(itemsCard.size){
            index -> CardItem(index)
        }
    }

}

@Composable
fun CardItem(index: Int) {
    val card = itemsCard[index]
    var lastItemPaddingEnd=0.dp
    if(index == itemsCard.size-1){
        lastItemPaddingEnd=16.dp
    }
    var image = painterResource(id = R.drawable.visa);
    if(card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.mastercard);
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column (
            modifier = Modifier.clip(RoundedCornerShape(25.dp)).background(card.color).width(250.dp).height(160.dp).clickable {  }.padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter=image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text=card.cardName,
                color=Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text="$"+card.balance.toString(),
                color=Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text=card.cardNumber,
                color=Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
