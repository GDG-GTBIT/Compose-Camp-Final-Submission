package com.example.zomatoclonegdsc.data

import com.example.zomatoclonegdsc.R

enum class ZomalandCities(
    val title: String,
    val date: String,
    val imageLink: Int,
) {
    PUNE(
        title = "Pune",
        date = "Nov 05-06",
        imageLink = R.drawable.pune
    ),
    MUMBAI(
        title = "Mumbai",
        date = "Nov 12-13",
        imageLink = R.drawable.mumbai
    ),
    AHMEDABAD(
        title = "Ahmedabad",
        date = "Dec 26-27",
        imageLink = R.drawable.ahemdabad
    ),
    DELHI(
        title = "New Delhi",
        date = "Dev 17-18",
        imageLink = R.drawable.delhi
    ),
    HYDERABAD(
        title = "Hyderabad",
        date = "Jan 21-22",
        imageLink = R.drawable.hyderabad
    ),
    BENGALURU(
        title = "Bengaluru",
        date = "Feb 04-05",
        imageLink = R.drawable.bengaluru
    ),
    KOLKATA(
        title = "Pune",
        date = "Feb 25-26",
        imageLink = R.drawable.kolkata
    ),
}

fun getAllZomalandCities(): List<ZomalandCities> {
    return listOf(
        ZomalandCities.PUNE,
        ZomalandCities.MUMBAI,
        ZomalandCities.AHMEDABAD,
        ZomalandCities.DELHI,
        ZomalandCities.HYDERABAD,
        ZomalandCities.BENGALURU,
        ZomalandCities.KOLKATA
    )
}
