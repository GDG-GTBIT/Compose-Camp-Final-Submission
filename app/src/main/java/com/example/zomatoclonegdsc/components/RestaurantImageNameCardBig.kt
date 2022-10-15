package com.example.zomatoclonegdsc.screen.homeScreen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclonegdsc.R
import com.example.zomatoclonegdsc.ui.theme.zBlueColor
import com.example.zomatoclonegdsc.ui.theme.zGreenColor
import com.example.zomatoclonegdsc.ui.theme.zRedColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RestaurantImageNameCardBig(
    @DrawableRes image: Int,
    offerPercentageText: Int?,
    offerUpToText: Int?,
    deliveryTimeMin: Int,
    deliveryDistanceInKms: Int,
    ratingText: Float?,
    restaurantName: String,
    restaurantType: String,
    closingTimeMin: Int,
    costForTwoInINR: Int,
    isPureVegetarian: Boolean = false,
    isPromoted: Boolean = false,
    isClosesSoon: Boolean = false,
    isRecycleFriendly: Boolean = false,
    isDeliveryTime: Boolean = true,
    onNextButtonClicked: () -> Unit = {},
) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp)
            .padding(vertical = 6.dp, horizontal = 16.dp),
        onClick = {
            onNextButtonClicked()
        }
    ) {
        Column {
            ImageBigCard(
                image = image,
                offerPercentageText = offerPercentageText,
                offerUpToText = offerUpToText,
                deliveryTimeMin = deliveryTimeMin,
                deliveryDistanceInKms = deliveryDistanceInKms,
                isPureVegetarian = isPureVegetarian,
                isPromoted = isPromoted,
                isDeliveryTime = isDeliveryTime
            )
            ContentBigCard(
                ratingText = ratingText,
                restaurantName = restaurantName,
                restaurantType = restaurantType,
                closingTimeMin = closingTimeMin,
                costForTwoInINR = costForTwoInINR,
                isClosesSoon = isClosesSoon,
                isRecycleFriendly = isRecycleFriendly
            )
        }
    }
}

@Composable
fun ImageBigCard(
    @DrawableRes image: Int,
    offerPercentageText: Int?,
    offerUpToText: Int?,
    deliveryTimeMin: Int,
    deliveryDistanceInKms: Int,
    isPureVegetarian: Boolean = false,
    isPromoted: Boolean = false,
    isDeliveryTime: Boolean = true
) {
    var isFavourite by remember {
        mutableStateOf(false)
    }


    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .height((LocalConfiguration.current.screenWidthDp / 1.8).dp)
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(R.string.restaurant_image),
            contentScale = ContentScale.FillBounds
        )

        Column {
            if (isPureVegetarian) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(zGreenColor.copy(0.8f)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.burger),
                        contentDescription = stringResource(R.string.pure_veg_restaurant),
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = stringResource(R.string.pure_veg_restaurant),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.height((LocalConfiguration.current.screenWidthDp / 1.5).dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .alpha(0.6f)
                            .background(
                                if (isPromoted) {
                                    Color.Black
                                } else {
                                    Color.Transparent
                                }
                            )
                    ) {
                        Text(
                            text = stringResource(R.string.promoted_text),
                            fontSize = 10.sp,
                            modifier = Modifier
                                .alpha(0.8f)
                                .padding(vertical = 1.dp, horizontal = 3.dp),
                            color = if (isPromoted) {
                                Color.White
                            } else {
                                Color.Transparent
                            }
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .clickable { isFavourite = !isFavourite },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(
                                if (isFavourite) {
                                    R.drawable.favorite_filled
                                } else {
                                    R.drawable.favorite_border
                                }
                            ),
                            contentDescription = stringResource(R.string.like_button_text),
                            tint = Color.Red,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(end = 10.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Card(
                        shape = RoundedCornerShape(topEnd = 6.dp, bottomEnd = 6.dp),
                        backgroundColor = zBlueColor,
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 3.dp, horizontal = 7.dp),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.percentage_vector),
                                contentDescription = stringResource(R.string.offer_percentage),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(15.dp)
                            )
                            Column {
                                Text(
                                    text = "${offerPercentageText.toString()}% OFF",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(start = 2.dp)
                                )
                                Text(
                                    text = "Up to ₹${offerUpToText.toString()}",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(start = 2.dp)
                                )
                            }
                        }
                    }
                    Card(
                        shape = RoundedCornerShape(6.dp),
                        backgroundColor = Color.White
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(vertical = 3.dp, horizontal = 4.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_timer_24),
                                contentDescription = "",
                                tint = zGreenColor
                            )
                            var deliveryText: String
                            if(isDeliveryTime) {
                                deliveryText = " $deliveryTimeMin mins | $deliveryDistanceInKms km";
                            } else {
                                deliveryText = " $deliveryDistanceInKms km";
                            }
                            Text(
                                text = deliveryText,
                                color = Color.DarkGray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(start = 1.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ContentBigCard(
    ratingText: Float?,
    restaurantName: String,
    restaurantType: String,
    closingTimeMin: Int?,
    costForTwoInINR: Int,
    isClosesSoon: Boolean = false,
    isRecycleFriendly: Boolean = false
) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = restaurantName,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                Text(
                    text = restaurantType,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                if (isClosesSoon) {
                    Text(
                        text = "Closes in $closingTimeMin Mins",
                        color = zRedColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(zGreenColor)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(vertical = 3.dp, horizontal = 5.dp)
                    ) {
                        Text(
                            text = ratingText.toString(),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(end = 1.dp),
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.star_filled),
                            contentDescription = "Rating",
                            tint = Color.White,
                            modifier = Modifier
                                .size(14.dp)
                        )
                    }
                }
                Text(
                    text = "₹$costForTwoInINR for two",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
        if (isRecycleFriendly) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                color = Color.LightGray,
                thickness = 0.5.dp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.recycle_png),
                    contentDescription = stringResource(R.string.recycle),
                    tint = zGreenColor,
                    modifier = Modifier.size(15.dp)
                )
                Text(
                    modifier = Modifier.padding(3.dp),
                    text = stringResource(R.string.zomato_recycles_text),
                    fontSize = 10.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
