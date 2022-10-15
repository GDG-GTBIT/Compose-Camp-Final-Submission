package com.example.zomatoclonegdsc.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zomatoclonegdsc.R
import com.example.zomatoclonegdsc.components.DishCardItem
import com.example.zomatoclonegdsc.components.OfferRowItem
import com.example.zomatoclonegdsc.ui.theme.zLightGreyBorder
import com.example.zomatoclonegdsc.ui.theme.zSystemTopAppBarBgColor
import com.google.accompanist.insets.statusBarsPadding


@Composable
fun RestaurantScreenBottomBar(
    offerPercentageText: Int?,
    offerUpToText: Int?
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF6F6FF))
    ) {
        Text(
            text = "Get $offerPercentageText% OFF up to ₹$offerUpToText. Use coupon TASTY on orders above ₹159",
            color = Color(0xFF667CBB),
            fontSize = 10.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Composable
fun RestaurantScreenFAB() {
    Card(
        shape = CircleShape,
        elevation = 8.dp,
        contentColor = Color.White,
        backgroundColor = Color.Black
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.fab_icon),
                contentDescription = "FAB Icon",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 2.dp)
                    .size(16.dp)
            )
            Text(
                text = "Browse Menu",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 2.dp),
                fontSize = 12.sp
            )
        }
    }
}


@Composable
fun RestaurantScreenTopAppBar(navController: NavController) {
    val iconPadding: Dp = 5.dp
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        IconButton(onClick = { navController.navigate("main_screen") }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back Arrow", tint = Color.Black)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                backgroundColor = Color.White,
                border = BorderStroke(0.5.dp, zLightGreyBorder),
                elevation = 0.dp,
                shape = CircleShape
            ) {
                //onClick = { navController.navigate("main_screen") }
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black,
                        modifier = Modifier.padding(iconPadding)
                    )

            }
            Card(
                backgroundColor = Color.White,
                border = BorderStroke(0.5.dp, zLightGreyBorder),
                elevation = 0.dp,
                shape = CircleShape,
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "Three Dots Icon",
                    tint = Color.Black,
                    modifier = Modifier.padding(iconPadding)
                )
            }
        }
    }
}


@Composable
fun RestaurantScreenInfoSection(
    restaurantName: String,
    restaurantType: String,
    restaurantLocation: String,
    deliveryDistanceInKms: Int,
    isMultipleLocations: Boolean = false,
    deliveryTimeInMins: Int,
    ratingText: Float?,
) {
    Card(
        backgroundColor = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start

            ) {

                Text(
                    text = restaurantName,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp
                )

                Text(
                    text = restaurantType,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 2.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "$restaurantLocation • ",
                        fontSize = 13.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(end = 3.dp)
                    )
                    Text(
                        text = "$deliveryDistanceInKms km",
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    if (isMultipleLocations) {
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Drop Down",
                            tint = Color.Red
                        )
                    }
                }

                Card(
                    shape = RoundedCornerShape(6.dp),
                    backgroundColor = Color(0xFFECECEC)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(3.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_timer_24),
                            contentDescription = "",
                            tint = Color(0xFF489547)
                        )
                        Text(
                            text = " $deliveryTimeInMins mins",
                            color = Color.DarkGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 1.dp)
                        )
                    }
                }
            }

            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp,
                backgroundColor = Color(0xFF489547)
            ) {
                Column {
                    //Rating
                    Box {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 10.dp)
                        ) {
                            Text(
                                text = "$ratingText",
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                Icons.Default.Star,
                                contentDescription = "Rating Star",
                                tint = Color.White,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                    //Number of Ratings
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 4.dp, horizontal = 8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "11.9k",
                                fontSize = 14.sp,
                                color = Color.DarkGray,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Reviews",
                                fontSize = 13.sp,
                                color = Color.DarkGray,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RestaurantScreenOfferScrollableRow() {
    Surface {
        LazyRow(
            modifier = Modifier
                .background(Color.White)
        ) {
            items(1) {
                OfferRowItem("50% OFF up to ₹100", "TRYNEW")
            }
            items(1) {
                OfferRowItem("Get up to ₹100 Paytm", "PAYTMFEAST")
            }
            items(1) {
                OfferRowItem("Flat ₹30 OFF", "HDFCFEAST")
            }
        }
    }
}

@Composable
fun DishList() {
    Column {
        DishCardItem("Singla's Special Spring Roll", "in Snacks", 239, "", 12,true, false, true, true, true, false, true, false)
        DishCardItem("Apollo 17 Pizza", "in Pizzas", 369, "Capsicum, Olives, Onions, Sweet Corns, Jalapenos", 20,true, true, false, true, true, true, false, true)
        DishCardItem("Achari Soya Chaap", "in Tandoori Starters", 239, "Soya Chaap in Achari Sause", 9,true, true, true, false, true, true, false, false)
        DishCardItem("Chole Bhature", "in Main Course", 149, "Dish with 2 Fried Bhature served with Chole", 30,true, true, true, true, false, true, true, true)
        DishCardItem("Shahi Paneer", "in Main Course", 249, "Dish with Paneer in Makani Sauce", 2, true, true, true, true, true, true, true, true)
        DishCardItem("Mix Vegetable", "in Main Course", 289, "", 24,true, true, true, true, true, false, true, false)
        DishCardItem("Stuffed Capsicum", "in Main Course", 239, "", 8,true, false, false, false, false, false, false, true)
        DishCardItem("Garlic Ginger Chilli Noodle", "in Noodles", 239, "", 7,false, true, false, false, false, false, false, false)
        DishCardItem("Dal Makhani", "in Main Course", 279, "", 29,false, false, true, false, false, false, true, true)
        DishCardItem("Aloo Parantha", "in Breads", 79, "", 23,false, false, false, true, false, false, true, false)
        DishCardItem("Aloo Kulcha", "in Breads", 89, "", 10,false, false, false, false, true, false, false, true)
        DishCardItem("Spl. Thali", "in Main Course", 359, "1 Parantha, Dal, Panner, Veg Raita, Rice, Salad", 24,false, false, false, false, false, true, false, false)
    }
}


@Composable
fun RestaurantScreen(
    offerPercentageText: Int?,
    offerUpToText: Int?,
    restaurantName: String,
    restaurantType: String,
    restaurantLocation: String,
    deliveryDistanceInKms: Int,
    isMultipleLocations: Boolean = false,
    deliveryTimeInMins: Int,
    isPureVegetarian: Boolean = false,
    ratingText: Float?,
    navController: NavController
) {
    Scaffold(
        backgroundColor = zSystemTopAppBarBgColor,
        bottomBar = {
            RestaurantScreenBottomBar(
                offerPercentageText = offerPercentageText,
                offerUpToText = offerUpToText
            )
        },
        floatingActionButton = { RestaurantScreenFAB() },
        floatingActionButtonPosition = FabPosition.Center,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .statusBarsPadding(),
                elevation = 0.dp,
                backgroundColor = Color.White,

            ) {
                RestaurantScreenTopAppBar(navController = navController)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
        ) {
            RestaurantScreenInfoSection(
                restaurantName,
                restaurantType,
                restaurantLocation,
                deliveryDistanceInKms,
                isMultipleLocations,
                deliveryTimeInMins,
                ratingText
            )
            RestaurantScreenOfferScrollableRow()
            DishList()
        }
    }
}
