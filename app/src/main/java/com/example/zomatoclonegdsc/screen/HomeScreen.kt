package com.example.zomatoclonegdsc.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zomatoclonegdsc.R
import com.example.zomatoclonegdsc.components.BottomNavBar
import com.example.zomatoclonegdsc.components.FilterRowCard
import com.example.zomatoclonegdsc.components.TopAppBarComposable
import com.example.zomatoclonegdsc.data.HomeScreenFilterItems
import com.example.zomatoclonegdsc.data.getAllHomeScreenFilterItems
import com.example.zomatoclonegdsc.navigation.Screen
import com.example.zomatoclonegdsc.screen.homeScreen.components.RestaurantImageNameCardBig
import com.example.zomatoclonegdsc.ui.theme.*
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun SearchTextField(
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit,
    fontSize: TextUnit = MaterialTheme.typography.body2.fontSize,
    borderStrokeSize: Dp = 0.5.dp,
    borderStrokeColor: Color = Color.LightGray,
    placeholder: String
) {
    val bgColor = zSearchBarBgColor
    Surface(
        color = bgColor,
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(borderStrokeSize, borderStrokeColor)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                cursorBrush = SolidColor(Color.DarkGray),
                textStyle = LocalTextStyle.current.copy(
                    color = Color.Black,
                    fontSize = fontSize
                ),
                decorationBox = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(5.dp)
                    ) {
                        if (leadingIcon != null) leadingIcon()
                        Box(Modifier.weight(1f)) {
                            if (value.isEmpty()) Text(
                                placeholder,
                                style = LocalTextStyle.current.copy(
                                    color = Color.DarkGray,
                                    fontSize = fontSize
                                )
                            )
                        }
                        if (trailingIcon != null) trailingIcon()
                    }
                },
            )
        }
    }
}

@Composable
fun AppMainSearchTextField() {
    var textValue by remember { mutableStateOf("") }
    val iconSize: Dp = 20.dp

    SearchTextField(
        placeholder = "Restaurant name or a dish...",
        value = textValue,
        onValueChange = { textValue = it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Button",
                tint = zRedColor,
                modifier = Modifier.padding(horizontal = 3.dp)
            )
        },
        trailingIcon = {
            Row() {
                Divider(
                    color = zDarkGray,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(horizontal = 5.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.mic_png),
                    contentDescription = "Mic Button",
                    tint = zRedColor,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(iconSize)
                )
            }
        }
    )
}

@Composable
fun HomeScreenFilterItemRow(
    categories: List<HomeScreenFilterItems>
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
fun CircularFoodItems(title: String, imageResource: Int) {
    Column(modifier = Modifier.width(90.dp)) {
        Image(painter = painterResource(id = imageResource),
            contentDescription = title,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        )
        Text(
            text = title,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            modifier = Modifier.fillMaxWidth().padding(top = 0.dp)

        )
    }
}


@Composable
fun RestaurantsHomeScreenCircleLogoGrid() {
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
                CircularFoodItems("Sweets", R.drawable.sweets)
                CircularFoodItems("Rolls", R.drawable.rolls)
                CircularFoodItems("Chicken", R.drawable.chicken)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                CircularFoodItems("Momos", R.drawable.momos)
                CircularFoodItems("Pizza", R.drawable.pizza)
                CircularFoodItems("Burger", R.drawable.burger)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                CircularFoodItems("Chaat", R.drawable.chaat)
                CircularFoodItems("Noodles", R.drawable.noodles)
                CircularFoodItems("Biryani", R.drawable.biryani)
            }
        }
        TextButton(colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black), onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "See More", fontSize = 10.sp)
            Image(painter = painterResource(
                id = R.drawable.expand_more),
                contentDescription = "Expand More",
                modifier = Modifier.width(12.dp)
            )
        }
    }
}

