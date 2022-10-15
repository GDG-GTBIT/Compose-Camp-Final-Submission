package com.example.zomatoclonegdsc.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zomatoclonegdsc.R
import com.example.zomatoclonegdsc.components.BottomNavBar
import com.example.zomatoclonegdsc.components.FilterRowCard
import com.example.zomatoclonegdsc.components.TopAppBarComposable
import com.example.zomatoclonegdsc.data.*
import com.example.zomatoclonegdsc.navigation.Screen
import com.example.zomatoclonegdsc.screen.homeScreen.components.RestaurantImageNameCardBig
import com.example.zomatoclonegdsc.ui.theme.zSystemTopAppBarBgColor
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun DiningScreenFilterItemRow(
    categories: List<DiningScreenFilterItems>
) {
    Surface {
        val scrollState = rememberLazyListState()
        LazyRow(
            modifier = Modifier
                .background(Color.White)
                .padding(start = 10.dp),
            state = scrollState
        ) {
            items(categories) {
                FilterRowCard(
                    text = it.text,
                    leadingIcon = it.leadingIcon,
                    trailingIcon = it.trailingIcon
                )
            }
        }
    }
}

@Composable
fun CardDiningItems(title: String) {
    Column(modifier = Modifier.width(70.dp)) {
        Image(painter = painterResource(id = com.example.zomatoclonegdsc.R.drawable.coffee_cup),
            contentDescription = title,
            modifier = Modifier
                .size(70.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .shadow(2.dp)
        )
        Text(
            text = title,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            modifier = Modifier.fillMaxWidth()

        )
    }
}

@Composable
fun CardDiningScreenLogoGrid() {
    val list = (1..10).map { it.toString() }
    Column(
        modifier = Modifier
            .padding(end = 16.dp, start = 20.dp, top = 20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Eat What Makes You Happy",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 5.dp, bottom = 12.dp)
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                CardDiningItems("Premium")
                CardDiningItems("Outdoor")
                CardDiningItems("Buffet")
                CardDiningItems("Pubs & Bars")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                CardDiningItems("Events")
                CardDiningItems("Romantic")
                CardDiningItems("Cafe")
                CardDiningItems("Pure Veg")
            }
        }
        TextButton(colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black), onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "See More", fontSize = 10.sp)
            Image(painter = painterResource(
                id = com.example.zomatoclonegdsc.R.drawable.expand_more),
                contentDescription = "Expand More",
                modifier = Modifier.width(12.dp)
            )
        }
    }
}



@Composable
fun DiningCollections(
    categories: List<CuratedCollections>
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Curated Collections",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 12.dp)
        )
        Text(
                text = "See All",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 12.dp)
        )

    }

    Surface {
        val scrollState = rememberLazyListState()
        LazyRow(
            modifier = Modifier
                .background(Color.White)
                .padding(start = 10.dp),
            state = scrollState
        ) {
            items(categories) {
                CollectionRowCard(
                    title = it.title,
                    noOfPlaces = it.noOfPlaces
                )
            }
        }
    }
}

@Composable
fun CollectionRowCard(title: String, noOfPlaces: Int) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, end = 10.dp)
            .height(180.dp)
            .width(160.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Black
    ) {
        Image(
            painter = painterResource(R.drawable.dish_img),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            alpha = 0.5F,
        )
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Bottom) {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = noOfPlaces.toString() + " Places",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }
    }
}


@Composable
fun MultipleDiningScreenRestroCards(navController: NavController) {
    Column {
        Text(
            text = "Popular restaurants around you",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp, top = 10.dp, bottom = 16.dp)
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText =10,
            offerUpToText = 149,
            deliveryTimeMin = 0,
            deliveryDistanceInKms = 4,
            ratingText = 4.3f,
            restaurantName = "Cafe Delhi Heights",
            restaurantType = "North Indian, Chinese, Italian",
            closingTimeMin = 50,
            costForTwoInINR = 2000,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = false,
            isDeliveryTime = false,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText =10,
            offerUpToText = 120,
            deliveryTimeMin = 0,
            deliveryDistanceInKms = 3,
            ratingText = 4.5f,
            restaurantName = "WOW! Momo",
            restaurantType = "Momos, Tibetian",
            closingTimeMin = 50,
            costForTwoInINR = 400,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = false,
            isDeliveryTime = false,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 20,
            offerUpToText = 300,
            deliveryTimeMin = 0,
            deliveryDistanceInKms = 5,
            ratingText = 4.0f,
            restaurantName = "Cafe Canteen",
            restaurantType = "Cafe, Continental, Italian",
            closingTimeMin = 50,
            costForTwoInINR = 2000,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = false,
            isDeliveryTime = false,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
    }
}


@Composable
fun DiningScreen(navController: NavController) {
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
            AppMainSearchTextField()
            DiningScreenFilterItemRow(categories = getAllDiningScreenFilterItems())
            CardDiningScreenLogoGrid()
            DiningCollections(categories = getAllCuratedCollections())
            MultipleDiningScreenRestroCards(navController = navController)
        }
    }
}
