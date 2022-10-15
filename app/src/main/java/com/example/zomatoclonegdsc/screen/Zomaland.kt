package com.example.zomatoclonegdsc.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zomatoclonegdsc.R
import com.example.zomatoclonegdsc.components.BottomNavBar
import com.example.zomatoclonegdsc.components.ZomalandTopAppBarComposable
import com.example.zomatoclonegdsc.data.ZomalandCities
import com.example.zomatoclonegdsc.data.getAllZomalandCities
import com.example.zomatoclonegdsc.ui.theme.zSystemTopAppBarBgColor
import com.google.accompanist.insets.statusBarsPadding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun ZomalandCityList(
    categories: List<ZomalandCities>
) {
    Text(
        text = "Explore Zomaland Cities",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 12.dp, bottom = 12.dp, top = 25.dp)
    )
    Surface() {
        val scrollState = rememberLazyListState()
        LazyRow(
            modifier = Modifier
                .background(Color.White)
                .padding(start = 10.dp, top = 10.dp),
            state = scrollState
        ) {
            items(categories) {
                ZomalandCityCard(
                    title = it.title,
                    date = it.date,
                    imageLink = it.imageLink,
                )
            }
        }
    }
}

@Composable
fun ZomalandCityCard(
    title: String,
    date: String,
    imageLink: Int
) {
    Card(
        modifier = Modifier
            .background(color = Color.White)
            .padding(end = 20.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Image(
                painter = painterResource(id = imageLink),
                contentDescription = title + " Image"
            )
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            Text(
                text = date,
                fontSize = 8.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }
    }
}

@Composable
fun Tickets() {
    Text(
        text = "Early bird tickets",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 12.dp, top = 25.dp)
    )
    Text(
        text = "Get your tickets now before they sell out!",
        color = Color.Gray,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                backgroundColor = Color.LightGray,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "DAY",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "1",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = "Dec 17, Saturday",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Available",
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
        Text(
            text = "₹699",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                backgroundColor = Color.LightGray,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "DAY",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "2",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = "Dec 18, Sunday",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Available",
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
        Text(
            text = "₹699",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}


@Composable
fun ZomalandScreen(navController: NavController) {
    Scaffold(
        backgroundColor = zSystemTopAppBarBgColor,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .statusBarsPadding(),
                elevation = 0.dp,
                backgroundColor = Color.White
            ) {
                ZomalandTopAppBarComposable()
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
            Image(
                painter = painterResource(id = R.drawable.zomaland),
                contentDescription = "Zomaland Banner",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            ZomalandCityList(categories = getAllZomalandCities())
            Tickets()
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Buy Tickets",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}