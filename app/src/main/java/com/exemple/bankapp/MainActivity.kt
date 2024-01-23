package com.exemple.bankapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exemple.bankapp.ui.theme.BankAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background);
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}
@Composable
private fun SetBarColor(color: Color){
   val systemUiController = rememberSystemUiController() ;
    SideEffect {
        systemUiController.setSystemBarsColor(
            color=color
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
      bottomBar = {
          BottomNavigationBar()
      }
    ){
        padding ->Column (modifier = Modifier.fillMaxSize().padding(padding)){
            WalletSection()
            CardSection()
            Spacer(modifier = Modifier.height(12.dp))
            FinanceSection()
            CurrencySection()
        }

    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankAppTheme {
        HomeScreen()
    }
}