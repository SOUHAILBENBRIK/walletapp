package com.exemple.bankapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedapps.bankningappui.ui.theme.BlueStart
import com.ahmedapps.bankningappui.ui.theme.GreenEnd
import com.ahmedapps.bankningappui.ui.theme.OrangeStart
import com.ahmedapps.bankningappui.ui.theme.PurpleStart
import com.exemple.bankapp.data.FinanceClass

val financeList: List<FinanceClass> = listOf(
    FinanceClass(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusniness",
        background = OrangeStart
    ),
    FinanceClass(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    FinanceClass(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),
    FinanceClass(
        icon = Icons.Rounded.StarHalf,
        name = "My\nTransactions",
        background = GreenEnd
    ),
)

@Preview
@Composable
fun FinanceSection() {
    Text(
        text = "Finance",
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp)
    )
    LazyRow {
        items(financeList.size) { it ->
            FinanceItem(it)
        }
    }
}

@Composable
fun FinanceItem(it: Int) {
    val finance = financeList[it];
    var lastItemPadding = 0.dp;
    if (it == financeList.size - 1) {
        lastItemPadding = 16.dp;
    }
    Box(modifier=Modifier.padding(start = 16.dp, end = lastItemPadding)){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(
                MaterialTheme.colorScheme.secondaryContainer
            )
            .size(120.dp)
            .clickable { }
            .padding(13.dp), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(finance.background)
                .padding(6.dp)
        ) {
            Icon(
                imageVector = finance.icon,
                contentDescription = finance.name
            )

        }
        Text(
            text = finance.name,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
    }}
}