@Composable
fun MultipleHomeScreenRestroCards(noOfRestaurantsAround: Int, navController: NavController) {
    Column {
        Text(
            text = "$noOfRestaurantsAround restaurants around you",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp, top = 10.dp, bottom = 16.dp)
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 60,
            offerUpToText = 120,
            deliveryTimeMin = 36,
            deliveryDistanceInKms = 2,
            ratingText = 4.2f,
            restaurantName = "Singla's",
            restaurantType = "North Indian, Sweets, Chinese",
            closingTimeMin = 120,
            costForTwoInINR = 350,
            isPureVegetarian = true,
            isPromoted = true,
            isClosesSoon = false,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 20,
            offerUpToText = 50,
            deliveryTimeMin = 46,
            deliveryDistanceInKms = 7,
            ratingText = 4.0f,
            restaurantName = "ChopNCook",
            restaurantType = "North Indian, Chinese",
            closingTimeMin = 20,
            costForTwoInINR = 250,
            isPureVegetarian = false,
            isPromoted = true,
            isClosesSoon = true,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 10,
            offerUpToText = 50,
            deliveryTimeMin = 30,
            deliveryDistanceInKms = 2,
            ratingText = 4.3f,
            restaurantName = "Domino's Pizza",
            restaurantType = "Pizza, Fast Food",
            closingTimeMin = 60,
            costForTwoInINR = 400,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 50,
            offerUpToText = 100,
            deliveryTimeMin = 21,
            deliveryDistanceInKms = 1,
            ratingText = 4.2f,
            restaurantName = "Haldiram's",
            restaurantType = "North Indian, South Indian, Chinese",
            closingTimeMin = 20,
            costForTwoInINR = 300,
            isPureVegetarian = true,
            isPromoted = false,
            isClosesSoon = true,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 20,
            offerUpToText = 50,
            deliveryTimeMin = 29,
            deliveryDistanceInKms = 1,
            ratingText = 3.7f,
            restaurantName = "Burger King",
            restaurantType = "Burger, Fast Food, Street Food",
            closingTimeMin = 50,
            costForTwoInINR = 250,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 10,
            offerUpToText = 40,
            deliveryTimeMin = 20,
            deliveryDistanceInKms = 1,
            ratingText = 4.1f,
            restaurantName = "Hira Sweets",
            restaurantType = "Sweets, North Indian, South Indian",
            closingTimeMin = 30,
            costForTwoInINR = 300,
            isPureVegetarian = true,
            isPromoted = true,
            isClosesSoon = true,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 60,
            offerUpToText = 150,
            deliveryTimeMin = 22,
            deliveryDistanceInKms = 3,
            ratingText = 4.1f,
            restaurantName = "Dough & Cream",
            restaurantType = "Fast Food, North Indian",
            closingTimeMin = 90,
            costForTwoInINR = 250,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 10,
            offerUpToText = 40,
            deliveryTimeMin = 31,
            deliveryDistanceInKms = 4,
            ratingText = 4.1f,
            restaurantName = "Kwality Dhaba",
            restaurantType = "North Indian, Chinese, Rolls",
            closingTimeMin = 50,
            costForTwoInINR = 250,
            isPureVegetarian = true,
            isPromoted = false,
            isClosesSoon = true,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 60,
            offerUpToText = 120,
            deliveryTimeMin = 58,
            deliveryDistanceInKms = 8,
            ratingText = 4.6f,
            restaurantName = "Miss Nora",
            restaurantType = "Chinese, Sushi, Thai",
            closingTimeMin = 50,
            costForTwoInINR = 600,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
        RestaurantImageNameCardBig(
            image = R.drawable.food,
            offerPercentageText = 60,
            offerUpToText = 150,
            deliveryTimeMin = 42,
            deliveryDistanceInKms = 4,
            ratingText = 3.7f,
            restaurantName = "Ovenstory Pizza",
            restaurantType = "Pizza, Fast Food",
            closingTimeMin = 50,
            costForTwoInINR = 250,
            isPureVegetarian = false,
            isPromoted = false,
            isClosesSoon = false,
            isRecycleFriendly = true,
            onNextButtonClicked = { navController.navigate(Screen.RestaurantScreen.route) },
        )
    }
}

@Composable
fun HomeScreen(navController: NavController) {
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
            HomeScreenFilterItemRow(categories = getAllHomeScreenFilterItems())
            RestaurantsHomeScreenCircleLogoGrid()
            MultipleHomeScreenRestroCards(noOfRestaurantsAround = 371, navController = navController)
        }
    }
}