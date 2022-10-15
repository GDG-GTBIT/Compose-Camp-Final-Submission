package com.example.zomatoclonegdsc.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zomatoclonegdsc.components.BottomNavBar
import com.example.zomatoclonegdsc.components.TopAppBarComposable
import com.example.zomatoclonegdsc.ui.theme.zSystemTopAppBarBgColor
import com.google.accompanist.insets.statusBarsPadding
import com.example.zomatoclonegdsc.R

@Composable
fun WalletBalance() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.account_wallet),
                contentDescription = "Wallet Icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp)
            )
            Column() {
                Text(
                    text = "Wallet Balance",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = "Powered by RBL Bank",
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )
            }
        }
        Text(
            text = "₹0.00",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}

@Composable
fun NoTransactions() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_transactions),
            contentDescription = "No Transactions",
            modifier = Modifier.size(350.dp).padding(end = 50.dp, start = 50.dp)
        )
        Text(
            text = "No Transactions found! Transaction history will appear here as you continue using your waller account",
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(15.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp
        )
    }
}

@Composable
fun WalletScreen(navController: NavController) {
    Scaffold(
        backgroundColor = zSystemTopAppBarBgColor,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .statusBarsPadding(),
                elevation = 0.dp,
                backgroundColor = Color.White
            ) {
                TopAppBarComposable()
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 45.dp),
        ) {
            WalletBalance()
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                    text = "Add Money",
                    color = Color.White
                )
            }
            NoTransactions()
        }
    }
}