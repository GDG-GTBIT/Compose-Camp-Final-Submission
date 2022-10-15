package com.example.zomatoclonegdsc.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

enum class DiningScreenFilterItems(
    val text: String,
    val leadingIcon: ImageVector? = null,
    val trailingIcon: ImageVector? = null
) {
    SORT(
        text = "Sort",
        leadingIcon = Icons.Default.List,
        trailingIcon = Icons.Filled.ArrowDropDown,
    ),
    LIKES(
        text = "Likes"
    ),
    NEAREST(
        text = "Nearest"
    ),
    RATING_4_PLUS(
        text = "Rating 4.0+"
    ),
    BOOK_TABLE(
        text = "Book Table"
    ),
    CUISINES(
        text = "Cuisines",
        trailingIcon = Icons.Filled.ArrowDropDown
    ),
    OUTDOOR_SEATING(
        text = "Outdoor Seating"
    ),
    SERVES_ALCOHOL(
        text = "Servers Alcohol",
    ),
    PURE_VEG(
    text = "Pure Veg",
    ),
    OPEN_NOW(
        text = "Open Now",
    ),
    MORE(
        text = "More",
        trailingIcon = Icons.Filled.ArrowDropDown
    ),
    CAFES(
        text = "Cafés",
    )
}

fun getAllDiningScreenFilterItems(): List<DiningScreenFilterItems> {
    return listOf(
        DiningScreenFilterItems.SORT,
        DiningScreenFilterItems.LIKES,
        DiningScreenFilterItems.NEAREST,
        DiningScreenFilterItems.RATING_4_PLUS,
        DiningScreenFilterItems.BOOK_TABLE,
        DiningScreenFilterItems.CUISINES,
        DiningScreenFilterItems.OUTDOOR_SEATING,
        DiningScreenFilterItems.SERVES_ALCOHOL,
        DiningScreenFilterItems.PURE_VEG,
        DiningScreenFilterItems.OPEN_NOW,
        DiningScreenFilterItems.MORE,
        DiningScreenFilterItems.CAFES
    )
}
