package com.example.zomatoclonegdsc.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclonegdsc.R
import com.example.zomatoclonegdsc.ui.theme.*

@Composable
fun DishCardItem(
    dish: String = "Shahi Paneer",
    recommendedWhere: String = "in Main Course",
    price: Int = 150,
    dishDescription: String = "",
    noOfRatings: Int = 10,
    isVegetarianDish: Boolean = false,
    isBestSeller: Boolean = false,
    isRecommended: Boolean = false,
    isRatingAvailable: Boolean = false,
    isMustTry: Boolean = false,
    isDishDescriptionAvailable: Boolean = false,
    isImageAvailable: Boolean = false,
    isCustomisable: Boolean = false
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp, start = 10.dp, end = 10.dp, bottom = 18.dp)
    ) {
        var isFavourite by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier.fillMaxWidth(0.64f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (isVegetarianDish) {
                    Icon(
                        painter = painterResource(id = R.drawable.veg_icon),
                        contentDescription = stringResource(R.string.veg_or_non_veg_icon),
                        tint = zVegIconColor,
                        modifier = Modifier.size(15.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.non_veg_icon),
                        contentDescription = stringResource(R.string.veg_or_non_veg_icon),
                        tint = zNonVegIconColor,
                        modifier = Modifier.size(15.dp)
                    )
                }
                if (isBestSeller) {
                    Card(
                        modifier = Modifier.padding(5.dp),
                        shape = RoundedCornerShape(4.dp),
                        border = BorderStroke(0.5.dp, zDishLabelTextColor),
                        backgroundColor = zDishLabelBg
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.bestseller),
                                color = zDishLabelTextColor,
                                modifier = Modifier.padding(1.dp),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
                if (isMustTry) {
                    Card(
                        modifier = Modifier.padding(5.dp),
                        shape = RoundedCornerShape(4.dp),
                        border = BorderStroke(0.5.dp, zDishLabelTextColor),
                        backgroundColor = zDishLabelBg
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.must_try),
                                color = zDishLabelTextColor,
                                modifier = Modifier.padding(1.dp),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
            Text(
                text = dish,
                color = zBlack,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            if (isRecommended) {
                Text(
                    text = recommendedWhere,
                    color = zDarkGray,
                    fontSize = 11.sp
                )
            }
            Text(
                text = "₹" + price,
                color = zBlack,
                fontSize = 14.sp
            )
            if (isDishDescriptionAvailable) {
                Text(
                    text = dishDescription,
                    color = zDarkGray,
                    fontSize = 14.sp,
                    maxLines = 2
                )
            }
            if (isRatingAvailable) {
                Card(
                    modifier = Modifier.padding(vertical = 5.dp),
                    shape = RoundedCornerShape(3.dp),
                    border = BorderStroke(0.5.dp, zRatingCardYellowBorder),
                    backgroundColor = zRatingCardYellowBg
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(2.dp)
                    ) {
                        for (i in 1..5) {
                            Icon(
                                painter = painterResource(id = R.drawable.star_filled),
                                contentDescription = "Rating Star $i",
                                tint = zRatingCardYellowBorder,
                                modifier = Modifier.size(12.dp)
                            )
                        }
                       Text(
                           text = noOfRatings.toString(),
                           fontSize = 10.sp,
                           color = zBlack,
                           modifier = Modifier.padding(horizontal = 2.dp),
                           fontWeight = FontWeight.SemiBold
                       )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(45.dp))
                    .background(zWhite)
                    .alpha(0.8f)
                    .clickable { isFavourite = !isFavourite },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(
                        if (isFavourite) {
                            R.drawable.favorite_filled
                        } else {
                            R.drawable.favourite_border
                        }
                    ),
                    contentDescription = stringResource(R.string.like_button_text),
                    tint = Color.Red,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
        DishImageColumn(isImageAvailable, isCustomisable)
    }
}

@Composable
fun DishImageColumn(
    isImageAvailable: Boolean = false,
    isCustomisable: Boolean = false
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        if (isImageAvailable) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height((LocalConfiguration.current.screenWidthDp / 3.8).dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dish_img),
                    contentDescription = "Dish Image",
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(0.5.dp, zRedColor),
            backgroundColor = zItemAddButtonBg
        ) {
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier.padding(2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "ADD",
                        fontSize = 20.sp,
                        color = zRedColor,
                        modifier = Modifier
                            .padding(6.dp),
                        fontWeight = FontWeight.Bold
                    )
                }

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = zRedColor,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        if (isCustomisable) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "customisable",
                    color = zDarkGray,
                    fontSize = 11.sp
                )
            }
        }
    }
}
